package co.com.sofka.mascota.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.DuenioId;
import co.com.sofka.mascota.values.Telefono;

public class DuenioAsignado extends DomainEvent {
    private final DuenioId entityId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Edad edad;

    public DuenioAsignado(DuenioId entityId, Nombre nombre, Telefono telefono, Edad edad) {
        super("sofka.mascota.duenioAsignado");
        this.entityId = entityId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public DuenioId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Edad getEdad() {
        return edad;
    }
}
