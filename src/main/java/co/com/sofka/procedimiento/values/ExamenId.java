package co.com.sofka.procedimiento.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.mascota.values.DuenioId;

public class ExamenId extends Identity {
    public ExamenId(){}

    private ExamenId(String id){
        super(id);
    }

    public static ExamenId of(String id){
        return new ExamenId(id);
    }
}
