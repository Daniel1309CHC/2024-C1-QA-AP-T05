//package co.com.sofka.stepsdefinitions;
//
//
//import co.com.sofka.Setup.SetupService;
//import co.com.sofka.modelos.ComicModel;
//import co.com.sofka.questions.ComicGetResponse;
//import co.com.sofka.questions.ResponseCode;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import static co.com.sofka.ConstantesAssertions.ComicAssertions.DESC;
//import static co.com.sofka.ConstantesAssertions.ComicAssertions.FORMAT;
//import static co.com.sofka.tasks.services.DoGet.doGet;
//import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
//import static org.hamcrest.CoreMatchers.equalTo;
//
//
//public class ComicStepDefinition extends SetupService {
//
//    private ComicModel comic;
//
//    @Given("que el usuario tiene acceso a la API Marvel")
//    public void queElUsuarioTieneAccesoALaAPIDeMarvel() {
//        setupService();
//    }
//
//    @When("realiza una solicitud GET al servcio {string} para buscar el cómic con el ID {int}")
//    public void realizaUnaSolicitudGETParaBuscarElCómicConElID(String servicio, Integer idComic) {
//        actor.attemptsTo(
//                doGet().withTheResource(servicio,idComic)
//        );
//    }
//
//    @Then("la respuesta debería tener un código de estado {int}")
//    public void laRespuestaDeberíaTenerElCódigoDeEstado(Integer codEstado) {
//        actor.should(
//                seeThat("The status code", ResponseCode.was(), equalTo(codEstado))
//        );
//    }
//
//    @Then("la respuesta debería incluir la información correcta del comic con título {string} y ID {int}")
//    public void laRespuestaDeberíaIncluirLaInformaciónCorrectaDelCómicConTítuloYID(String titulo, int idComic) {
//        // Obtener el ComicModel de la respuesta de la prueba
//         this.comic = actor.asksFor(ComicGetResponse.expected());
//
//        // Realizar aserciones sobre los atributos del ComicModel
//        actor.should(
//                seeThat("El id del comic es correcto",
//                        actor -> comic.getId(), equalTo(idComic))
//        );
//        actor.should(
//                seeThat("El título del comic es correcto",
//                        actor -> comic.getTitle(), equalTo(titulo))
//        );
//        actor.should(
//                seeThat("La descripción del comic es correcta",
//                        actor -> comic.getDescription(), equalTo(DESC))
//        );
//
//        // Asegurarse de que el formato del comic no sea nulo
//        actor.should(
//                seeThat("El formato del comic no es nulo",
//                        actor -> comic.getFormat(), equalTo(FORMAT))
//        );
//    }
//
//    @Then("la respuesta debería tener un codigo ISBN {string} asociado")
//    public void laRespuestaDeberíaTenerUnCodigoISBNAsociado(String isbn) {
//        actor.should(
//                seeThat("El ISBN del comic es correcto",
//                        actor -> comic.getIsbn(), equalTo(isbn))
//        );
//    }
//}
