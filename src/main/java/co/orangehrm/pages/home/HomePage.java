package co.orangehrm.pages.home;

import co.orangehrm.ui.homeUI.HomeLocators;
import co.orangehrm.utils.webActions.WebActions;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {

    WebActions actions;

    public void gotoPIM () {
        actions.clickElement(HomeLocators.PIM_BUTTON, "Botón PIM");
    }

    public void gotoDirectory () {
        actions.clickElement(HomeLocators.DIRECTORY_BUTTON, "Botón Directory");
    }

}
