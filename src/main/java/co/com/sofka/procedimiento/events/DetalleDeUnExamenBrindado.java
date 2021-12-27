package co.com.sofka.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Detalle;
import co.com.sofka.procedimiento.values.ExamenId;

public class DetalleDeUnExamenBrindado extends DomainEvent {
    private final ExamenId examenId;
    private final Detalle detalle;

    public DetalleDeUnExamenBrindado(ExamenId examenId, Detalle detalle) {
        super("sofka.procedimiento.detalleDeUnExamenBrindado");
        this.examenId = examenId;
        this.detalle = detalle;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
