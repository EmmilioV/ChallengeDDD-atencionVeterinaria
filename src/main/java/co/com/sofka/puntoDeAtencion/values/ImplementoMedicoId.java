package co.com.sofka.puntoDeAtencion.values;

import co.com.sofka.domain.generic.Identity;

public class ImplementoMedicoId extends Identity {
    public ImplementoMedicoId(){}

    private ImplementoMedicoId(String id){
        super(id);
    }

    public static ImplementoMedicoId of(String id){
        return new ImplementoMedicoId(id);
    }
}
