package tareas;

import navegacion.PaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.FormularioPaginaPrincipal;

public class BuscarMascotaTask implements Task {
    private String nombreMascota;


    public BuscarMascotaTask(String nombreMascota)
    {
        this.nombreMascota = nombreMascota;
    }

    public static BuscarMascotaTask con(String nombreMascota){
        return new BuscarMascotaTask(nombreMascota);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Enter.theValue(this.nombreMascota).into(FormularioPaginaPrincipal.TXT_SEARCH),
               Click.on(FormularioPaginaPrincipal.BTN_SEARCH)
       );
    }
}
