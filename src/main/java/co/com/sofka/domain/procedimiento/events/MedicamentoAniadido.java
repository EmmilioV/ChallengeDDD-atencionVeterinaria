package co.com.sofka.domain.procedimiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.procedimiento.values.Laboratorio;
import co.com.sofka.domain.procedimiento.values.MedicamentoId;

public class MedicamentoAniadido extends DomainEvent {
    private final MedicamentoId entityId;
    private final Nombre nombre;
    private final Laboratorio laboratorio;
    private final Precio precio;

    public MedicamentoAniadido(MedicamentoId entityId, Nombre nombre, Laboratorio laboratorio, Precio precio) {
        super("sofka.procedimiento.medicamentoAniadido");

        this.entityId = entityId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.precio = precio;
    }

    public MedicamentoId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
