package co.com.sofka.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.procedimiento.Medicamento;
import co.com.sofka.procedimiento.values.FacturaId;

import java.util.Set;

public class MedicamentosDeFacturaActualizados extends DomainEvent {
    private final FacturaId entityId;
    private final Set<Medicamento> medicamentos;

    public MedicamentosDeFacturaActualizados(FacturaId entityId, Set<Medicamento> medicamentos) {
        super("sofka.procedimiento.medicamentosDeFacturaActualizados");
        this.entityId = entityId;
        this.medicamentos = medicamentos;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}
