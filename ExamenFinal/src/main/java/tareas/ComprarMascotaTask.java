package tareas;

import acciones.SelectDropDownListValue;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.FormularioCompra;
import ui.FormularioPaginaPrincipal;

public class ComprarMascotaTask implements Task {

    public static ComprarMascotaTask con(){
        return new ComprarMascotaTask();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FormularioCompra.LBL_FISH),
                Click.on(FormularioCompra.BTN_ADD_TO_CART),
                Click.on(FormularioCompra.BTN_PROCEED_TO_CHECKOUT),
                SelectDropDownListValue.valueTarget(FormularioCompra.DDL_CARD, "MasterCard"),
                Enter.theValue("5151741914248443").into(FormularioCompra.TXT_CARD_NUMBER),
                Click.on(FormularioCompra.BTN_CONTINUE),
                Click.on(FormularioCompra.BTN_CONFIRM)
        );
    }
}
