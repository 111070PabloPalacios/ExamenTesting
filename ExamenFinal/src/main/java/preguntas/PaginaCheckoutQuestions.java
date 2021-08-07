package preguntas;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.questions.ValueOf;
import net.serenitybdd.screenplay.questions.Visibility;
import ui.FormularioCompra;
import ui.FormularioSignIn;

public class PaginaCheckoutQuestions {
    public static Question<String> mensajeConfirmacion(){
        return actor -> TextContent.of(FormularioCompra.LBL_MENSAJE).viewedBy(actor).asString();
    }

}
