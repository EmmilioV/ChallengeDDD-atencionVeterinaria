package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.generic.Detalle;
import co.com.sofka.generic.Fecha;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.MascotaId;
import co.com.sofka.procedimiento.events.ProcedimientoCreado;
import co.com.sofka.procedimiento.values.ProcedimientoId;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;

import java.util.Set;

public class Procedimiento extends AggregateEvent<ProcedimientoId> {

    protected PuntoDeAtencionId puntoDeAtencionId;
    protected MascotaId mascotaId;
    protected Fecha fecha;
    protected Nombre nombre;
    protected Detalle detalle;
    protected Factura factura;
    protected Set<Medicamento> medicamentos;
    protected Set<Examen> examenes;

    public Procedimiento(ProcedimientoId entityId, PuntoDeAtencionId puntoDeAtencionId, MascotaId mascotaId, Fecha fecha, Nombre nombre) {
        super(entityId);
        appendChange(new ProcedimientoCreado(puntoDeAtencionId, mascotaId, fecha, nombre)).apply();
    }
}
