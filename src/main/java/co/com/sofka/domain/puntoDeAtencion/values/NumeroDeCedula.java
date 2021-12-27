package co.com.sofka.domain.puntoDeAtencion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumeroDeCedula implements ValueObject<String> {
    private final String value;

    public NumeroDeCedula(String value) {
        this.value = Objects.requireNonNull(value);
        validaciones();
    }

    private void validaciones() {
        if(this.value.isBlank()){
            throw new IllegalArgumentException("el numero de cedula no debe estar vacío");
        }
        if(this.value.length()<8){
            throw new IllegalArgumentException("EL numero de cedula debe contener más de 7 caracteres");
        }
        validarDigitos();
    }

    private void validarDigitos() {
        if(!this.value.chars().allMatch( Character::isDigit)){
            throw new IllegalArgumentException("El numero de cedula debe de contener solo numeros");
        }
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumeroDeCedula that = (NumeroDeCedula) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
