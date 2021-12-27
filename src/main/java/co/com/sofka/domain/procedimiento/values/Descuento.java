package co.com.sofka.domain.procedimiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descuento implements ValueObject<Double> {
    private final Double value;

    public Descuento(Double value) {
        this.value = value;
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descuento descuento = (Descuento) o;
        return Objects.equals(value, descuento.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
