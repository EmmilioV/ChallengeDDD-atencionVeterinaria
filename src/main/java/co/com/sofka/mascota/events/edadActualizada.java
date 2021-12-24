package co.com.sofka.mascota.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Edad;

public class edadActualizada extends DomainEvent {
    private final Edad edad;

    public edadActualizada(Edad edad) {
        super("sofka.mascota.edadActualizada");
        this.edad = edad;
    }

    public Edad getEdad() {
        return edad;
    }
}
