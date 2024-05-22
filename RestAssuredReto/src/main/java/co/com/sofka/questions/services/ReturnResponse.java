package co.com.sofka.questions.services;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnResponse implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().asString();
    }

    public static ReturnResponse returnResponse() {
        return new ReturnResponse();
    }
}
