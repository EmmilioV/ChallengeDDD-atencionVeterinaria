package co.com.sofka.procedimiento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.Fecha;
import co.com.sofka.procedimiento.values.Descuento;
import co.com.sofka.procedimiento.values.FacturaId;
import co.com.sofka.procedimiento.values.Subtotal;
import co.com.sofka.procedimiento.values.Total;

import java.util.Set;

public class Factura extends Entity<FacturaId> {
    private Fecha fecha;
    private Set<Medicamento> medicamentos;
    private Set<Examen> examenes;
    private Subtotal subtotal;
    private Descuento descuento;
    private Total total;

    public Factura(FacturaId entityId, Fecha fecha, Set<Medicamento> medicamentos, Set<Examen> examenes) {
        super(entityId);
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.examenes = examenes;
    }

    public void actualizarMedicamentos(Set<Medicamento> medicamentos){
        this.medicamentos = medicamentos;
    }

    public void actualizarExamenes(Set<Examen> examenes){
        this.examenes = examenes;
    }

    public void calcularSubtotal(){
        Double subtotal = sumarPrecioExamenes() + sumarPrecioMedicamentos();
        this.subtotal = new Subtotal(subtotal);
    }

    public void aplicarDescuento(Double descuento){
        this.descuento = new Descuento(descuento);
    }

    public void calcularTotal(){
        Double total = this.subtotal.value() - (this.subtotal.value() * this.descuento.value());
        this.total = new Total(total);
    }

    private Double sumarPrecioExamenes(){
        return this.examenes.stream().mapToDouble(examen -> examen.precio().value()).sum();
    }

    private Double sumarPrecioMedicamentos(){
        return this.medicamentos.stream().mapToDouble(medicamento -> medicamento.precio().value()).sum();
    }

    public Fecha fecha() {
        return fecha;
    }

    public Set<Medicamento> medicamentos() {
        return medicamentos;
    }

    public Set<Examen> examenes() {
        return examenes;
    }

    public Subtotal subtotal() {
        return subtotal;
    }

    public Descuento descuento() {
        return descuento;
    }

    public Total total() {
        return total;
    }
}
