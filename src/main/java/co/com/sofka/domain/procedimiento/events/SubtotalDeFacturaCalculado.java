package co.com.sofka.domain.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.procedimiento.values.FacturaId;

public class SubtotalDeFacturaCalculado extends DomainEvent {
    private final FacturaId entityId;

    public SubtotalDeFacturaCalculado(FacturaId entityId) {
        super("sofka.procedimiento.subtotalDeFacturaCreada");
        this.entityId = entityId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }
}
