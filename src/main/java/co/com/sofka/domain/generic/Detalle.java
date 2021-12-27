package co.com.sofka.domain.generic;

import java.util.Objects;

public class Detalle implements ValueObject<String> {
    private final String value;

    public Detalle(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detalle detalle = (Detalle) o;
        return Objects.equals(value, detalle.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
