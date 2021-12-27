package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.*;
import co.com.sofka.domain.mascota.commands.AsignarDuenio;
import co.com.sofka.domain.mascota.events.DuenioAsignado;
import co.com.sofka.domain.mascota.events.MascotaCreada;
import co.com.sofka.domain.mascota.values.DuenioId;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.mascota.values.Telefono;
import co.com.sofka.domain.procedimiento.commands.AniadirExamen;
import co.com.sofka.domain.procedimiento.events.ExamenAniadido;
import co.com.sofka.domain.procedimiento.events.ProcedimientoCreado;
import co.com.sofka.domain.procedimiento.values.ExamenId;
import co.com.sofka.domain.procedimiento.values.ProcedimientoId;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AniadirExamenUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void AniadirExamen(){
        //Arrange
        ProcedimientoId procedimientoId = ProcedimientoId.of("xxx");
        ExamenId examenId = ExamenId.of("yyy");
        Nombre nombre = new Nombre("Radiografia pulmonar");
        Precio precio = new Precio(22000.00);

        var command = new AniadirExamen(procedimientoId, examenId, nombre, precio);
        var useCase = new AniadirExamenUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(procedimientoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (ExamenAniadido) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");
        Assertions.assertEquals("yyy", command.getEntityId().value());
        Assertions.assertEquals("22000.0", command.getPrecio().value().toString());
        Assertions.assertEquals("Radiografia pulmonar", command.getNombre().value());
    }

    private List<DomainEvent> events() {
        return List.of(new ProcedimientoCreado(
                new PuntoDeAtencionId(),
                new MascotaId(),
                new Fecha(new Date()),
                new Nombre("Control de hematoma")
        ));
    }

}