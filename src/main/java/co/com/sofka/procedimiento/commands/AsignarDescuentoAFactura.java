package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.procedimiento.values.Descuento;
import co.com.sofka.procedimiento.values.FacturaId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

public class AsignarDescuentoAFactura extends Command {
    private final ProcedimientoId procedimientoId;
    private final FacturaId entityId;
    private final Descuento descuento;

    public AsignarDescuentoAFactura(ProcedimientoId procedimientoId, FacturaId entityId, Descuento descuento) {
        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
        this.descuento = descuento;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
