package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Fecha;
import co.com.sofka.procedimiento.Examen;
import co.com.sofka.procedimiento.Medicamento;
import co.com.sofka.procedimiento.values.FacturaId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

import java.util.Set;

public class GenerarFactura extends Command {
    private final ProcedimientoId procedimientoId;
    private final FacturaId entityId;
    private final Fecha fecha;
    private final Set<Medicamento> medicamentos;
    private final Set<Examen> examenes;

    public GenerarFactura(ProcedimientoId procedimientoId, FacturaId entityId, Fecha fecha, Set<Medicamento> medicamentos, Set<Examen> examenes) {
        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.examenes = examenes;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public Set<Examen> getExamenes() {
        return examenes;
    }
}
