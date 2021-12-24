package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.puntoDeAtencion.values.ProductoId;

public class Producto extends Entity<ProductoId> {
    public Producto(ProductoId entityId) {
        super(entityId);
    }
}
