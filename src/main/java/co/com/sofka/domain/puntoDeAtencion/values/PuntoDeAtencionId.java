package co.com.sofka.domain.puntoDeAtencion.values;

import co.com.sofka.domain.generic.Identity;

public class PuntoDeAtencionId extends Identity {
    public PuntoDeAtencionId(){}

    private PuntoDeAtencionId(String id){
        super(id);
    }

    public static PuntoDeAtencionId of(String id){
        return new PuntoDeAtencionId(id);
    }
}
