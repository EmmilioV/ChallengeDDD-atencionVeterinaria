package co.com.sofka.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<Integer> {
    private final Integer value;

    public Edad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0){
            throw new IllegalArgumentException("La edad no puede ser negativa ni igual a cero");
        }
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edad edad = (Edad) o;
        return Objects.equals(value, edad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
