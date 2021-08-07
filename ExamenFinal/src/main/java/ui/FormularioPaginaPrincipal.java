package ui;
import net.serenitybdd.screenplay.targets.Target;

public class FormularioPaginaPrincipal {
    public static final Target TXT_SEARCH = Target.the("Caja de texto para buscar")
            .locatedBy("//input[@name='keyword']");

    public static final Target BTN_SEARCH = Target.the("Boton de busqueda")
            .locatedBy("//input[@name='searchProducts']");

    public static final Target BTN_SIGN = Target.the("Boton para ir al fomulario de iniciar sesion")
            .locatedBy("//a[normalize-space()='Sign In']");


}
