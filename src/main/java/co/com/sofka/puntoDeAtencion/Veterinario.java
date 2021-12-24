package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.Cantidad;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.puntoDeAtencion.values.AniosDeExperiencia;
import co.com.sofka.puntoDeAtencion.values.NumeroDeCedula;
import co.com.sofka.puntoDeAtencion.values.VeterinarioId;

import java.util.Objects;

public class Veterinario extends Entity<VeterinarioId> {
    private NumeroDeCedula numeroDeCedula;
    private Nombre nombre;
    private Edad edad;
    private AniosDeExperiencia aniosDeExperiencia;

    public Veterinario(VeterinarioId entityId, NumeroDeCedula numeroDeCedula, Nombre nombre, Edad edad) {
        super(entityId);
        this.numeroDeCedula = numeroDeCedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no debe ser nulo");
    }

    public void actualizarEdad(Edad edad) {
        this.edad = Objects.requireNonNull(edad, "La edad no debe ser nulo");
    }

    public void actualizarAniosDeExperiencia(AniosDeExperiencia aniosDeExperiencia) {
        this.aniosDeExperiencia = Objects.requireNonNull(aniosDeExperiencia, "Los años de experiencia no debe ser nulo");
    }

    public NumeroDeCedula numeroDeCedula() {
        return numeroDeCedula;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }

    public AniosDeExperiencia aniosDeExperiencia() {
        return aniosDeExperiencia;
    }
}
