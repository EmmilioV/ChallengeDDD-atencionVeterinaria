package co.com.sofka.domain.mascota.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);
        validaciones();
    }

    private void validaciones() {
        if(this.value.isBlank()){
            throw new IllegalArgumentException("el telefono no debe estar vacío");
        }
        if(this.value.length()<6){
            throw new IllegalArgumentException("EL telefono debe contener más de 6 caracteres");
        }
        validarDigitos();
    }

    private void validarDigitos() {
        if(!this.value.chars().allMatch( Character::isDigit)){
            throw new IllegalArgumentException("El telefono debe de contener solo numeros");
        }
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(value, telefono.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
