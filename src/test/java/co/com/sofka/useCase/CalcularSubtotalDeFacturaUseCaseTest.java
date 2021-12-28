package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Fecha;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.procedimiento.Examen;
import co.com.sofka.domain.procedimiento.Medicamento;
import co.com.sofka.domain.procedimiento.commands.CalcularSubtotalDeFactura;
import co.com.sofka.domain.procedimiento.commands.GenerarFactura;
import co.com.sofka.domain.procedimiento.events.FacturaGenerada;
import co.com.sofka.domain.procedimiento.events.ProcedimientoCreado;
import co.com.sofka.domain.procedimiento.events.SubtotalDeFacturaCalculado;
import co.com.sofka.domain.procedimiento.values.*;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalcularSubtotalDeFacturaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void calcularSubtotal(){
        //Arrange
        ProcedimientoId procedimientoId = ProcedimientoId.of("xxx");
        FacturaId facturaId = FacturaId.of("yyy");

        var command = new CalcularSubtotalDeFactura(procedimientoId, facturaId);
        var useCase = new CalcularSubtotalDeFacturaUseCase();

        //Act
        when(repository.getEventsBy("xxx")).thenReturn(events());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(procedimientoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (SubtotalDeFacturaCalculado) events.get(0);
        Mockito.verify(repository).getEventsBy("xxx");
        Assertions.assertEquals("yyy", command.getEntityId().value());
    }

    private List<DomainEvent> events() {
        Set<Medicamento> medicamentos = new HashSet<>();
        Set<Examen> examenes = new HashSet<>();
        Medicamento medicamento = new Medicamento(
                MedicamentoId.of("zzz"),
                new Nombre("Acetaminofen"),
                new Laboratorio("GyM"),
                new Precio(500.0)
        );
        Examen examen = new Examen(
                ExamenId.of("fff"),
                new Nombre("abc"),
                new Precio(2500.0)
        );
        medicamentos.add(medicamento);
        examenes.add(examen);
        return List.of(new ProcedimientoCreado(
                new PuntoDeAtencionId(),
                new MascotaId(),
                new Fecha(new Date()),
                new Nombre("Control de hematoma")
        ),
                new FacturaGenerada(
                        FacturaId.of("yyy"),
                        new Fecha(new Date()),
                        medicamentos,
                        examenes
                )
        );
    }

}