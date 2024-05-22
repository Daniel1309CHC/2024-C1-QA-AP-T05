package co.com.sofka.stepsdefinitions;

import co.com.sofka.Setup.SetupService;
import co.com.sofka.models.User;
import co.com.sofka.questions.services.ResponseCode;
import co.com.sofka.questions.services.ReturnResponse;
import co.com.sofka.utils.jsonparser.UserParser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

import java.util.List;

import static co.com.sofka.ConstantesAssertions.Paths.SERVICE_USER;
import static co.com.sofka.ConstantesAssertions.Paths.URL_BASE_JSON_PLACEHOLDER;
import static co.com.sofka.tasks.services.DoGet.doGet;
import static co.com.sofka.utils.jsonparser.JsonCommon.jsonToObject;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UserStepDefinition extends SetupService {
    @Given("que el administrador tiene acceso al sistema")
    public void que_el_administrador_tiene_acceso_al_sistema() {
        setupService(URL_BASE_JSON_PLACEHOLDER);
    }
    @When("hace una solicitud GET para buscar el usuario con {int}")
    public void hace_una_solicitud_get_para_buscar_el_usuario_con(Integer id) {
        actor.attemptsTo(
                doGet().withTheResource(SERVICE_USER+id)
        );
    }
    @Then("la respuesta debería tener el código de estado {int}")
    public void la_respuesta_debería_tener_el_código_de_estado(Integer codEstado) {
        actor.should(
                seeThat("The status code", ResponseCode.was(), equalTo(codEstado))
        );
    }
    @Then("la respuesta debería incluir la información del usuario con ID {int}")
    public void la_respuesta_debería_incluir_la_información_del_usuario_con_id(Integer id) {

        actor.should(
                seeThat("The body doesn´t empty", ReturnResponse.returnResponse(), notNullValue())
        );


        JSONObject userObject = jsonToObject(
                actor.asksFor(ReturnResponse.returnResponse())
        );

        User user = UserParser.toUser(userObject);

        // Realizar aserciones sobre los atributos del User
        actor.should(
                seeThat("El id del usuario no es nulo", actor -> user.getId(), notNullValue())
        );
        actor.should(
                seeThat("El nombre del usuario no es nulo", actor -> user.getName(), notNullValue())
        );
        actor.should(
                seeThat("El nombre de usuario no es nulo", actor -> user.getUsername(), notNullValue())
        );
        actor.should(
                seeThat("El email del usuario no es nulo", actor -> user.getEmail(), notNullValue())
        );
        actor.should(
                seeThat("El teléfono del usuario no es nulo", actor -> user.getPhone(), notNullValue())
        );
        actor.should(
                seeThat("El sitio web del usuario no es nulo", actor -> user.getWebsite(), notNullValue())
        );

    }

    @When("hace una solicitud GET para buscar el usuario con id {int}")
    public void hace_una_solicitud_get_para_buscar_el_usuario_con_id(Integer id) {
        actor.attemptsTo(
                doGet().withTheResource(SERVICE_USER+id)
        );
    }

    @Then("la respuesta debería incluir la información del usuario")
    public void la_respuesta_debería_incluir_la_información_del_usuario(List<User> expectedUsers) {
        // Verificar que la respuesta no esté vacía
        actor.should(
                seeThat("The body doesn't empty", ReturnResponse.returnResponse(), notNullValue())
        );

        // Convertir la respuesta JSON a un objeto User
        JSONObject userObject = jsonToObject(
                actor.asksFor(ReturnResponse.returnResponse())
        );

        User actualUser = UserParser.toUser(userObject);

        // Realizar aserciones sobre los atributos del User
        for (User expectedUser : expectedUsers) {
            actor.should(
                    seeThat("El id del usuario es correcto", actor -> actualUser.getId(), equalTo(expectedUser.getId()))
            );
            actor.should(
                    seeThat("El nombre del usuario es correcto", actor -> actualUser.getName(), equalTo(expectedUser.getName()))
            );
            actor.should(
                    seeThat("El nombre de usuario es correcto", actor -> actualUser.getUsername(), equalTo(expectedUser.getUsername()))
            );
            actor.should(
                    seeThat("El email del usuario es correcto", actor -> actualUser.getEmail(), equalTo(expectedUser.getEmail()))
            );
            actor.should(
                    seeThat("El teléfono del usuario es correcto", actor -> actualUser.getPhone(), equalTo(expectedUser.getPhone()))
            );
            actor.should(
                    seeThat("El sitio web del usuario es correcto", actor -> actualUser.getWebsite(), equalTo(expectedUser.getWebsite()))
            );
        }
    }


}
