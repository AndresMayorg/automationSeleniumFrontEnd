package co.orangehrm.ui.viewDirectoryUI;

import org.openqa.selenium.By;

public class ViewDirectoryUI {
    public static final By EMPLOYE_NAME_TXT = By.cssSelector("div[class='oxd-grid-3'] div:nth-child(1) div:nth-child(1) div:nth-child(1) label:nth-child(1)");
    public static final By EMPLOYE_NAME_FIELD = By.cssSelector("input[placeholder='Type for hints...']");
    public static final By EMPLOYE_NAME_LIST = By.xpath("//div[@role='listbox']");
    public static final By SEARCH_BUTTON = By.cssSelector("button[type='submit']");
    public static final By FULL_NAME_EMPLOYEE_TXT = By.cssSelector(".oxd-text.oxd-text--p.orangehrm-directory-card-header.--break-words");
    public static final By PROFILE_PICTURE_IMAGE = By.cssSelector("img[alt='Profile Picture']");
}
