package co.com.sofka.mascota.values;

import co.com.sofka.domain.generic.Identity;

public class MascotaId extends Identity {

    public MascotaId(){}

    private MascotaId(String id){
        super(id);
    }

    public static MascotaId of(String id){
        return new MascotaId(id);
    }
}
