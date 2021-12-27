package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.Mascota;
import co.com.sofka.domain.mascota.commands.AsignarDuenio;
import co.com.sofka.domain.mascota.events.DuenioAsignado;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.DuenioId;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.mascota.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class AsignarDuenioUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void AsignarDuenio(){
        //Arrange
        MascotaId mascotaId = MascotaId.of("xxx");
        DuenioId duenioId = DuenioId.of("yyy");
        Nombre nombre = new Nombre("Juan");
        Telefono telefono = new Telefono("3122345");
        Edad edad = new Edad(19);

        var command = new AsignarDuenio(mascotaId, duenioId, nombre, telefono, edad);
        var useCase = new AsignarDuenioUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(mascotaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (DuenioAsignado) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");

    }

    private List<DomainEvent> events() {
        return List.of(new MascotaCreada(
                new Nombre("Harry"),
                new Edad(2)
        ));
    }

}