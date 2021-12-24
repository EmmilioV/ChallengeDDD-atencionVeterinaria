package co.com.sofka.mascota.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.mascota.values.*;

public class CaracteristicaRegistrada extends DomainEvent {
    private final CaracteristicaId entityId;
    private final Raza raza;
    private final Peso peso;
    private final Tamanio tamanio;
    private final Color color;

    public CaracteristicaRegistrada(CaracteristicaId entityId, Raza raza, Peso peso, Tamanio tamanio, Color color) {
        super("sofka.mascota.caracteristicaRegistrada");
        this.entityId = entityId;
        this.raza = raza;
        this.peso = peso;
        this.tamanio = tamanio;
        this.color = color;
    }

    public CaracteristicaId getEntityId() {
        return entityId;
    }

    public Raza getRaza() {
        return raza;
    }

    public Peso getPeso() {
        return peso;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }

    public Color getColor() {
        return color;
    }
}
