package co.orangehrm.pages.viewDirectory;

import co.orangehrm.ui.viewDirectoryUI.ViewDirectoryUI;
import co.orangehrm.utils.webActions.WebActions;
import net.serenitybdd.core.pages.PageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ViewDirectoryPage extends PageObject {
    WebActions actions;

    public void searchEmployee(String employeeName) {
        assertThat("Validando texto Employee Name", actions.isElementVisible(ViewDirectoryUI.EMPLOYE_NAME_TXT,"texto Employee Name"), equalTo(true));
        actions.enterText(ViewDirectoryUI.EMPLOYE_NAME_FIELD, "Campo Type for hints", employeeName);
        actions.waitInSeconds(5);
        actions.clickElement(ViewDirectoryUI.EMPLOYE_NAME_LIST, "Lista Employee Name");
        actions.clickElement(ViewDirectoryUI.SEARCH_BUTTON, "Boton Search");
    }

    public void validateEmployeeName(String employeeName) {
        assertThat("Validando texto Full Name Employee", actions.isElementVisible(ViewDirectoryUI.FULL_NAME_EMPLOYEE_TXT,"texto Full Name Employee"), equalTo(true));
        assertThat("Validando que el texto del campo contenga el Employee Name", actions.getElementText(ViewDirectoryUI.FULL_NAME_EMPLOYEE_TXT, "Campo Full Name Employee"), equalTo(employeeName));
        assertThat("Validando que el texto del campo contenga la imagen de perfil", actions.isElementVisible(ViewDirectoryUI.PROFILE_PICTURE_IMAGE,"imagen de perfil"), equalTo(true));
    }
}
