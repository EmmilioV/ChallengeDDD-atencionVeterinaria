package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.mascota.Mascota;
import co.com.sofka.domain.mascota.commands.CrearMascota;

public class CrearMascotaUseCase extends UseCase<RequestCommand<CrearMascota>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearMascota> requestCommand) {
        var command = requestCommand.getCommand();
        var mascota = new Mascota(
                    command.getEntityId(),
                    command.getNombre(),
                    command.getEdad()
                );
        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
