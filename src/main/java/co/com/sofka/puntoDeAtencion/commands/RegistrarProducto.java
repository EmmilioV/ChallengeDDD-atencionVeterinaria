package co.com.sofka.puntoDeAtencion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Cantidad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.puntoDeAtencion.values.ProductoId;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;

public class RegistrarProducto extends Command {
    private final PuntoDeAtencionId puntoDeAtencionId;
    private final ProductoId entityId;
    private final Nombre nombre;
    private final Cantidad cantidad;
    private final Precio precio;

    public RegistrarProducto(PuntoDeAtencionId puntoDeAtencionId, ProductoId entityId, Nombre nombre, Cantidad cantidad, Precio precio) {
        this.puntoDeAtencionId = puntoDeAtencionId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public PuntoDeAtencionId getPuntoDeAtencionId() {
        return puntoDeAtencionId;
    }

    public ProductoId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public Precio getPrecio() {
        return precio;
    }
}
