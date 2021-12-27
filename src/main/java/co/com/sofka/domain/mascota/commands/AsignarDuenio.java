package co.com.sofka.domain.mascota.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.values.DuenioId;
import co.com.sofka.domain.mascota.values.MascotaId;
import co.com.sofka.domain.mascota.values.Telefono;

public class AsignarDuenio extends Command {
    private final MascotaId mascotaId;
    private final DuenioId entityId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Edad edad;

    public AsignarDuenio(MascotaId mascotaId, DuenioId entityId, Nombre nombre, Telefono telefono, Edad edad) {
        this.mascotaId = mascotaId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public MascotaId getMascotaId() {
        return mascotaId;
    }

    public DuenioId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Edad getEdad() {
        return edad;
    }
}
