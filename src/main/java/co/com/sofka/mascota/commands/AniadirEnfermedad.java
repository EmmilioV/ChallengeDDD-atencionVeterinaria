package co.com.sofka.mascota.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Detalle;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.EnfermedadId;
import co.com.sofka.mascota.values.MascotaId;

public class AniadirEnfermedad extends Command {
    private final MascotaId mascotaId;
    private final EnfermedadId entityId;
    private final Nombre nombre;
    private final Detalle detalle;

    public AniadirEnfermedad(MascotaId mascotaId, EnfermedadId entityId, Nombre nombre, Detalle detalle) {
        this.mascotaId = mascotaId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public MascotaId getMascotaId() {
        return mascotaId;
    }

    public EnfermedadId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
