package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.commands.AsignarDuenio;
import co.com.sofka.domain.mascota.commands.RegistrarCaracteristica;
import co.com.sofka.domain.mascota.events.CaracteristicaRegistrada;
import co.com.sofka.domain.mascota.events.DuenioAsignado;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrarCaracteristicaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void RegistrarCaracteristica(){
        //Arrange
        MascotaId mascotaId = MascotaId.of("xxx");
        CaracteristicaId caracteristicaId = CaracteristicaId.of("yyy");
        Raza raza = new Raza("Golden");
        Peso peso = new Peso(20.05);
        Tamanio tamanio = new Tamanio(Tamanio.Terminos.MEDIANO);
        Color color = new Color("Cafe dorado");

        var command = new RegistrarCaracteristica(mascotaId, caracteristicaId, raza, peso, tamanio, color);
        var useCase = new RegistrarCaracteristicaUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(mascotaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (CaracteristicaRegistrada) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");

    }

    private List<DomainEvent> events() {
        return List.of(new MascotaCreada(
                new Nombre("Harry"),
                new Edad(2)
        ));
    }
}