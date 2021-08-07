package definicionpasos;

import io.cucumber.java.es.*;
import navegacion.NavigateTo;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.text.IsEqualIgnoringCase;
import preguntas.PaginaCheckoutQuestions;
import preguntas.PaginaPrincipalQuestions;
import tareas.BuscarMascotaTask;
import tareas.ComprarMascotaTask;
import tareas.IniciarSesionTask;
import ui.FormularioCompra;
import ui.FormularioPaginaPrincipal;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ComprarMascotaSteps {
    private String nombre_actor = "Carlos";

    @Dado("en la main page")
    public void en_la_main_page() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled(this.nombre_actor).attemptsTo(
                NavigateTo.paginaPrincipal()
        );

    }

    @Cuando("incio sesion con {string} y {string} y luego ingresar {string}")
    public void incio_sesion_con_y_y_luego_ingresar(String user_name, String user_pass, String nombreMascota) {
        OnStage.theActor(this.nombre_actor).attemptsTo(
                Click.on(FormularioPaginaPrincipal.BTN_SIGN),
                IniciarSesionTask.con(user_name, user_pass)
        );

        OnStage.theActor(this.nombre_actor).should(
                GivenWhenThen.seeThat(
                        the(FormularioPaginaPrincipal.BTN_SEARCH), isEnabled()
                ),
                GivenWhenThen.seeThat(
                        the(FormularioPaginaPrincipal.TXT_SEARCH), isVisible()
                )
        );

        OnStage.theActor(this.nombre_actor).attemptsTo(
                BuscarMascotaTask.con(nombreMascota),
                ComprarMascotaTask.con()
        );

    }

    @Entonces("la compra se realizo con exito")
    public void la_compra_se_realizo_con_exito() {
        OnStage.theActor(this.nombre_actor).should(
                GivenWhenThen.seeThat(
                        "Aviso de compra",
                        PaginaCheckoutQuestions.mensajeConfirmacion(),
                        IsEqualIgnoringCase.equalToIgnoringCase("Thank you, your order has been submitted.")
                )
        );
    }

}
