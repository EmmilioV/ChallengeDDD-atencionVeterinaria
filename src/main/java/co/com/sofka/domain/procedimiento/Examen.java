package co.com.sofka.domain.procedimiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Detalle;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.procedimiento.values.ExamenId;

import java.util.Objects;

public class Examen extends Entity<ExamenId> {
    private Nombre nombre;
    private Detalle detalle;
    private Precio precio;

    public Examen(ExamenId entityId, Nombre nombre, Precio precio) {
        super(entityId);
        this.nombre = nombre;
        this.precio = precio;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void brindarDetalle(Detalle detalle){
        this.detalle = Objects.requireNonNull(detalle, "El detalle no debe ser nulo");
    }

    public void actualizarPrecio(Precio precio){
        this.precio = Objects.requireNonNull(precio, "El precio no debe ser nulo");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Detalle detalle() {
        return detalle;
    }

    public Precio precio() {
        return precio;
    }
}
