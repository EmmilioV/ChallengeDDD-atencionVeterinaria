package co.com.sofka.domain.mascota;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.mascota.events.*;

import java.util.HashSet;

public class MascotaChange extends EventChange {
    public MascotaChange(Mascota mascota) {
        apply((MascotaCreada event) -> {
            mascota.nombre = event.getNombre();
            mascota.edad = event.getEdad();
            mascota.enfermedades = new HashSet<>();
        });

        apply((CaracteristicaRegistrada event) -> {
            mascota.caracteristica = new Caracteristica(
                    event.getEntityId(),
                    event.getRaza(),
                    event.getPeso(),
                    event.getTamanio(),
                    event.getColor()
            );
        });

        apply((DuenioAsignado event) -> {
            mascota.duenio = new Duenio(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getTelefono(),
                    event.getEdad()
            );
        });

        apply((EnfermedadAniadida event) ->{
            mascota.enfermedades.add(
                    new Enfermedad(
                            event.getEntityId(),
                            event.getNombre(),
                            event.getDetalle()
                    )
            );
        });

        apply((EdadActualizada event) -> {
            mascota.edad = event.getEdad();
        });

    }
}
