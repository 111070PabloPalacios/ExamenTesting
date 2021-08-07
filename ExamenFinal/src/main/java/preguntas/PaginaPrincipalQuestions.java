package preguntas;

import ui.FormularioPaginaPrincipal;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.Visibility;
import ui.FormularioSignIn;

public class PaginaPrincipalQuestions {
    public static Question<String> mensajeError(){
        return actor -> TextContent.of(FormularioSignIn.TXT_ERROR).viewedBy(actor).asString();
    }
}
