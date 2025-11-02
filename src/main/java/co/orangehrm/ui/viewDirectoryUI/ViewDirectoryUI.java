package co.orangehrm.ui.viewDirectoryUI;

import org.openqa.selenium.By;

public class ViewDirectoryUI {
    public static final By EMPLOYE_NAME_TXT = By.xpath("//label[normalize-space()='Employee Name']");
    public static final By EMPLOYE_NAME_FIELD = By.cssSelector("input[placeholder='Type for hints...']");
    public static final By EMPLOYE_NAME_LIST = By.xpath("//div[@role='listbox']");
    public static final By SEARCH_BUTTON = By.cssSelector("button[type='submit']");
    public static final By FULL_NAME_EMPLOYEE_TXT = By.cssSelector(".oxd-text.oxd-text--p.orangehrm-directory-card-header.--break-words");
    public static final By PROFILE_PICTURE_IMAGE = By.cssSelector("img[alt='Profile Picture']");
}
