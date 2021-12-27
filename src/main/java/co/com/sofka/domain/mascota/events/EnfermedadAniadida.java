package co.com.sofka.domain.mascota.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Detalle;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.values.EnfermedadId;

public class EnfermedadAniadida extends DomainEvent {
    private final EnfermedadId entityId;
    private final Nombre nombre;
    private final Detalle detalle;

    public EnfermedadAniadida(EnfermedadId entityId, Nombre nombre, Detalle detalle) {
        super("sofka.mascota.enfermedadAniadida");
        this.entityId = entityId;
        this.nombre = nombre;
        this.detalle = detalle;
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
