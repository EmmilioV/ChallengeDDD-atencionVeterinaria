package co.com.sofka.puntoDeAtencion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.puntoDeAtencion.values.Ubicacion;

public class ActualizarUbicacion extends Command {
    private final PuntoDeAtencionId puntoDeAtencionId;
    private final Ubicacion ubicacion;

    public ActualizarUbicacion(PuntoDeAtencionId puntoDeAtencionId, Ubicacion ubicacion) {
        this.puntoDeAtencionId = puntoDeAtencionId;
        this.ubicacion = ubicacion;
    }

    public PuntoDeAtencionId getPuntoDeAtencionId() {
        return puntoDeAtencionId;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
