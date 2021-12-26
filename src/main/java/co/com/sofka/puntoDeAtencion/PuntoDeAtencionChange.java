package co.com.sofka.puntoDeAtencion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.puntoDeAtencion.events.*;

import java.util.HashSet;

public class PuntoDeAtencionChange extends EventChange {
    public PuntoDeAtencionChange(PuntoDeAtencion puntoDeAtencion){
        apply((PuntoDeAtencionCreado event)->{
            puntoDeAtencion.nombre = event.getNombre();
            puntoDeAtencion.ubicacion = event.getUbicacion();
            puntoDeAtencion.implementosMedicos = new HashSet<>();
            puntoDeAtencion.veterinarios = new HashSet<>();
            puntoDeAtencion.productos = new HashSet<>();
        });

        apply((ProductoRegistrado event)->{
            puntoDeAtencion.productos.add(new Producto(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getCantidad(),
                    event.getPrecio()
            ));
        });

        apply((ImplementoMedicoRegistrado event)->{
            puntoDeAtencion.implementosMedicos.add(new ImplementoMedico(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getCantidad()
            ));
        });

        apply((VeterinarioAgregado event)->{
            puntoDeAtencion.veterinarios.add(new Veterinario(
                    event.getEntityId(),
                    event.getNumeroDeCedula(),
                    event.getNombre(),
                    event.getEdad()
            ));
        });

        apply((UbicacionActualizada event)->{
            puntoDeAtencion.ubicacion = event.getUbicacion();
        });
    }
}
