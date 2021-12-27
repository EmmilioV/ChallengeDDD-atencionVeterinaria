package co.com.sofka.domain.mascota.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.mascota.values.*;

public class RegistrarCaracteristica extends Command {
    private final MascotaId mascotaId;
    private final CaracteristicaId entityId;
    private final Raza raza;
    private final Peso peso;
    private final Tamanio tamanio;
    private final Color color;

    public RegistrarCaracteristica(MascotaId mascotaId, CaracteristicaId entityId, Raza raza, Peso peso, Tamanio tamanio, Color color) {
        this.mascotaId = mascotaId;
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

    public MascotaId getMascotaId() {
        return mascotaId;
    }
}
