package co.com.sofka.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.procedimiento.values.ExamenId;

public class ExamenAniadido extends DomainEvent {
    private final ExamenId entityId;
    private final Nombre nombre;
    private final Precio precio;

    public ExamenAniadido(ExamenId entityId, Nombre nombre, Precio precio) {
        super("sofka.procedimiento.examenAniadido");
        this.entityId = entityId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ExamenId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
