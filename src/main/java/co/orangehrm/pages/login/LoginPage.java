package co.orangehrm.pages.login;

import co.orangehrm.ui.loginUI.LoginPageLocators;
import co.orangehrm.utils.webActions.WebActions;
import net.serenitybdd.core.pages.PageObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginPage extends PageObject {

    WebActions actions;

    public void login (String username, String password) {
        actions.enterText(LoginPageLocators.USERNAME_FIELD, "Campo de Usuario", username);
        actions.enterText(LoginPageLocators.PASSWORD_FIELD, "Campo de Contraseña", password);
        actions.clickElement(LoginPageLocators.LOGIN_BUTTON, "Botón de Login");
   }

    public void validateLoginPage() {
        assertThat("Validando texto dashboard", actions.isElementVisible(LoginPageLocators.LBL_HOME,"texto Dashboard"), equalTo(true));
    }
}
