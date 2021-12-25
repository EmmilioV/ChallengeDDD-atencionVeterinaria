package co.com.sofka.puntoDeAtencion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AniosDeExperiencia implements ValueObject<Integer> {
    private final Integer value;

    public AniosDeExperiencia(Integer value) {
        this.value = value;
        if(this.value < 0){
            throw new IllegalArgumentException("Los años de experiencia no pueden ser numero negativo");
        }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AniosDeExperiencia that = (AniosDeExperiencia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
