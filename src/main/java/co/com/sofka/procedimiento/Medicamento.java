package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.Detalle;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.procedimiento.values.Laboratorio;
import co.com.sofka.procedimiento.values.MedicamentoId;

import java.util.Objects;

public class Medicamento extends Entity<MedicamentoId> {
    private Nombre nombre;
    private Laboratorio laboratorio;
    private Precio precio;

    public Medicamento(MedicamentoId entityId, Nombre nombre, Laboratorio laboratorio, Precio precio) {
        super(entityId);
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.precio = precio;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void actualizarLaboratorio(Laboratorio laboratorio){
        this.laboratorio = Objects.requireNonNull(laboratorio, "El laboratorio no debe ser nulo");
    }

    public void actualizarPrecio(Precio precio){
        this.precio = Objects.requireNonNull(precio, "El precio no debe ser nulo");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Laboratorio laboratorio() {
        return laboratorio;
    }

    public Precio precio() {
        return precio;
    }
}
