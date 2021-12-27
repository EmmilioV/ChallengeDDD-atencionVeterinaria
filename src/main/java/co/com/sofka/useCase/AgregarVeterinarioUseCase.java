package co.com.sofka.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.puntoDeAtencion.PuntoDeAtencion;
import co.com.sofka.domain.puntoDeAtencion.Veterinario;
import co.com.sofka.domain.puntoDeAtencion.commands.AgregarVeterinario;

public class AgregarVeterinarioUseCase extends UseCase<RequestCommand<AgregarVeterinario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVeterinario> requestCommand) {
        var command = requestCommand.getCommand();
        var puntoDeAtencion = PuntoDeAtencion.from(command.getPuntoDeAtencionId(), retrieveEvents());

        if ((long) puntoDeAtencion.veterinarios().size() == 8){
            throw new BusinessException(puntoDeAtencion.identity().value(),"El punto de tanecion ha superado el tope de veterinarios");
        }

        puntoDeAtencion.agregarVeterinario(
                command.getEntityId(),
                command.getNumeroDeCedula(),
                command.getNombre(),
                command.getEdad()
        );

        emit().onResponse(new ResponseEvents(puntoDeAtencion.getUncommittedChanges()));
    }
}
