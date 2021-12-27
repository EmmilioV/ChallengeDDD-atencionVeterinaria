package co.com.sofka.domain.procedimiento.values;

import co.com.sofka.domain.generic.Identity;

public class ExamenId extends Identity {
    public ExamenId(){}

    private ExamenId(String id){
        super(id);
    }

    public static ExamenId of(String id){
        return new ExamenId(id);
    }
}
