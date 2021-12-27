package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Detalle;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.commands.AniadirEnfermedad;
import co.com.sofka.domain.mascota.commands.AsignarDuenio;
import co.com.sofka.domain.mascota.events.DuenioAsignado;
import co.com.sofka.domain.mascota.events.EnfermedadAniadida;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.DuenioId;
import co.com.sofka.domain.mascota.values.EnfermedadId;
import co.com.sofka.domain.mascota.values.MascotaId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class AniadirEnfermedadUseCaseTest {


    @Mock
    DomainEventRepository repository;

    @Test
    public void aniadirEnfermedad(){

        //Arrange
        MascotaId mascotaId = MascotaId.of("xxx");
        EnfermedadId enfermedadId = EnfermedadId.of("yyy");
        Nombre nombre = new Nombre("Dermatitis");
        Detalle detalle = new Detalle("");

        var command = new AniadirEnfermedad(mascotaId, enfermedadId, nombre, detalle);
        var useCase = new AniadirEnfermedadUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(mascotaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (EnfermedadAniadida) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");

    }

    private List<DomainEvent> events() {
        return List.of(new MascotaCreada(
                new Nombre("Harry"),
                new Edad(2)
        ));
    }
}
