package tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.FormularioPaginaPrincipal;
import ui.FormularioSignIn;

public class IniciarSesionTask implements Task {
    private String userName;
    private String userPass;

    private IniciarSesionTask(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public static IniciarSesionTask con(String userName, String userPass) {
        return new IniciarSesionTask(userName, userPass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Click.on(FormularioPaginaPrincipal.BTN_SIGN),
               Enter.theValue(this.userName).into(FormularioSignIn.TXT_USERNAME), //2- Ingresar email
               Enter.theValue(this.userPass).into(FormularioSignIn.TXT_PASSWORD), //3- Ingresar password
               Click.on(FormularioSignIn.BTN_SIGN_IN) //4- Click en Sign in (iniciar sesion)
       );

    }
}
