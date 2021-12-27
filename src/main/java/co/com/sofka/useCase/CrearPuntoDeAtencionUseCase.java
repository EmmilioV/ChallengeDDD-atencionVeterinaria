package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.puntoDeAtencion.PuntoDeAtencion;
import co.com.sofka.domain.puntoDeAtencion.commands.CrearPuntoDeAtencion;

public class CrearPuntoDeAtencionUseCase extends UseCase<RequestCommand<CrearPuntoDeAtencion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPuntoDeAtencion> requestCommand) {
        var command = requestCommand.getCommand();
        var puntoDeAtencion = new PuntoDeAtencion(command.getEntityId(), command.getNombre(), command.getUbicacion());

        emit().onResponse(new ResponseEvents(puntoDeAtencion.getUncommittedChanges()));
    }
}
