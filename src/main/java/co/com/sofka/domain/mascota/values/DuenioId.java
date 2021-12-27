package co.com.sofka.domain.mascota.values;

import co.com.sofka.domain.generic.Identity;

public class DuenioId extends Identity {
    public DuenioId(){}

    private DuenioId(String id){
        super(id);
    }

    public static DuenioId of(String id){
        return new DuenioId(id);
    }
}
