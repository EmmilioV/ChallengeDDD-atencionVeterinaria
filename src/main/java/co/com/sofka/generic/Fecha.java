package co.com.sofka.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Fecha implements ValueObject<Date> {
    private final Date value;

    public Fecha(Date value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.before(new Date(Instant.now().toEpochMilli()))){
            throw new IllegalArgumentException("La no debe de ser anterior a la fecha actual");
        }
    }

    public Date value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(value, fecha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
