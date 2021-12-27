package co.com.sofka.domain.mascota;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Detalle;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.mascota.events.*;
import co.com.sofka.domain.mascota.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Mascota extends AggregateEvent<MascotaId> {

    protected Nombre nombre;
    protected Edad edad;
    protected Caracteristica caracteristica;
    protected Duenio duenio;
    protected Set<Enfermedad> enfermedades;

    public Mascota(MascotaId entityId, Nombre nombre, Edad edad) {
        super(entityId);
        appendChange(new MascotaCreada(nombre, edad)).apply();
    }

    private Mascota(MascotaId entityId){
        super(entityId);
        subscribe(new MascotaChange(this));
    }

    private static Mascota from(MascotaId mascotaId, List<DomainEvent> events){
        var mascota = new Mascota(mascotaId);
        events.forEach(mascota::applyEvent);
        return mascota;
    }

    public void registrarCaracteristica(CaracteristicaId entityId, Raza raza, Peso peso, Tamanio tamanio, Color color){
        Objects.requireNonNull(entityId, "CaracteristicaId no debe ser nula");
        Objects.requireNonNull(raza, "raza no debe ser nula");
        Objects.requireNonNull(peso, "peso no debe ser nulo");
        Objects.requireNonNull(tamanio, "tamaño no debe ser nulo");
        Objects.requireNonNull(color, "color no debe ser nulo");
        appendChange(new CaracteristicaRegistrada(entityId, raza, peso, tamanio, color)).apply();
    }

    public void asignarDuenio(DuenioId entityId, Nombre nombre, Telefono telefono, Edad edad){
        Objects.requireNonNull(entityId, "dueñoId no debe ser nulo");
        Objects.requireNonNull(nombre, "nombre no debe ser nula");
        Objects.requireNonNull(telefono, "telefono no debe ser nulo");
        Objects.requireNonNull(edad, "edad no debe ser nulo");
        appendChange(new DuenioAsignado(entityId, nombre, telefono, edad)).apply();
    }

    public void aniadirEnfermedad(EnfermedadId entityId, Nombre nombre, Detalle detalle){
        Objects.requireNonNull(entityId, "CaracteristicaId no debe ser nula");
        Objects.requireNonNull(nombre, "nombre no debe ser nulo");
        Objects.requireNonNull(detalle, "detalle no debe ser nulo");
        appendChange(new EnfermedadAniadida(entityId, nombre, detalle)).apply();
    }

    public void actualizarEdad(Edad edad){
        Objects.requireNonNull(edad, "la edad no debe ser nula");
        appendChange(new EdadActualizada(edad)).apply();
    }

    protected Optional<Enfermedad> consultarEnfermedadPorId(EnfermedadId enfermedadId){
        return this.enfermedades.stream()
                .filter(enfermedad -> enfermedad.identity().equals(enfermedadId))
                .findFirst();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }

    public Caracteristica caracteristica() {
        return caracteristica;
    }

    public Duenio duenio() {
        return duenio;
    }

    public Set<Enfermedad> enfermedades() {
        return enfermedades;
    }
}
