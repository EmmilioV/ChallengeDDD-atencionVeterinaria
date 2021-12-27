package co.com.sofka.domain.mascota;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.mascota.values.*;

import java.util.Objects;

public class Caracteristica extends Entity<CaracteristicaId> {
    private Raza raza;
    private Peso peso;
    private Tamanio tamanio;
    private Color color;

    public Caracteristica(CaracteristicaId entityId, Raza raza, Peso peso, Tamanio tamanio, Color color) {
        super(entityId);
        this.raza = raza;
        this.peso = peso;
        this.tamanio = tamanio;
        this.color = color;
    }

    public void actualizarPeso(Peso peso){
        this.peso = Objects.requireNonNull(peso, "El peso no debe ser nulo");
    }

    public void actualizarTamanio(Tamanio tamanio){
        this.tamanio = Objects.requireNonNull(tamanio, "El tamaño no debe ser nulo");
    }

    public Raza raza() {
        return raza;
    }

    public Peso peso() {
        return peso;
    }

    public Tamanio tamanio() {
        return tamanio;
    }

    public Color color() {
        return color;
    }
}
