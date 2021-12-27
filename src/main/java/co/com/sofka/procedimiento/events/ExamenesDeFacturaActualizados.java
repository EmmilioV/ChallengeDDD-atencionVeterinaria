package co.com.sofka.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.procedimiento.Examen;
import co.com.sofka.procedimiento.Examen;
import co.com.sofka.procedimiento.values.FacturaId;

import java.util.Set;

public class ExamenesDeFacturaActualizados extends DomainEvent {
    private final FacturaId entityId;
    private final Set<Examen> examenes;

    public ExamenesDeFacturaActualizados(FacturaId entityId, Set<Examen> examenes) {
        super("sofka.procedimiento.examenesDeFacturaActualizados");
        this.entityId = entityId;
        this.examenes = examenes;
    }

    public FacturaId getEntityId() {
        return entityId;
    }

    public Set<Examen> getExamens() {
        return examenes;
    }
}
