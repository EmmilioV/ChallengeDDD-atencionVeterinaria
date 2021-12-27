package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.procedimiento.values.FacturaId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

public class CalcularSubtotalDeFactura extends Command {
    private final ProcedimientoId procedimientoId;
    private final FacturaId entityId;

    public CalcularSubtotalDeFactura(ProcedimientoId procedimientoId, FacturaId entityId) {
        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }
}
