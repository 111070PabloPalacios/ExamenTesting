package ui;
import net.serenitybdd.screenplay.targets.Target;

public class FormularioSignIn {
    public static final Target TXT_USERNAME = Target.the("Textbox para ingresar el email del usuario")
            .locatedBy("//input[@name='username']");

    public static final Target TXT_PASSWORD = Target.the("Textbox para ingresar el password del usuario")
            .locatedBy("//input[@name='password']");

    public static final Target BTN_SIGN_IN = Target.the("Boton para iniciar sesion con un usuario")
            .locatedBy("//input[@name='signon']");

    public static final Target TXT_ERROR = Target.the("Mensaje de error")
            .locatedBy("//li[contains(text(),'Invalid username or password.')]");

}
