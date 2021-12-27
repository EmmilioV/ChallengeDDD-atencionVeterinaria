package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.mascota.Duenio;
import co.com.sofka.domain.mascota.Mascota;
import co.com.sofka.domain.mascota.commands.AsignarDuenio;

import java.util.Objects;

public class AsignarDuenioUseCase extends UseCase<RequestCommand<AsignarDuenio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarDuenio> requestCommand) {
        var command = requestCommand.getCommand();
        var mascota = Mascota.from(command.getMascotaId(), retrieveEvents());

        if(Objects.isNull(mascota.duenio()))
            throw new IllegalArgumentException("Ya la mascota tiene un dueño registrado");

        mascota.asignarDuenio(command.getEntityId(), command.getNombre(), command.getTelefono(), command.getEdad());

        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
