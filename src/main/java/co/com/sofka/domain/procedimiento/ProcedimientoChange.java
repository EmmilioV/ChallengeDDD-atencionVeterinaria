package co.com.sofka.domain.procedimiento;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.procedimiento.events.*;

import java.util.HashSet;

public class ProcedimientoChange extends EventChange {
    public ProcedimientoChange(Procedimiento procedimiento) {
        apply((ProcedimientoCreado event)->{
            procedimiento.mascotaId = event.getMascotaId();
            procedimiento.puntoDeAtencionId = event.getPuntoDeAtencionId();
            procedimiento.fecha = event.getFecha();
            procedimiento.nombre= event.getNombre();
            procedimiento.examenes = new HashSet<>();
            procedimiento.medicamentos = new HashSet<>();
        });

        apply((MedicamentoAniadido event)->{
            procedimiento.medicamentos.add(new Medicamento(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getLaboratorio(),
                    event.getPrecio()
            ));
        });

        apply((ExamenAniadido event)->{
            procedimiento.examenes.add(new Examen(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getPrecio()
            ));
        });

        apply((DetalleDeUnExamenBrindado event)->{
            var examen = procedimiento.examenes.stream()
                    .filter(examen1 -> examen1.identity().equals(event.getExamenId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No existe un examen con dicho Id"));
            examen.brindarDetalle(event.getDetalle());
        });

        apply((FacturaGenerada event)->{
            procedimiento.factura = new Factura(
                    event.getEntityId(),
                    event.getFecha(),
                    event.getMedicamentos(),
                    event.getExamenes()
            );
        });

        apply((MedicamentosDeFacturaActualizados event)->{
            if(procedimiento.factura.identity().equals(event.getEntityId())){
                procedimiento.factura.actualizarMedicamentos(event.getMedicamentos());
            }
            else {
                throw new IllegalArgumentException("No se ha generado la factura aun");
            }
        });

        apply((ExamenesDeFacturaActualizados event)->{
            if(procedimiento.factura.identity().equals(event.getEntityId())){
                procedimiento.factura.actualizarExamenes(event.getExamens());
            }
            else {
                throw new IllegalArgumentException("No se ha generado la factura aun");
            }
        });

        apply((SubtotalDeFacturaCalculado event)->{
            if(procedimiento.factura.identity().equals(event.getEntityId())){
                procedimiento.factura.calcularSubtotal();
            }
            else {
                throw new IllegalArgumentException("No se ha generado la factura aun");
            }
        });

        apply((DescuentoAsignadoAFactura event)->{
            if(procedimiento.factura.identity().equals(event.getEntityId())){
                procedimiento.factura.aplicarDescuento(event.getDescuento().value());
            }
            else {
                throw new IllegalArgumentException("No se ha generado la factura aun");
            }
        });

        apply((TotalDeFacturaCalculado event)->{
            if(procedimiento.factura.identity().equals(event.getEntityId())){
                procedimiento.factura.calcularTotal();
            }
            else {
                throw new IllegalArgumentException("No se ha generado la factura aun");
            }
        });
    }
}
