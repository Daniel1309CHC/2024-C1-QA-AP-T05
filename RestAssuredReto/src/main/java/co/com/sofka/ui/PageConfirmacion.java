package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageConfirmacion extends PageObject {

    public static final Target MENSAJE_CONFIRMACION = Target.the("mensaje").
            located(By.xpath("//*[@id='form']/div/div/div/div[1]/h2"));
}
