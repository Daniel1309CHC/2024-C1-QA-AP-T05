//package co.com.sofka.stepsdefinitions;
//
//
//import co.com.sofka.Setup.SetupService;
//import co.com.sofka.modelos.CharacterModel;
//import co.com.sofka.questions.CharacterGetResponse;
//import co.com.sofka.questions.ResponseCode;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import static co.com.sofka.tasks.services.DoGet.doGet;
//import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.notNullValue;
//
//public class CharacterStepDefinition extends SetupService {
//
//
//    @Given("que el usuario tiene acceso a la API de Marvel")
//    public void queElUsuarioTieneAccesoALaAPIDeMarvel() {
//        setupService();
//    }
//
//    @When("realiza una solicitud GET al servcio {string} para buscar el personaje con el ID {int}")
//    public void realizaUnaSolicitudGETParaBuscarElPersonajeConElID(String servicio, Integer idCharacter) {
//        actor.attemptsTo(
//                doGet().withTheResource(servicio,idCharacter)
//        );
//
//    }
//    @Then("la respuesta debería tener el código de estado {int}")
//    public void laRespuestaDeberíaTenerElCódigoDeEstado(Integer codEstado) {
//        actor.should(
//                seeThat("The status code", ResponseCode.was(), equalTo(codEstado))
//        );
//    }
//    @Then("la respuesta debería incluir la información correcta del personaje con nombre {string} personaje con ID {int}")
//    public void laRespuestaDeberíaIncluirLaInformaciónDelPersonajeConIDId(String nombre ,int idCharacter) {
//        CharacterModel character = actor.asksFor(CharacterGetResponse.expected());
//
//        // Realizar aserciones sobre los atributos del CharacterModel
//        actor.should(
//                seeThat("El id del personaje es correcto",
//                        actor -> character.getId(), equalTo(idCharacter))
//        );
//        actor.should(
//                seeThat("El nombre del personaje es correcto",
//                        actor -> character.getNombre(), equalTo(nombre))
//        );
//        actor.should(
//                seeThat("La descripción del personaje es correcta",
//                        actor -> character.getDescripcion(), notNullValue())
//        );
//        actor.should(
//                seeThat("Los derechos de autor del personaje son correctos",
//                        actor -> character.getCopyright(), notNullValue())
//        );
//    }
//
//}
