package definicionpasos;

import io.cucumber.java.es.*;
import navegacion.NavigateTo;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.IsEqual;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import preguntas.PaginaPrincipalQuestions;
import tareas.BuscarMascotaTask;
import tareas.IniciarSesionTask;
import ui.FormularioPaginaPrincipal;
import ui.FormularioPaginaResultados;
import ui.FormularioSignIn;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class IniciarSesionSteps {
    private String nombre_actor = "Carlos";

    @Dado("en la pagina de inicio")
    public void en_la_pagina_de_inicio() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled(this.nombre_actor).attemptsTo(
                NavigateTo.paginaPrincipal()
        );
    }

    @Cuando("ingreso el {string} y {string}")
    public void ingreso_el_y(String user_name, String user_pass) {
        OnStage.theActor(this.nombre_actor).attemptsTo(
                Click.on(FormularioPaginaPrincipal.BTN_SIGN)
        );

        OnStage.theActor(this.nombre_actor).should(
                GivenWhenThen.seeThat(
                        the(FormularioSignIn.TXT_USERNAME), isVisible()
                ),
                GivenWhenThen.seeThat(
                        the(FormularioSignIn.TXT_PASSWORD), isVisible()
                ),
                GivenWhenThen.seeThat(
                        the(FormularioSignIn.BTN_SIGN_IN), isEnabled()
                )
        );

        OnStage.theActor(this.nombre_actor).attemptsTo(
                IniciarSesionTask.con(user_name, user_pass)
        );

    }

    @Entonces("me redirige a mi cuenta")
    public void me_redirige_a_mi_cuenta() {
        OnStage.theActor(this.nombre_actor).should(
                GivenWhenThen.seeThat(
                        //the(FormularioSignIn.TXT_ERROR), isVisible()
                        "Tiene un mensaje de error",
                        PaginaPrincipalQuestions.mensajeError(),
                        IsEqualIgnoringCase.equalToIgnoringCase("Invalid username or password.  Signon failed.")
                )
        );
    }
}
