package co.orangehrm.utils.webActions;

import co.orangehrm.utils.logger.TestLogger;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import java.time.Duration;

public class WebActions extends PageObject {

    private final TestLogger TEST_LOGS = new TestLogger();
    private static final int DEFAULT_WAIT_TIME = 60;
    public WebActions() {}

    private WebElement waitForElement(By by, String elementName, int waitForSeconds) {
        TEST_LOGS.writeLog("Esperando elemento visible: " + elementName + " con locator: " + by.toString());
        try {
            WebElement element = find(by).withTimeoutOf(Duration.ofSeconds(waitForSeconds)).waitUntilVisible();
            TEST_LOGS.writeLog("Elemento '" + elementName + "' encontrado y visible.");
            return element;
        } catch (TimeoutException e) {
            TEST_LOGS.writeLog("ERROR: Elemento '" + elementName + "' NO se hizo visible después de " + waitForSeconds + " segundos.");
            return null;
        } catch (Exception e) {
            TEST_LOGS.writeLog("ERROR inesperado al esperar el elemento '" + elementName + "': " + e.getMessage());
            return null;
        }
    }

    private WebElement waitForElementPresent(By by, String elementName, int waitForSeconds) {
        TEST_LOGS.writeLog("Esperando elemento presente en el DOM: " + elementName + " con locator: " + by.toString());
        try {
            WebElement element = find(by).withTimeoutOf(Duration.ofSeconds(waitForSeconds)).waitUntilPresent();
            TEST_LOGS.writeLog("Elemento '" + elementName + "' encontrado y presente en el DOM.");
            return element;
        } catch (TimeoutException e) {
            TEST_LOGS.writeLog("ERROR: Elemento '" + elementName + "' NO se encontró en el DOM después de " + waitForSeconds + " segundos.");
            return null;
        } catch (Exception e) {
            TEST_LOGS.writeLog("ERROR inesperado al esperar el elemento '" + elementName + "': " + e.getMessage());
            return null;
        }
    }

    public boolean isElementVisible(By by, String elementName) {
        return waitForElement(by, elementName, DEFAULT_WAIT_TIME) != null;
    }

    public boolean clickElement(By by, String elementName) {
        WebElement element = waitForElement(by, elementName, DEFAULT_WAIT_TIME);

        if (element != null) {
            try {
                TEST_LOGS.writeLog("Haciendo clic en el elemento: " + elementName);
                element.click();
                return true;
            } catch (Exception e) {
                TEST_LOGS.writeLog("ERROR al intentar hacer clic en '" + elementName + "': " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public boolean enterText(By by, String elementName, String text) {
        WebElement element = waitForElement(by, elementName, DEFAULT_WAIT_TIME);

        if (element != null) {
            try {
                TEST_LOGS.writeLog("Escribiendo texto '" + text + "' en el campo: " + elementName);
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                TEST_LOGS.writeLog("ERROR al intentar escribir en '" + elementName + "': " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public boolean uploadFile(By by, String elementName, String absoluteFilePath) {
        WebElement element = waitForElementPresent(by, elementName, DEFAULT_WAIT_TIME);
        if (element != null) {
            try {
                TEST_LOGS.writeLog("Subiendo archivo: " + elementName + " con ruta: " + absoluteFilePath);
                element.sendKeys(absoluteFilePath);
                TEST_LOGS.writeLog("Archivo subido exitosamente en el campo: " + elementName);
                return true;
            } catch (Exception e) {
                TEST_LOGS.writeLog("ERROR al intentar subir el archivo en '" + elementName + "': " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public String getElementText(By by, String elementName) {
        WebElement element = waitForElement(by, elementName, DEFAULT_WAIT_TIME);
        if (element != null) {
            TEST_LOGS.writeLog("Obteniendo texto del elemento: " + elementName);
            return element.getText();
        }
        return "";
    }

    public void waitInSeconds(int seconds) {
        if (seconds > 0) {
            TEST_LOGS.writeLog("Haciendo pausa estática forzada por " + seconds + " segundos...");
            try {
                Thread.sleep(seconds * 1000L);
                TEST_LOGS.writeLog("Pausa finalizada.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                TEST_LOGS.writeLog("La pausa fue interrumpida: " + e.getMessage());
            }
        }
    }

}
