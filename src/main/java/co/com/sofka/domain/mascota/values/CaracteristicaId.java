package co.com.sofka.domain.mascota.values;

import co.com.sofka.domain.generic.Identity;

public class CaracteristicaId extends Identity {
    public CaracteristicaId(){}

    private CaracteristicaId(String id){
        super(id);
    }

    public static CaracteristicaId of(String id){
        return new CaracteristicaId(id);
    }
}
