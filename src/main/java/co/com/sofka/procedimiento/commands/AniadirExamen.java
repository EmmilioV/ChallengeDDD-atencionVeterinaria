package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.procedimiento.values.ExamenId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

public class AniadirExamen extends Command {
    private final ProcedimientoId procedimientoId;
    private final ExamenId entityId;
    private final Nombre nombre;
    private final Precio precio;

    public AniadirExamen(ProcedimientoId procedimientoId, ExamenId entityId, Nombre nombre, Precio precio) {
        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
    }

    public ExamenId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
