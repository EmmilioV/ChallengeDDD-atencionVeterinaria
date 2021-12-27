package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.puntoDeAtencion.commands.ActualizarUbicacion;
import co.com.sofka.domain.puntoDeAtencion.events.PuntoDeAtencionCreado;
import co.com.sofka.domain.puntoDeAtencion.events.UbicacionActualizada;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.domain.puntoDeAtencion.values.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class ActualizarUbicacionPuntoDeAtencionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void ActualizarUbicacion(){
        //Arrange
        PuntoDeAtencionId puntoDeAtencionId = PuntoDeAtencionId.of("xxx");
        Ubicacion ubicacion = new Ubicacion("Carrera 39 #64-2");

        var command = new ActualizarUbicacion(puntoDeAtencionId, ubicacion);
        var useCase = new ActualizarUbicacionPuntoDeAtencionUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(puntoDeAtencionId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (UbicacionActualizada) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");
        Assertions.assertEquals("Carrera 39 #64-2", event.getUbicacion().value());

    }

    private List<DomainEvent> events() {
        return List.of(new PuntoDeAtencionCreado(
                    new Nombre("Veterinaria buenos aires"),
                    new Ubicacion("cl")
                )
        );
    }
}