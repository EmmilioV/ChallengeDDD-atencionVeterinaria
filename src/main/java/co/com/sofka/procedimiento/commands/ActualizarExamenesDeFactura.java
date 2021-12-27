package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.procedimiento.Examen;
import co.com.sofka.procedimiento.values.FacturaId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

import java.util.Set;

public class ActualizarExamenesDeFactura extends Command {
    private final ProcedimientoId procedimientoId;
    private final FacturaId entityId;
    private final Set<Examen> examenes;

    public ActualizarExamenesDeFactura(ProcedimientoId procedimientoId, FacturaId entityId, Set<Examen> examenes) {
        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
        this.examenes = examenes;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Set<Examen> getExamenes() {
        return examenes;
    }
}
