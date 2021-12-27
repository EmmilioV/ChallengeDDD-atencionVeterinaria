package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.Fecha;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.procedimiento.commands.CrearProcedimiento;
import co.com.sofka.domain.procedimiento.events.ProcedimientoCreado;
import co.com.sofka.domain.procedimiento.values.ProcedimientoId;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearProcedimientoUseCaseTest {

    @Test
    public void crearProcedimiento(){
        //Arrange
        ProcedimientoId procedimientoId = ProcedimientoId.of("xxxx");
        PuntoDeAtencionId puntoDeAtencionId =  PuntoDeAtencionId.of("yyy");
        MascotaId mascotaId = MascotaId.of("zzz");
        Fecha edad = new Fecha(new Date());
        Nombre nombre = new Nombre("Vacunacion");

        var command = new CrearProcedimiento(procedimientoId, puntoDeAtencionId, mascotaId, edad, nombre);
        var useCase = new CrearProcedimientoUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Asserts
        ProcedimientoCreado event = (ProcedimientoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyy", event.getPuntoDeAtencionId().value());
        Assertions.assertEquals("zzz", event.getMascotaId().value());
        Assertions.assertEquals("Vacunacion", event.getNombre().value());

    }

}