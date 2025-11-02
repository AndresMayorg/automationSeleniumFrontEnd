package co.orangehrm.stepdefinitions.authentication;

import co.orangehrm.pages.login.LoginPage;
import co.orangehrm.utils.dataReader.ExcelDataHandler;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

import java.io.IOException;
import java.util.Map;

public class AuthenticationSteps {

    ExcelDataHandler dataExcel = new ExcelDataHandler();

    @Steps
    private LoginPage loginPage;

    @Given("Como usuario registrado de OrangeHRM")
    public void como_usuario_registrado_de_orange_hrm(Map<String,String> data) throws IOException {
        String filaDataExcel =data.get("keyFilaDataExcel");
        String feature =data.get("keyFeature");
        data=dataExcel.readExcelRowData(feature,  Integer.parseInt(filaDataExcel));
        loginPage.open();
        loginPage.login(data.get("user"), data.get("password"));
        loginPage.validateLoginPage();
    }
}
