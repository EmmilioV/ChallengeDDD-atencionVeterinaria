package co.com.sofka.procedimiento.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.procedimiento.values.Laboratorio;
import co.com.sofka.procedimiento.values.MedicamentoId;
import co.com.sofka.procedimiento.values.ProcedimientoId;

import java.util.Objects;

public class AniadirMedicamento extends Command {
    private final ProcedimientoId procedimientoId;
    private final MedicamentoId entityId;
    private final Nombre nombre;
    private final Laboratorio laboratorio;
    private final Precio precio;

    public AniadirMedicamento(ProcedimientoId procedimientoId, MedicamentoId entityId, Nombre nombre, Laboratorio laboratorio, Precio precio) {

        this.procedimientoId = procedimientoId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.precio = precio;
    }

    public ProcedimientoId getProcedimientoId() {
        return procedimientoId;
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
