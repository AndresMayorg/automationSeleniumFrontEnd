package co.orangehrm.ui.loginUI;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By USERNAME_FIELD = By.name("username");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    public static final By LBL_HOME = By.xpath("//h6[normalize-space()='Dashboard']");

}
