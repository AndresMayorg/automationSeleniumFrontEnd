package co.orangehrm.pages.addEmployee;

import co.orangehrm.ui.addEmployeUI.AddEmployeUI;
import co.orangehrm.utils.webActions.WebActions;
import net.serenitybdd.core.pages.PageObject;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class AddEmployeePage extends PageObject {

    WebActions actions;

    private final String PHOTO_FIELD_NAME = "Campo de Carga de Foto de Perfil";
    private final String IMAGE_RELATIVE_PATH = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "files" + File.separator + "image.jpg";

    public void enterToAddEmployeeForm(){
        actions.clickElement(AddEmployeUI.ADD_EMPLOYEE_BUTTON, "Botón Add");
    }

    public void registerFullNameEmployee(String firstName, String lastName) {
        assertThat("Validando texto Employee Full Name", actions.isElementVisible(AddEmployeUI.EMPLOYEE_FULL_NAME_LBL,"texto Employee Full Name"), equalTo(true));
        actions.enterText(AddEmployeUI.FIRST_NAME_FIELD, "Campo First Name", firstName);
        actions.enterText(AddEmployeUI.LAST_NAME_FIELD, "Campo Last Name", lastName);
    }

    public void incrementAndEnterEmployeeId() {
        String currentId = actions.getElementAttribute(AddEmployeUI.EMPLOYEE_ID, "value", "Campo Employee ID");
        if (currentId != null && !currentId.trim().isEmpty()) {
            try {
                int nextIdInt = Integer.parseInt(currentId) + 1;
                String nextIdStr = String.format("%0" + currentId.length() + "d", nextIdInt);
                actions.clearElementForce(AddEmployeUI.EMPLOYEE_ID, "Campo Employee ID");
                actions.enterText(AddEmployeUI.EMPLOYEE_ID, "Campo Employee ID", nextIdStr);

            } catch (NumberFormatException e) {
                System.err.println("Error: El valor '" + currentId + "' no es un número válido.");
            }
        } else {
            System.err.println("Error: No se pudo obtener el ID actual o está vacío.");
        }
    }

    public boolean uploadProfilePicture() {
        String projectDir = System.getProperty("user.dir");
        String absoluteFilePath = projectDir + File.separator + IMAGE_RELATIVE_PATH;
        return actions.uploadFile(AddEmployeUI.PHOTO_INPUT_FIELD, PHOTO_FIELD_NAME, absoluteFilePath);
    }

    public void saveEmployee() {
        actions.clickElement(AddEmployeUI.SAVE_BUTTON, "Botón Save");
        assertThat("Validando texto Success", actions.isElementVisible(AddEmployeUI.SUCCESS_ADD_EMPLOYEE_TXT,"texto Success"), equalTo(true));
    }

    public void registerEmployee(String firstName, String lastName) {
        enterToAddEmployeeForm();
        registerFullNameEmployee(firstName, lastName);
        incrementAndEnterEmployeeId();
        uploadProfilePicture();
        saveEmployee();
    }

}
