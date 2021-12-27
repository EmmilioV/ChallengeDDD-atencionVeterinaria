package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.commands.CrearMascota;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.puntoDeAtencion.commands.CrearPuntoDeAtencion;
import co.com.sofka.domain.puntoDeAtencion.events.PuntoDeAtencionCreado;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.domain.puntoDeAtencion.values.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearPuntoDeAtencionUseCaseTest {
    @Test
    public void CrearPuntoDeAtencion(){
        //Arrange
        PuntoDeAtencionId puntoDeAtencionId = PuntoDeAtencionId.of("yyyy");
        Nombre nombre = new Nombre("Buenos aires");
        Ubicacion ubicacion = new Ubicacion("medellin");

        var command = new CrearPuntoDeAtencion(puntoDeAtencionId, nombre, ubicacion);
        var useCase = new CrearPuntoDeAtencionUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        PuntoDeAtencionCreado event = (PuntoDeAtencionCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("yyyy", event.aggregateRootId());
        Assertions.assertEquals("Buenos aires", event.getNombre().value());
    }
}