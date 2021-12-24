package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;

public class PuntoDeAtencion extends AggregateEvent<PuntoDeAtencionId> {
    public PuntoDeAtencion(PuntoDeAtencionId entityId) {
        super(entityId);
    }
}
