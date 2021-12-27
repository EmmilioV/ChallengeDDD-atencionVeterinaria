package co.com.sofka.domain.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.procedimiento.Medicamento;
import co.com.sofka.domain.procedimiento.values.FacturaId;
import co.com.sofka.domain.procedimiento.values.ProcedimientoId;

import java.util.Set;

public class ActualizarMedicamentosDeFactura extends Command {
    private final ProcedimientoId procedimientoId;
    private final FacturaId entityId;
    private final Set<Medicamento> medicamentos;

    public ActualizarMedicamentosDeFactura(ProcedimientoId procedimientoId, FacturaId entityId, Set<Medicamento> medicamentos) {
        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
        this.medicamentos = medicamentos;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}
