package co.com.sofka.domain.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procedimiento.values.FacturaId;
import co.com.sofka.domain.procedimiento.values.ProcedimientoId;

public class CalcularTotalDeFactura extends Command {
    private final ProcedimientoId procedimientoId;
    private final FacturaId entityId;

    public CalcularTotalDeFactura(ProcedimientoId procedimientoId, FacturaId entityId) {
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
