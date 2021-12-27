package co.com.sofka.domain.puntoDeAtencion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Cantidad;
import co.com.sofka.domain.generic.Edad;
import co.com.sofka.domain.generic.Nombre;
import co.com.sofka.domain.generic.Precio;
import co.com.sofka.domain.puntoDeAtencion.events.*;
import co.com.sofka.domain.puntoDeAtencion.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class PuntoDeAtencion extends AggregateEvent<PuntoDeAtencionId> {

    protected Nombre nombre;
    protected Ubicacion ubicacion;
    protected Set<Veterinario> veterinarios;
    protected Set<Producto> productos;
    protected Set<ImplementoMedico> implementosMedicos;

    private PuntoDeAtencion(PuntoDeAtencionId puntoDeAtencionId){
        super(puntoDeAtencionId);
        subscribe(new PuntoDeAtencionChange(this));
    }

    public static PuntoDeAtencion from(PuntoDeAtencionId id, List<DomainEvent> events){
        var puntoDeAtencion = new PuntoDeAtencion(id);
        events.forEach(puntoDeAtencion::applyEvent);
        return puntoDeAtencion;
    }

    public PuntoDeAtencion(PuntoDeAtencionId entityId, Nombre nombre, Ubicacion ubicacion) {
        super(entityId);
        appendChange(new PuntoDeAtencionCreado(nombre, ubicacion)).apply();
    }

    public void registrarProducto(ProductoId entityId, Nombre nombre, Cantidad cantidad, Precio precio){
        Objects.requireNonNull(entityId,"ProductoId no debe ser nulo");
        Objects.requireNonNull(entityId,"nombre no debe ser nulo");
        Objects.requireNonNull(entityId,"cantidad no debe ser nulo");
        Objects.requireNonNull(entityId,"precio no debe ser nulo");
        appendChange(new ProductoRegistrado(entityId, nombre, cantidad, precio)).apply();
    }

    public void registrarImplementoMedico(ImplementoMedicoId entityId, Nombre nombre, Cantidad cantidad){
        Objects.requireNonNull(entityId,"entityId no debe ser nulo");
        Objects.requireNonNull(entityId,"nombre no debe ser nulo");
        Objects.requireNonNull(entityId,"cantidad no debe ser nulo");
        appendChange(new ImplementoMedicoRegistrado(entityId, nombre, cantidad)).apply();
    }

    public void agregarVeterinario(VeterinarioId entityId, NumeroDeCedula numeroDeCedula, Nombre nombre, Edad edad){
        Objects.requireNonNull(entityId,"entityId no debe ser nulo");
        Objects.requireNonNull(entityId,"numeroDeCedula no debe ser nulo");
        Objects.requireNonNull(entityId,"nombre no debe ser nulo");
        Objects.requireNonNull(entityId,"edad no debe ser nulo");
        appendChange(new VeterinarioAgregado(entityId, numeroDeCedula, nombre, edad)).apply();
    }

    public void actualizarUbicacion(Ubicacion ubicacion){
        Objects.requireNonNull(ubicacion, "La ubicacion no debe ser nula");
        appendChange(new UbicacionActualizada(ubicacion)).apply();
    }

    protected Optional<Veterinario> consultarVeterinarioPorId(VeterinarioId veterinarioId){
        return this.veterinarios.stream()
                .filter(veterinario -> veterinario.identity().equals(veterinarioId))
                .findFirst();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public Set<Veterinario> veterinarios() {
        return veterinarios;
    }

    public Set<Producto> productos() {
        return productos;
    }

    public Set<ImplementoMedico> implementosMedicos() {
        return implementosMedicos;
    }
}
