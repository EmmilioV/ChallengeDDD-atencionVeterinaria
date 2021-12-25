package co.com.sofka.procedimiento.values;

import co.com.sofka.domain.generic.Identity;

public class ProcedimientoId extends Identity {
    public ProcedimientoId(){}

    private ProcedimientoId(String id){
        super(id);
    }

    public static ProcedimientoId of(String id){
        return new ProcedimientoId(id);
    }
}
