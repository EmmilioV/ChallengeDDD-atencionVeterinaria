package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procedimiento.Procedimiento;
import co.com.sofka.domain.procedimiento.commands.AniadirExamen;

public class AniadirExamenUseCase extends UseCase<RequestCommand<AniadirExamen>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AniadirExamen> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getProcedimientoId(), retrieveEvents());

        procedimiento.aniadirExamen(command.getEntityId(), command.getNombre(), command.getPrecio());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
