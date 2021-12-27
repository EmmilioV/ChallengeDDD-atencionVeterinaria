package co.com.sofka.domain.puntoDeAtencion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.puntoDeAtencion.values.Ubicacion;

public class PuntoDeAtencionCreado extends DomainEvent {
    private final Nombre nombre;
    private final Ubicacion ubicacion;

    public PuntoDeAtencionCreado(Nombre nombre, Ubicacion ubicacion) {
        super("sofka.puntoDeAtencion.puntoDeAtencionCreado");
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
