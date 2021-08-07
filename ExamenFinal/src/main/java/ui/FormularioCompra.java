package ui;
import net.serenitybdd.screenplay.targets.Target;

public class FormularioCompra {
    public static final Target LBL_FISH = Target.the("Label para elegir el pez")
            .locatedBy("//a[normalize-space()='Fresh Water fish from China']");

    public static final Target BTN_ADD_TO_CART = Target.the("Boton para añadir al carro")
            .locatedBy("//tbody/tr[3]/td[5]/a[1]");

    public static final Target BTN_PROCEED_TO_CHECKOUT = Target.the("Boton para ir a checkout")
            .locatedBy("//a[normalize-space()='Proceed to Checkout']");

    public static final Target DDL_CARD = Target.the("Dropdown List de tarjetas")
            .locatedBy("//select[@name='order.cardType']");

    public static final Target TXT_CARD_NUMBER = Target.the("Numero de tarjeta")
            .locatedBy("//input[@name='order.creditCard']");

    public static final Target BTN_CONTINUE = Target.the("Boton para continuar")
            .locatedBy("//input[@name='newOrder']");

    public static final Target BTN_CONFIRM = Target.the("Boton para continuar")
            .locatedBy("//a[normalize-space()='Confirm']");

    public static final Target LBL_MENSAJE = Target.the("Mensaje de confirmacion")
            .locatedBy("//li[normalize-space()='Thank you, your order has been submitted.']");
}
