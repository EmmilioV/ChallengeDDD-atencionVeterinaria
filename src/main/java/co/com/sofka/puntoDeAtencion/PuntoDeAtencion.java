package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.generic.Nombre;
import co.com.sofka.puntoDeAtencion.events.PuntoDeAtencionCreado;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;
import co.com.sofka.puntoDeAtencion.values.Ubicacion;

import java.util.Set;

public class PuntoDeAtencion extends AggregateEvent<PuntoDeAtencionId> {

    protected Nombre nombre;
    protected Ubicacion ubicacion;
    protected Set<Veterinario> veterinarios;
    protected Set<Producto> productos;
    protected Set<ImplementoMedico> implementosMedicos;

    public PuntoDeAtencion(PuntoDeAtencionId entityId, Nombre nombre, Ubicacion ubicacion) {
        super(entityId);
        appendChange(new PuntoDeAtencionCreado(nombre, ubicacion)).apply();
    }
}
