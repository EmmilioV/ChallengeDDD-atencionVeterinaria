package co.com.sofka.puntoDeAtencion.values;

import co.com.sofka.domain.generic.Identity;

public class ProductoId extends Identity {
    public ProductoId(){}

    private ProductoId(String id){
        super(id);
    }

    public static ProductoId of(String id){
        return new ProductoId(id);
    }
}
