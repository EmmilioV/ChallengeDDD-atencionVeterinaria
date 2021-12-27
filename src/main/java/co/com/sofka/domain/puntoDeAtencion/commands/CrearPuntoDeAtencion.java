package co.com.sofka.domain.puntoDeAtencion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.domain.puntoDeAtencion.values.Ubicacion;

public class CrearPuntoDeAtencion extends Command {
    private final PuntoDeAtencionId entityId;
    private final Nombre nombre;
    private final Ubicacion ubicacion;

    public CrearPuntoDeAtencion(PuntoDeAtencionId entityId, Nombre nombre, Ubicacion ubicacion) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public PuntoDeAtencionId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
