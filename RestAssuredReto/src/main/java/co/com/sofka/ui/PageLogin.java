package co.com.sofka.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class PageLogin extends PageObject {

    public static final Target BOTON_SIGN_UP = Target.
            the("boton inicio de sesion").located(By
                    .cssSelector("a[href='/login']"));

    public static final Target CAMPO_USER = Target.
            the("campo usuario").located(By
                    .xpath("//*[@name='name']"));

    public static final Target CAMPO_CORREO = Target.
            the("campo correo").located(By
                    .xpath("//input[@data-qa='signup-email']"));

    public static final Target BOTON_ACCEPT = Target.
            the("boton aceptar").located(By
                    .xpath("//button[text()='Signup']"));
}
