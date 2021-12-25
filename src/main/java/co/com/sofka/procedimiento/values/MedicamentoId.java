package co.com.sofka.procedimiento.values;

import co.com.sofka.domain.generic.Identity;

public class MedicamentoId extends Identity {
    public MedicamentoId(){}

    private MedicamentoId(String id){
        super(id);
    }

    public static MedicamentoId of(String id){
        return new MedicamentoId(id);
    }
}
