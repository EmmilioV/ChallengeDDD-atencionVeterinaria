package co.com.sofka.domain.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procedimiento.values.Descuento;
import co.com.sofka.domain.procedimiento.values.FacturaId;

public class DescuentoAsignadoAFactura extends DomainEvent {
    private final FacturaId entityId;
    private final Descuento descuento;

    public DescuentoAsignadoAFactura(FacturaId entityId, Descuento descuento) {
        super("sofka.procedimiento.descuento");
        this.entityId = entityId;
        this.descuento = descuento;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public FacturaId getEntityId() {
        return entityId;
    }
}
