package co.com.sofka.domain.mascota.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.mascota.values.MascotaId;

public class ActualizarEdad extends Command {
    private final MascotaId mascotaId;
    private final Edad edad;

    public ActualizarEdad(MascotaId mascotaId, Edad edad) {
        this.mascotaId = mascotaId;
        this.edad = edad;
    }

    public MascotaId getMascotaId() {
        return mascotaId;
    }

    public Edad getEdad() {
        return edad;
    }
}
