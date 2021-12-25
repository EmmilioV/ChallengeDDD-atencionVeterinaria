package co.com.sofka.puntoDeAtencion.values;

import co.com.sofka.domain.generic.Identity;

public class VeterinarioId extends Identity {
    public VeterinarioId(){}

    private VeterinarioId(String id){
        super(id);
    }

    public static VeterinarioId of(String id){
        return new VeterinarioId(id);
    }
}
