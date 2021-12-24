package co.com.sofka.mascota;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.mascota.values.EnfermedadId;

public class Enfermedad extends Entity<EnfermedadId> {
    public Enfermedad(EnfermedadId entityId) {
        super(entityId);
    }
}
