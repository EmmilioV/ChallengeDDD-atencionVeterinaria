package co.com.sofka.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.procedimiento.Procedimiento;
import co.com.sofka.domain.procedimiento.commands.CalcularSubtotalDeFactura;

public class CalcularSubtotalDeFacturaUseCase extends UseCase<RequestCommand<CalcularSubtotalDeFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CalcularSubtotalDeFactura> requestCommand) {
        var command = requestCommand.getCommand();
        var procedimiento = Procedimiento.from(command.getProcedimientoId(), retrieveEvents());

        procedimiento.calcularSubtotalDeFactura(command.getEntityId());

        emit().onResponse(new ResponseEvents(procedimiento.getUncommittedChanges()));
    }
}
