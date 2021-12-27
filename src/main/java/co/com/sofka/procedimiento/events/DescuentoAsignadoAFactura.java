package co.com.sofka.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.procedimiento.values.Descuento;

public class DescuentoAsignadoAFactura extends DomainEvent {
    private final Descuento descuento;

    public DescuentoAsignadoAFactura(Descuento descuento) {
        super("sofka.procedimiento.descuento");
        this.descuento = descuento;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
