package co.com.sofka.Setup;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;


public class SetupService {


    private EnvironmentVariables environmentVariables;
    protected final Actor actor = new Actor("Daniel");

    public void setupService(String urlBase){
        actorCanRequst(urlBase);
    }

    private void actorCanRequst(String urlBase){
        actor.can(CallAnApi.at(urlBase));
    }


}
