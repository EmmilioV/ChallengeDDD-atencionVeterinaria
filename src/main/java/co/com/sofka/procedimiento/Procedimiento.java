package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.procedimiento.values.ProcedimientoId;

public class Procedimiento extends AggregateEvent<ProcedimientoId> {
    public Procedimiento(ProcedimientoId entityId) {
        super(entityId);
    }
}
