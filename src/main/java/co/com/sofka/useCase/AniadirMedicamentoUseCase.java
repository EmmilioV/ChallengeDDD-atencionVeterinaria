package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procedimiento.Procedimiento;
import co.com.sofka.domain.procedimiento.commands.AniadirMedicamento;

public class AniadirMedicamentoUseCase extends UseCase<RequestCommand<AniadirMedicamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AniadirMedicamento> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getProcedimientoId(), retrieveEvents());

        procedimiento.aniadirMedicamento(command.getEntityId(), command.getNombre(), command.getLaboratorio(), command.getPrecio());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
