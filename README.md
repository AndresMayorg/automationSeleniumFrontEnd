# OrangeHRM Automation Test Suite (Serenity BDD, Selenium, Java)

## Descripción Técnica y Enfoque

Este proyecto de automatización se implementa bajo el paradigma **Behavior-Driven Development (BDD)** utilizando Serenity BDD, Cucumber y Java. Está diseñado con una arquitectura robusta de tres capas que aplica el patrón **Page Object Model (POM)** para garantizar alta **mantenibilidad**, **reutilización de código** y bajo **acoplamiento** entre la lógica de negocio y los detalles de la interfaz de usuario (UI).

El enfoque de las pruebas cubre los flujos de inicio de sesión y el módulo PIM (Personal Information Management).

---

## Tecnologías y Dependencias

Para la ejecución se requiere:
* **Java Development Kit (JDK):** Versión 17 o superior.
* **Apache Maven:** Gestión de dependencias y *build*.
* **Navegador Web:** Google Chrome (gestionado por WebDriverManager/Serenity).

### Dependencias de Automatización (Maven)

| Dependencia | Propósito | Principio de Diseño |
| :--- | :--- | :--- |
| **Serenity Core** | Abstracción de reportes y manejo de WebDriver. | DRY (Don't Repeat Yourself) |
| **Serenity Cucumber**| Conexión del lenguaje Gherkin con los Steps de Java. | BDD / Legibilidad de Pruebas |
| **Selenium WebDriver** | Interacción de bajo nivel con la UI. | Abstracción de la Interfaz |
| **Apache POI** | Lectura de datos desde archivos Excel (`.xlsx`). | Separación de Data (Data-Driven Testing) |

---

## Arquitectura y Estructura del Proyecto

El proyecto sigue el estándar de Maven y Serenity BDD, utilizando una arquitectura de capas bien definida: **Features (Negocio) > Steps (Lógica) > UI (Interacción)**.

### 1. Estructura de Directorios (Árbol Gráfico)

La siguiente representación en árbol detalla la organización de los componentes y la separación de capas:

```text
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── co/orangehrm/
│   │   │       ├── ui/
│   │   │       │   └── [ComponenteLocators.java] (e.g., LoginLocators.java)
│   │   │       ├── pages/
│   │   │       │   ├── [PageObjects.java] (e.g., LoginPageUI.java) 
│   │   │       └── utils/
│   │   │           ├── WebActions.java (Abstracción de WebDriver)
│   │   │           └── [Helpers.java] (TestLogger, ExcelReader)
│   │   └── resources/
│   │       └── [Archivos de Configuración de Ejecución]
│   └── test/
│       ├── java/
│       │   └── co/orangehrm/
│       │       └── stepdefinitions/
│       │           └── [StepDefinitions.java] 
│       └── resources/
│           ├── features/
│           │   └── [Modulo]/
│           │       └── [Historia.feature] 
│           ├── serenity.properties (Config. de Entorno)
│           └── data/
│               └── DataFile.xlsx (Datos para DDT)
│
├── target/
│   └── site/
│       └── serenity/
│           └── index.html (Reporte Final)
│
└── pom.xml (Configuración de Maven)
```

## Ejecucion de pruebas

El proyecto permite alternar entre ejecución local o remota mediante el parámetro -Denvironment.

1. Ejecución Local
   Usa este comando para correr las pruebas en tu máquina. El navegador Chrome se abrirá automáticamente.

mvn clean verify -Denvironment=local
2. Ejecución en la Nube (BrowserStack)
   Usa este comando para delegar la ejecución a la infraestructura de BrowserStack.

mvn clean verify -Denvironment=browserstack
3. Ejecución por Tags (Filtro)
   Para ejecutar solo un escenario o funcionalidad específica:

mvn clean verify -Dcucumber.filter.tags="@SuccessfulEmployeeCreation"

## Reportes y Evidencia

Serenity BDD genera reportes vivos de alta calidad tras cada ejecución.

Ubicación del Reporte: Una vez terminada la ejecución, abre el archivo:

target/site/serenity/index.html

Contenido: El reporte incluye capturas de pantalla de cada paso, registros de tiempo, logs de consola y estados detallados (Éxito/Fallo).

BrowserStack: Para ejecuciones remotas, puedes ver el video y logs de red en el Dashboard de BrowserStack Automate.

