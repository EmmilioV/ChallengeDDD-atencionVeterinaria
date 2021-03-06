package co.com.sofka.domain.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procedimiento.values.FacturaId;

public class TotalDeFacturaCalculado extends DomainEvent {
    private final FacturaId entityId;

    public TotalDeFacturaCalculado(FacturaId entityId) {
        super("sofka.procedimiento.totalDeFacturaCalculado");
        this.entityId = entityId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }
}
