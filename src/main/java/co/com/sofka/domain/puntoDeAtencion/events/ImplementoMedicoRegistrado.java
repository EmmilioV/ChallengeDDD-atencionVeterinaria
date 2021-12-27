package co.com.sofka.domain.puntoDeAtencion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Cantidad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.puntoDeAtencion.values.ImplementoMedicoId;

public class ImplementoMedicoRegistrado extends DomainEvent {
    private final ImplementoMedicoId entityId;
    private final Nombre nombre;
    private final Cantidad cantidad;

    public ImplementoMedicoRegistrado(ImplementoMedicoId entityId, Nombre nombre, Cantidad cantidad) {
        super("sofka.puntoDeAtencion.implementoMedicoRegistrado");
        this.entityId = entityId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public ImplementoMedicoId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
