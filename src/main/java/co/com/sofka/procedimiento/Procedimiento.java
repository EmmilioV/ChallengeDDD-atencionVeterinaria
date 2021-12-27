package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.generic.Detalle;
import co.com.sofka.generic.Fecha;
import co.com.sofka.generic.Nombre;
import co.com.sofka.generic.Precio;
import co.com.sofka.mascota.values.MascotaId;
import co.com.sofka.procedimiento.events.*;
import co.com.sofka.procedimiento.values.*;
import co.com.sofka.puntoDeAtencion.values.PuntoDeAtencionId;

import java.util.Objects;
import java.util.Set;

public class Procedimiento extends AggregateEvent<ProcedimientoId> {

    protected PuntoDeAtencionId puntoDeAtencionId;
    protected MascotaId mascotaId;
    protected Fecha fecha;
    protected Nombre nombre;
    protected Detalle detalle;
    protected Factura factura;
    protected Set<Medicamento> medicamentos;
    protected Set<Examen> examenes;

    public Procedimiento(ProcedimientoId entityId, PuntoDeAtencionId puntoDeAtencionId, MascotaId mascotaId, Fecha fecha, Nombre nombre) {
        super(entityId);
        appendChange(new ProcedimientoCreado(puntoDeAtencionId, mascotaId, fecha, nombre)).apply();
    }

    public void aniadirMedicamento(MedicamentoId entityId, Nombre nombre, Laboratorio laboratorio, Precio precio){
        Objects.requireNonNull(entityId, "MedicamentoId no debe ser nula");
        Objects.requireNonNull(nombre, "nombre no debe ser nula");
        Objects.requireNonNull(laboratorio, "laboratorio no debe ser nulo");
        Objects.requireNonNull(precio, "precio no debe ser nulo");
        appendChange(new MedicamentoAniadido( entityId,  nombre,  laboratorio,  precio)).apply();
    }

    public void aniadirExamen(ExamenId entityId, Nombre nombre, Precio precio){
        Objects.requireNonNull(entityId, "entityId no debe ser nulo");
        Objects.requireNonNull(nombre, "nombre no debe ser nulo");
        Objects.requireNonNull(precio, "precio no debe ser nulo");
        appendChange(new ExamenAniadido( entityId,  nombre, precio)).apply();

    }

    public void brindarDetalleDeUnExamen(ExamenId examenId, Detalle detalle){
        Objects.requireNonNull(examenId, "examenId de un examen no puede ser nulo");
        Objects.requireNonNull(detalle, "Detalle de un examen no puede ser nulo");
        appendChange(new DetalleDeUnExamenBrindado(examenId, detalle)).apply();
    }

    public void generarFactura(FacturaId entityId, Fecha fecha, Set<Medicamento> medicamentos, Set<Examen> examenes){
        Objects.requireNonNull(entityId, "FacturaId no debe ser nula");
        Objects.requireNonNull(fecha, "fecha no debe ser nula");
        Objects.requireNonNull(medicamentos, "Medicamento no debe ser nulo");
        Objects.requireNonNull(examenes, "Examen no debe ser nulo");
        appendChange(new FacturaGenerada( entityId,  fecha,  medicamentos,  examenes)).apply();
    }

    public void actualizarMedicamentosDeFactura(FacturaId entityId, Set<Medicamento> medicamentos){
        Objects.requireNonNull(entityId, "FacturaId no debe ser nula");
        Objects.requireNonNull(medicamentos, "Medicamento no debe ser nulo");
        appendChange(new MedicamentosDeFacturaActualizados( entityId,  medicamentos)).apply();
    }

    public void actualizarExamenesDeFactura(FacturaId entityId, Set<Examen> examenes){
        Objects.requireNonNull(entityId, "FacturaId no debe ser nula");
        Objects.requireNonNull(examenes, "Medicamento no debe ser nulo");
        appendChange(new ExamenesDeFacturaActualizados( entityId,  examenes)).apply();
    }

    public void calcularSubtotalDeFactura(FacturaId entityId){
        Objects.requireNonNull(entityId, "FacturaId no puede ser nula");
        appendChange(new SubtotalDeFacturaCalculado(entityId)).apply();
    }

    public void asignarDescuentoAFactura(Descuento descuento){
        Objects.requireNonNull(descuento, "Descuento no debe ser nulo");
        appendChange(new DescuentoAsignadoAFactura(descuento)).apply();
    }

    public void calcularTotalDeFactura(FacturaId entityId){
        Objects.requireNonNull(entityId, "FacturaId no puede ser nula");
        appendChange(new TotalDeFacturaCalculado(entityId)).apply();
    }

}
