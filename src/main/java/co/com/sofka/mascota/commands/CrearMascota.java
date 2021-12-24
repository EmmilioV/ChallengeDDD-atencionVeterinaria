package co.com.sofka.mascota.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.MascotaId;

public class CrearMascota extends Command {
    private final MascotaId entityId;
    private final Nombre nombre;
    private final Edad edad;

    public CrearMascota(MascotaId entityId, Nombre nombre, Edad edad) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.edad = edad;
    }

    public MascotaId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
