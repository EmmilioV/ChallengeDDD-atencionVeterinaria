package co.com.sofka.domain.mascota.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tamanio implements ValueObject<Tamanio.Terminos> {

    private final Terminos terminos;

    public Tamanio(Terminos terminos){
        this.terminos = terminos;
    }

    @Override
    public Terminos value() {
        return this.terminos;
    }

    public enum Terminos{
        PEQUEÑO,
        MEDIANO,
        GRANDE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tamanio tamanio = (Tamanio) o;
        return terminos == tamanio.terminos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminos);
    }
}

