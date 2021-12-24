package co.com.sofka.mascota.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;

import java.util.UUID;

public class MascotaCreada extends DomainEvent {
    private final Nombre nombre;
    private final Edad edad;

    public MascotaCreada(Nombre nombre, Edad edad) {
        super("sofka.mascota.mascotaCreada");
        this.nombre = nombre;
        this.edad = edad;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
