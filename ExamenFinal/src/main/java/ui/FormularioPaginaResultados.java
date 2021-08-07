package ui;
import net.serenitybdd.screenplay.targets.Target;

public class FormularioPaginaResultados {
    public static final Target TABLA_RESULTADOS = Target.the("Tabla de resultados")
            .locatedBy("//tbody");
}
