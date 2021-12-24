package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.Cantidad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.puntoDeAtencion.values.ProductoId;

import java.util.Objects;

public class Producto extends Entity<ProductoId> {
    private Nombre nombre;
    private Cantidad cantidad;
    private Precio precio;

    public Producto(ProductoId entityId, Nombre nombre, Cantidad cantidad, Precio precio) {
        super(entityId);
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void actualizarCantidad(Cantidad cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no debe ser nulo");
    }

    public void actualizarPrecio(Precio precio) {
        this.precio = Objects.requireNonNull(precio, "El precio no debe ser nulo");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public Precio precio() {
        return precio;
    }
}
