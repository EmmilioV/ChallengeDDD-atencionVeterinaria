package co.com.sofka.puntoDeAtencion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.puntoDeAtencion.values.NumeroDeCedula;
import co.com.sofka.puntoDeAtencion.values.VeterinarioId;

public class VeterinarioAgregado extends DomainEvent {
    private final VeterinarioId entityId;
    private final NumeroDeCedula numeroDeCedula;
    private final Nombre nombre;
    private final Edad edad;

    public VeterinarioAgregado(VeterinarioId entityId, NumeroDeCedula numeroDeCedula, Nombre nombre, Edad edad) {
        super("sofka.puntoDeAtencion.veterinarioAgregado");
        this.entityId = entityId;
        this.numeroDeCedula = numeroDeCedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public VeterinarioId getEntityId() {
        return entityId;
    }

    public NumeroDeCedula getNumeroDeCedula() {
        return numeroDeCedula;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
