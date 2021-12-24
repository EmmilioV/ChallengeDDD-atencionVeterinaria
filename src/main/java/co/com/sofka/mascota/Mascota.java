package co.com.sofka.mascota;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.mascota.values.MascotaId;

public class Mascota extends AggregateEvent<MascotaId> {
    public Mascota(MascotaId entityId) {
        super(entityId);
    }
}
