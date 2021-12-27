package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.puntoDeAtencion.PuntoDeAtencion;
import co.com.sofka.domain.puntoDeAtencion.commands.ActualizarUbicacion;

public class ActualizarUbicacionPuntoDeAtencionUseCase extends UseCase<RequestCommand<ActualizarUbicacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarUbicacion> requestCommand) {
        var command = requestCommand.getCommand();
        var puntoDeAtencion = PuntoDeAtencion.from(command.getPuntoDeAtencionId(), retrieveEvents());

        puntoDeAtencion.actualizarUbicacion(command.getUbicacion());

        emit().onResponse(new ResponseEvents(puntoDeAtencion.getUncommittedChanges()));
    }
}
