package co.com.sofka.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Fecha;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.MascotaId;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;

public class ProcedimientoCreado extends DomainEvent {
    private final PuntoDeAtencionId puntoDeAtencionId;
    private final MascotaId mascotaId;
    private final Fecha fecha;
    private final Nombre nombre;

    public ProcedimientoCreado(PuntoDeAtencionId puntoDeAtencionId, MascotaId mascotaId, Fecha fecha, Nombre nombre) {
        super("sofka.procedimiento.procedimientoCreado");
        this.puntoDeAtencionId = puntoDeAtencionId;
        this.mascotaId = mascotaId;
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public PuntoDeAtencionId getPuntoDeAtencionId() {
        return puntoDeAtencionId;
    }

    public MascotaId getMascotaId() {
        return mascotaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
