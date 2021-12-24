package co.com.sofka.mascota.values;

import co.com.sofka.domain.generic.ValueObject;

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
}

