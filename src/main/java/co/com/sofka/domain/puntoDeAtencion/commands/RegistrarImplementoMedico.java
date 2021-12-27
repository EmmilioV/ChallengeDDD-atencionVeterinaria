package co.com.sofka.domain.puntoDeAtencion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.Cantidad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.puntoDeAtencion.values.ImplementoMedicoId;
import co.com.sofka.domain.puntoDeAtencion.values.PuntoDeAtencionId;

public class RegistrarImplementoMedico extends Command {
    private final PuntoDeAtencionId puntoDeAtencionId;
    private final ImplementoMedicoId entityId;
    private final Nombre nombre;
    private final Cantidad cantidad;

    public RegistrarImplementoMedico(PuntoDeAtencionId puntoDeAtencionId, ImplementoMedicoId entityId, Nombre nombre, Cantidad cantidad) {
        this.puntoDeAtencionId = puntoDeAtencionId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public PuntoDeAtencionId getPuntoDeAtencionId() {
        return puntoDeAtencionId;
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
