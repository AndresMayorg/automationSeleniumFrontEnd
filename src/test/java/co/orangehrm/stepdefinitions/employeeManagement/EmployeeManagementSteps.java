package co.orangehrm.stepdefinitions.employeeManagement;

import co.orangehrm.pages.addEmployee.AddEmployeePage;
import co.orangehrm.pages.home.HomePage;
import co.orangehrm.pages.viewDirectory.ViewDirectoryPage;
import co.orangehrm.utils.dataReader.ExcelDataHandler;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.io.IOException;
import java.util.Map;

public class EmployeeManagementSteps {
    ExcelDataHandler dataExcel = new ExcelDataHandler();

    @Steps
    private HomePage homePage;

    @Steps
    private AddEmployeePage addEmployeePage;

    @Steps
    private ViewDirectoryPage viewDirectoryPage;

    @When("Realizo el registro de un nuevo empleado")
    public void realizo_el_registro_de_un_nuevo_empleado(Map<String,String> data) throws IOException {
        String filaDataExcel =data.get("keyFilaDataExcel");
        String feature =data.get("keyFeature");
        data=dataExcel.readExcelRowData(feature,  Integer.parseInt(filaDataExcel));
        homePage.gotoPIM();
        addEmployeePage.registerEmployee(data.get("firstName"), data.get("lastName"));
    }

    @When("Ingreso al directorio de empleados y realizo busqueda del registro guardado")
    public void ingreso_al_directorio_de_empleados_y_realizo_busqueda_del_registro_guardado(Map<String,String> data) throws IOException {
        String filaDataExcel =data.get("keyFilaDataExcel");
        String feature =data.get("keyFeature");
        data=dataExcel.readExcelRowData(feature,  Integer.parseInt(filaDataExcel));
        homePage.gotoDirectory();
        viewDirectoryPage.searchEmployee(data.get("firstName"));
    }

    @Then("Valido la información del empleado coincide con los datos introducidos")
    public void valido_la_información_del_empleado_coincide_con_los_datos_introducidos(Map<String,String> data) throws IOException {
        String filaDataExcel =data.get("keyFilaDataExcel");
        String feature =data.get("keyFeature");
        data=dataExcel.readExcelRowData(feature,  Integer.parseInt(filaDataExcel));
        viewDirectoryPage.validateEmployeeName(data.get("fullName"));
    }
}
