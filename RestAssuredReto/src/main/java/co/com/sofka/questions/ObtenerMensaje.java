package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.ui.PageConfirmacion.MENSAJE_CONFIRMACION;

public class ObtenerMensaje implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_CONFIRMACION.resolveFor(actor).getText();
    }

    public static ObtenerMensaje obtenerMensaje(){
        return new ObtenerMensaje();
    }
}
