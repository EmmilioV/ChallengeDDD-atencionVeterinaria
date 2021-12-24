package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.procedimiento.values.MedicamentoId;

public class Medicamento extends Entity<MedicamentoId> {
    public Medicamento(MedicamentoId entityId) {
        super(entityId);
    }
}
