package co.com.sofka.mascota.values;

import co.com.sofka.domain.generic.Identity;

public class EnfermedadId extends Identity {
    public EnfermedadId(){}

    private EnfermedadId(String id){
        super(id);
    }

    public static EnfermedadId of(String id){
        return new EnfermedadId(id);
    }
}
