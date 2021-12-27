package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.commands.CrearMascota;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.MascotaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearMascotaUseCaseTest {
    @Test
    public void crearMascota(){
        //Arrange
        MascotaId mascotaId = MascotaId.of("xxxx");
        Nombre nombre = new Nombre("Harry");
        Edad edad = new Edad(3);

        var command = new CrearMascota(mascotaId, nombre, edad);
        var useCase = new CrearMascotaUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        MascotaCreada event = (MascotaCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("Harry", event.getNombre().value());
        Assertions.assertEquals("3", event.getEdad().value().toString());
    }
}