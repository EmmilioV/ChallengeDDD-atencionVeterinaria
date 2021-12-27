package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.commands.AsignarDuenio;
import co.com.sofka.domain.mascota.events.DuenioAsignado;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.DuenioId;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.mascota.values.Telefono;
import co.com.sofka.domain.puntoDeAtencion.PuntoDeAtencion;
import co.com.sofka.domain.puntoDeAtencion.Veterinario;
import co.com.sofka.domain.puntoDeAtencion.commands.AgregarVeterinario;
import co.com.sofka.domain.puntoDeAtencion.events.PuntoDeAtencionCreado;
import co.com.sofka.domain.puntoDeAtencion.events.VeterinarioAgregado;
import co.com.sofka.domain.puntoDeAtencion.values.NumeroDeCedula;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.domain.puntoDeAtencion.values.Ubicacion;
import co.com.sofka.domain.puntoDeAtencion.values.VeterinarioId;
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
class AgregarVeterinarioUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void AgregarVeterinario(){
        //Arrange
        PuntoDeAtencionId puntoDeAtencionId = PuntoDeAtencionId.of("xxx");
        VeterinarioId veterinarioId = VeterinarioId.of("yyy");
        NumeroDeCedula numeroDeCedula = new NumeroDeCedula("10016872");
        Nombre nombre = new Nombre("Diego");
        Edad edad = new Edad(19);

        var command = new AgregarVeterinario(puntoDeAtencionId, veterinarioId, numeroDeCedula, nombre, edad);
        var useCase = new AgregarVeterinarioUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(puntoDeAtencionId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (VeterinarioAgregado) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");
        Assertions.assertEquals("Diego", event.getNombre().value());
        Assertions.assertEquals("10016872", event.getNumeroDeCedula().value());
        Assertions.assertEquals("19", event.getEdad().value().toString());
        Assertions.assertEquals("yyy", event.getEntityId().value());

    }

    private List<DomainEvent> events() {
        return List.of(new PuntoDeAtencionCreado(
                new Nombre("Sana que sana buenos aires"),
                new Ubicacion("Medellin")
        ));
    }

}