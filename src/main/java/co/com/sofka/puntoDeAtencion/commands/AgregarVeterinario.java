package co.com.sofka.puntoDeAtencion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Edad;
import co.com.sofka.generic.Nombre;
import co.com.sofka.puntoDeAtencion.values.NumeroDeCedula;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.puntoDeAtencion.values.VeterinarioId;

public class AgregarVeterinario extends Command {
    private final PuntoDeAtencionId puntoDeAtencionId;
    private final VeterinarioId entityId;
    private final NumeroDeCedula numeroDeCedula;
    private final Nombre nombre;
    private final Edad edad;

    public AgregarVeterinario(PuntoDeAtencionId puntoDeAtencionId, VeterinarioId entityId, NumeroDeCedula numeroDeCedula, Nombre nombre, Edad edad) {
        this.puntoDeAtencionId = puntoDeAtencionId;
        this.entityId = entityId;
        this.numeroDeCedula = numeroDeCedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public PuntoDeAtencionId getPuntoDeAtencionId() {
        return puntoDeAtencionId;
    }

    public VeterinarioId getEntityId() {
        return entityId;
    }

    public NumeroDeCedula getNumeroDeCedula() {
        return numeroDeCedula;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }
}
