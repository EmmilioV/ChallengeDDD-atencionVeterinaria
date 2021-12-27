package co.com.sofka.domain.generic;

import java.util.Objects;

public class Precio implements ValueObject<Double> {

    private final Double value;

    public Precio(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0){
            throw new IllegalArgumentException("El precio no debe de ser negativo ni igual a cero");
        }
    }

    public Double value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio = (Precio) o;
        return Objects.equals(value, precio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
