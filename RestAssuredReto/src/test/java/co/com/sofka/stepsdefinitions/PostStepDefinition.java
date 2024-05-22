package co.com.sofka.stepsdefinitions;

import co.com.sofka.Setup.SetupService;
import co.com.sofka.models.Post;
import co.com.sofka.questions.services.ResponseCode;
import co.com.sofka.questions.services.ReturnResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

import static co.com.sofka.ConstantesAssertions.Paths.*;
import static co.com.sofka.tasks.services.DoGet.doGet;
import static co.com.sofka.tasks.services.DoPost.doPost;
import static co.com.sofka.utils.Util.crearPost;
import static co.com.sofka.utils.jsonparser.JsonCommon.jsonToObject;
import static co.com.sofka.utils.jsonparser.PostParser.postToJson;
import static co.com.sofka.utils.jsonparser.PostParser.toPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostStepDefinition extends SetupService {

    private Post post;
    @Given("que el usuario esta autenticado en el aplicativo web")
    public void que_el_usuario_esta_autenticado_en_el_aplicativo_web() {
        setupService(URL_BASE_JSON_PLACEHOLDER);
    }
    @When("se hace una solicitud Post para agregar un nuevo post")
    public void se_hace_una_solicitud_post_para_agregar_un_nuevo_post() {
        this.post = crearPost();
        actor.attemptsTo(
                doPost().withTheResource(SERVICE_POST).andTheBody(postToJson(post))
        );
    }
    @Then("el código de respuesta de estado debería ser {int}")
    public void el_código_de_respuesta_de_estado_debería_ser(Integer codEstado) {
        actor.should(
                seeThat("The status code", ResponseCode.was(), equalTo(codEstado))
        );
    }
    @Then("la respuesta debería incluir y validar la información del post creado")
    public void la_respuesta_debería_incluir_y_validar_la_información_del_post_creado() {

        actor.should(
                seeThat("The body doesn't empty", ReturnResponse.returnResponse(), notNullValue())
        );

        Post currentPost = toPost(jsonToObject(actor.asksFor(ReturnResponse.returnResponse())));

        // Comparar los atributos del post creado con la respuesta recibida
        actor.should(
                seeThat("El título del post es correcto",
                        actor -> currentPost.getTitle(), equalTo(post.getTitle()))
        );
        actor.should(
                seeThat("El cuerpo del post es correcto",
                        actor -> currentPost.getBody(), equalTo(post.getBody()))
        );
        actor.should(
                seeThat("El userId del post es correcto",
                        actor -> currentPost.getUserId(), equalTo(post.getUserId()))
        );

    }
}
