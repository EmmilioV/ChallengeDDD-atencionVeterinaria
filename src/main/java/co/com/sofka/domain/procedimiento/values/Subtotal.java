package co.com.sofka.domain.procedimiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Subtotal implements ValueObject<Double> {
    private final Double value;

    public Subtotal(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value<0){
            throw new IllegalArgumentException("El subtotal no debe de ser negativo");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtotal subtotal = (Subtotal) o;
        return Objects.equals(value, subtotal.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
