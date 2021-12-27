package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mascota.Mascota;
import co.com.sofka.domain.mascota.commands.AniadirEnfermedad;

public class AniadirEnfermedadUseCase extends UseCase<RequestCommand<AniadirEnfermedad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AniadirEnfermedad> requestCommand) {
        var command = requestCommand.getCommand();
        var mascota = Mascota.from(command.getMascotaId(), retrieveEvents());

        mascota.aniadirEnfermedad(command.getEntityId(), command.getNombre(), command.getDetalle());

        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
