package co.com.sofka.domain.puntoDeAtencion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.puntoDeAtencion.values.Ubicacion;

public class UbicacionActualizada extends DomainEvent {
    private final Ubicacion ubicacion;

    public UbicacionActualizada(Ubicacion ubicacion) {
        super("sofka.puntoDeAtencion.ubicacionActualizada");
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
