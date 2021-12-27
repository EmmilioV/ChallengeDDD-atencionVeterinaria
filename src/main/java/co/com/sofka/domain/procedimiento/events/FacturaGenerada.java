package co.com.sofka.domain.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Fecha;
import co.com.sofka.domain.procedimiento.Examen;
import co.com.sofka.domain.procedimiento.Medicamento;
import co.com.sofka.domain.procedimiento.values.FacturaId;

import java.util.Set;

public class FacturaGenerada extends DomainEvent {
    private final FacturaId entityId;
    private final Fecha fecha;
    private final Set<Medicamento> medicamentos;
    private final Set<Examen> examenes;

    public FacturaGenerada(FacturaId entityId, Fecha fecha, Set<Medicamento> medicamentos, Set<Examen> examenes) {
        super("sofka.procedimiento.facturaGenerada");
        this.entityId = entityId;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.examenes = examenes;
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
