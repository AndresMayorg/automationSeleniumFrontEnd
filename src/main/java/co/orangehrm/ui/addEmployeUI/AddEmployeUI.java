package co.orangehrm.ui.addEmployeUI;

import org.openqa.selenium.By;

public class AddEmployeUI {
    public static final By ADD_EMPLOYEE_BUTTON = By.xpath("//button[normalize-space()='Add']");
    public static final By FIRST_NAME_FIELD = By.cssSelector("input[placeholder='First Name']");
    public static final By LAST_NAME_FIELD = By.cssSelector("input[placeholder='Last Name']");
    public static final By PHOTO_INPUT_FIELD = By.xpath("//input[@type='file' and contains(@class, 'oxd-file-input')]");
    public static final By SAVE_BUTTON = By.cssSelector("button[type='submit']");
    public static final By SUCCESS_ADD_EMPLOYEE_TXT = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    public static final By EMPLOYEE_FULL_NAME_LBL = By.cssSelector(".oxd-label.oxd-input-field-required");
}
