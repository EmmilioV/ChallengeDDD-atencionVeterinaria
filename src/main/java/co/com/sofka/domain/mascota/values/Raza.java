package co.com.sofka.domain.mascota.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Raza implements ValueObject<String> {
    private final String value;

    public Raza(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("la raza no debe estar vacía");
        }
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raza raza = (Raza) o;
        return Objects.equals(value, raza.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
