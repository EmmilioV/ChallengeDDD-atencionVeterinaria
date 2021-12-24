package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.puntoDeAtencion.values.VeterinarioId;

public class Veterinario extends Entity<VeterinarioId> {
    public Veterinario(VeterinarioId entityId) {
        super(entityId);
    }
}
