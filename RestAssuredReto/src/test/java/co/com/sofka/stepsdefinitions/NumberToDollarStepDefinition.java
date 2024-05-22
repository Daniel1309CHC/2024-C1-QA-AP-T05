package co.com.sofka.stepsdefinitions;

import co.com.sofka.Setup.SetupService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jdom2.Element;

import static co.com.sofka.Constantes.HeaderConfiguration.headers;
import static co.com.sofka.Constantes.Paths.TO_WORD;
import static co.com.sofka.Constantes.Paths.URL_BASE_XML_SERVICE;
import static co.com.sofka.questions.services.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.services.DoPost.doPost;
import static co.com.sofka.utils.CommonXML.*;
import static co.com.sofka.utils.CommonXML.getNumberToWordsResult;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class NumberToDollarStepDefinition extends SetupService {

    @Given("que el usuario tiene acceso al servicio SOAP de conversión de números a palabras para dólares")
    public void queElUsuarioTieneAccesoAlServicioSOAPDeConversiónDeNúmerosAPalabrasParaDólares() {
        setupService(URL_BASE_XML_SERVICE);
    }
    @When("el usuario envía una solicitud Post al servicio SOAP con el valor de {double}")
    public void elUsuarioEnvíaUnaSolicitudPostAlServicioSOAPConElValorDe(double number) {
        actor.attemptsTo(
                doPost()
                        .withTheResource(TO_WORD)
                        .andHeaders(headers())
                        .andTheBody(getBodyToDolar(number))
        );

    }
    @Then("en la respuesta debería contener {string}")
    public void enLaRespuestaDeberíaContener(String dollars) {
        String xmlString = actor.asksFor(responseSoap());

        Element rootElement = xmlToElements(xmlString);

        String result = getNumberToDollarsResult(rootElement);

        actor.should(
                seeThat(
                        actor -> result, equalTo(dollars)
                )
        );
    }

}
