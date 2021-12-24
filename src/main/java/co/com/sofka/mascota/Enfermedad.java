package co.com.sofka.mascota;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.Detalle;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.EnfermedadId;

import java.util.Objects;

public class Enfermedad extends Entity<EnfermedadId> {
    private Nombre nombre;
    private Detalle detalle;

    public Enfermedad(EnfermedadId entityId, Nombre nombre, Detalle detalle) {
        super(entityId);
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void brindarDetalle(Detalle detalle){
        this.detalle = Objects.requireNonNull(detalle, "El detalle no debe ser nulo");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Detalle detalle() {
        return detalle;
    }
}
