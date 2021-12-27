package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Fecha;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.procedimiento.commands.AniadirMedicamento;
import co.com.sofka.domain.procedimiento.events.MedicamentoAniadido;
import co.com.sofka.domain.procedimiento.events.ProcedimientoCreado;
import co.com.sofka.domain.procedimiento.values.Laboratorio;
import co.com.sofka.domain.procedimiento.values.MedicamentoId;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AniadirMedicamentoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void AniadirMedicamento(){
        //Arrange
        ProcedimientoId procedimientoId = ProcedimientoId.of("xxx");
        MedicamentoId medicamentoId = MedicamentoId.of("yyy");
        Laboratorio laboratorio = new Laboratorio("MyG");
        Nombre nombre = new Nombre("Acetaminofen");
        Precio precio = new Precio(500.0);

        var command = new AniadirMedicamento(procedimientoId, medicamentoId, nombre, laboratorio, precio);
        var useCase = new AniadirMedicamentoUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(procedimientoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (MedicamentoAniadido) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");
        Assertions.assertEquals("yyy", command.getEntityId().value());
        Assertions.assertEquals("500.0", command.getPrecio().value().toString());
        Assertions.assertEquals("MyG", command.getLaboratorio().value());
        Assertions.assertEquals("Acetaminofen", command.getNombre().value());
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