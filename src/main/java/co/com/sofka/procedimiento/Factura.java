package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.procedimiento.values.FacturaId;

public class Factura extends Entity<FacturaId> {
    public Factura(FacturaId entityId) {
        super(entityId);
    }
}
