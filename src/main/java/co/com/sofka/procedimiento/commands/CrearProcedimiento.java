package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Fecha;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.MascotaId;
import co.com.sofka.procedimiento.values.ProcedimientoId;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;

public class CrearProcedimiento extends Command {
    private final ProcedimientoId entityId;
    private final PuntoDeAtencionId puntoDeAtencionId;
    private final MascotaId mascotaId;
    private final Fecha fecha;
    private final Nombre nombre;

    public CrearProcedimiento(ProcedimientoId entityId, PuntoDeAtencionId puntoDeAtencionId, MascotaId mascotaId, Fecha fecha, Nombre nombre) {
        this.entityId = entityId;
        this.puntoDeAtencionId = puntoDeAtencionId;
        this.mascotaId = mascotaId;
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public ProcedimientoId getEntityId() {
        return entityId;
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
