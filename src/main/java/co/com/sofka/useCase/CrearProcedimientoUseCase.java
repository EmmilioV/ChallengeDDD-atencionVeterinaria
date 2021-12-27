package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procedimiento.Procedimiento;
import co.com.sofka.domain.procedimiento.commands.CrearProcedimiento;

public class CrearProcedimientoUseCase extends UseCase<RequestCommand<CrearProcedimiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearProcedimiento> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = new Procedimiento(command.getEntityId(), command.getPuntoDeAtencionId(), command.getMascotaId(), command.getFecha(), command.getNombre());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
