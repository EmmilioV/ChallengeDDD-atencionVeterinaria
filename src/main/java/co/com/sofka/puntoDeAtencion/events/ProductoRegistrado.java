package co.com.sofka.puntoDeAtencion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Cantidad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.puntoDeAtencion.values.ProductoId;

public class ProductoRegistrado extends DomainEvent {
    private final ProductoId entityId;
    private final Nombre nombre;
    private final Cantidad cantidad;
    private final Precio precio;

    public ProductoRegistrado(ProductoId entityId, Nombre nombre, Cantidad cantidad, Precio precio) {
        super("sofka.puntoDeAtencion.productoRegistrado");
        this.entityId = entityId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
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
