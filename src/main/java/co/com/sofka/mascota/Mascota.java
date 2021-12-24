package co.com.sofka.mascota;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.values.MascotaId;

import java.util.Set;

public class Mascota extends AggregateEvent<MascotaId> {

    protected Nombre nombre;
    protected Edad edad;
    protected Caracteristica caracteristica;
    protected Duenio duenio;
    protected Set<Enfermedad> enfermedades;


    public Mascota(MascotaId entityId, Nombre nombre, Edad edad) {
        super(entityId);
        this.nombre = nombre;
        this.edad = edad;
    }
}
