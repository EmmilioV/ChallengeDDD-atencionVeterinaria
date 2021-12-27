package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Detalle;
import co.com.sofka.procedimiento.values.ExamenId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

public class BrindarDetalleDeUnExamen extends Command {
    private final ProcedimientoId procedimientoId;
    private final ExamenId examenId;
    private final Detalle detalle;

    public BrindarDetalleDeUnExamen(ProcedimientoId procedimientoId, ExamenId examenId, Detalle detalle) {
        this.procedimientoId = procedimientoId;
        this.examenId = examenId;
        this.detalle = detalle;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
