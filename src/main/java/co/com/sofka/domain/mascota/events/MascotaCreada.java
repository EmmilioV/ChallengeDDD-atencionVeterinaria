package co.com.sofka.domain.mascota.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;

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
