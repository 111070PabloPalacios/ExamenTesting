package definicionpasos;

import io.cucumber.java.es.*;
import navegacion.NavigateTo;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.IsEqual;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import tareas.BuscarMascotaTask;
import ui.FormularioPaginaPrincipal;
import ui.FormularioPaginaResultados;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class BuscarMascotaSteps {
    private String nombre_actor = "Carlos";


    @Dado("en la pagina principal")
    public void en_la_pagina_principal() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled(this.nombre_actor).attemptsTo(
                NavigateTo.paginaPrincipal()
        );

    }

    @Cuando("ingreso el {string}")
    public void ingreso_el(String nombreMascota) {

      OnStage.theActor(this.nombre_actor).should(
              GivenWhenThen.seeThat(
                      the(FormularioPaginaPrincipal.BTN_SEARCH), isEnabled()
              )
      );

       OnStage.theActor(this.nombre_actor).attemptsTo(
               BuscarMascotaTask.con(nombreMascota)
       );
    }

    @Entonces("me redirige a los resultados")
    public void me_redirige_a_los_resultados() {
        OnStage.theActor(this.nombre_actor).should(
                GivenWhenThen.seeThat(
                        the(FormularioPaginaResultados.TABLA_RESULTADOS), isVisible()
                )
        );
    }

}
