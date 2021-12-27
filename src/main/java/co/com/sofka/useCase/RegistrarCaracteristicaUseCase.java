package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mascota.Mascota;
import co.com.sofka.domain.mascota.commands.RegistrarCaracteristica;

public class RegistrarCaracteristicaUseCase extends UseCase<RequestCommand<RegistrarCaracteristica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RegistrarCaracteristica> requestCommand) {
        var command = requestCommand.getCommand();
        var mascota = Mascota.from(command.getMascotaId(), retrieveEvents());

        mascota.registrarCaracteristica(command.getEntityId(), command.getRaza(), command.getPeso(), command.getTamanio(), command.getColor());

        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
