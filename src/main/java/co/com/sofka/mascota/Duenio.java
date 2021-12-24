package co.com.sofka.mascota;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.DuenioId;
import co.com.sofka.mascota.values.Telefono;

import java.util.Objects;

public class Duenio extends Entity<DuenioId> {
    private Nombre nombre;
    private Telefono telefono;
    private Edad edad;

    public Duenio(DuenioId entityId, Nombre nombre, Telefono telefono, Edad edad) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public void actualizarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono, "El telefono no debe ser nulo");
    }

    public void actualizarEdad(Edad edad){
        this.edad = Objects.requireNonNull(edad, "La edad no debe ser nula");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Edad edad() {
        return edad;
    }
}
