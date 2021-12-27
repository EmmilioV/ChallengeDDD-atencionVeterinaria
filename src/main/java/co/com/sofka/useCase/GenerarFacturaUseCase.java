package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procedimiento.Procedimiento;
import co.com.sofka.domain.procedimiento.commands.GenerarFactura;

public class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFactura> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getProcedimientoId(), retrieveEvents());

        procedimiento.generarFactura(command.getEntityId(), command.getFecha(), command.getMedicamentos(), command.getExamenes());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
