package co.com.sofka.domain.puntoDeAtencion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Cantidad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.puntoDeAtencion.values.ImplementoMedicoId;

import java.util.Objects;

public class ImplementoMedico extends Entity<ImplementoMedicoId> {
    private Nombre nombre;
    private Cantidad cantidad;

    public ImplementoMedico(ImplementoMedicoId entityId, Nombre nombre, Cantidad cantidad) {
        super(entityId);
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void actualizarCantidad(Cantidad cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no debe ser nulo");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Cantidad cantidad() {
        return cantidad;
    }
}
