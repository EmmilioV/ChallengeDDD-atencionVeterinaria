package co.com.sofka.procedimiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Laboratorio implements ValueObject<String> {
    private final String value;

    public Laboratorio(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratorio that = (Laboratorio) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
