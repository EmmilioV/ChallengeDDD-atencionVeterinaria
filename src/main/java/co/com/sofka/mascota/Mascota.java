package co.com.sofka.mascota;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.generic.Detalle;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.mascota.events.*;
import co.com.sofka.mascota.values.*;

import java.util.Objects;
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

    public void registrarCaracteristica(CaracteristicaId entityId, Raza raza, Peso peso, Tamanio tamanio, Color color){
        Objects.requireNonNull(entityId, "CaracteristicaId no debe ser nula");
        Objects.requireNonNull(raza, "raza no debe ser nula");
        Objects.requireNonNull(peso, "peso no debe ser nulo");
        Objects.requireNonNull(tamanio, "tamaño no debe ser nulo");
        Objects.requireNonNull(color, "color no debe ser nulo");
        appendChange(new caracteristicaRegistrada(entityId, raza, peso, tamanio, color)).apply();
    }

    public void asignarDuenio(DuenioId entityId, Nombre nombre, Telefono telefono, Edad edad){
        Objects.requireNonNull(entityId, "dueñoId no debe ser nulo");
        Objects.requireNonNull(nombre, "nombre no debe ser nula");
        Objects.requireNonNull(telefono, "telefono no debe ser nulo");
        Objects.requireNonNull(edad, "edad no debe ser nulo");
        appendChange(new duenioAsignado(entityId, nombre, telefono, edad)).apply();
    }

    public void aniadirEnfermedad(EnfermedadId entityId, Nombre nombre, Detalle detalle){
        Objects.requireNonNull(entityId, "CaracteristicaId no debe ser nula");
        Objects.requireNonNull(nombre, "nombre no debe ser nulo");
        Objects.requireNonNull(detalle, "detalle no debe ser nulo");
        appendChange(new enfermedadAniadida(entityId, nombre, detalle)).apply();
    }

    public void actualizarEdad(Edad edad){
        Objects.requireNonNull(edad, "la edad no debe ser nula");
        appendChange(new edadActualizada(edad)).apply();
    }

    public Enfermedad consultarEnfermedadPorId(EnfermedadId enfermedadId){
        return this.enfermedades.stream()
                .filter(enfermedad -> enfermedad.identity().equals(enfermedadId))
                .findFirst()
                .orElseThrow();
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
