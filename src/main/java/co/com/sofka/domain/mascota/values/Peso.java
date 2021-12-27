package co.com.sofka.domain.mascota.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Peso implements ValueObject<Double> {
    private final Double value;

    public Peso(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0){
            throw new IllegalArgumentException("El peso no debe de ser negativo ni cero");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peso peso = (Peso) o;
        return Objects.equals(value, peso.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
