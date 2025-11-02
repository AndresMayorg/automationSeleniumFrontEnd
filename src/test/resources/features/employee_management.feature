Feature: Gestión y Verificación de Empleados en OrangeHRM
  Como administrador del sistema OrangeHRM
  Quiero agregar, modificar y buscar información de empleados
  Para asegurar la correcta gestión del persona

  @SuccessfulEmployeeCreation
  Scenario Outline: Gestión y Verificación de Empleados en OrangeHRM
  Given Como usuario registrado de OrangeHRM
    |keyFilaDataExcel    |<filaDataExcel>|
    |keyFeature          |<feature>      |
  When Realizo el registro de un nuevo empleado
    |keyFilaDataExcel    |<filaDataExcel>|
    |keyFeature          |<feature>      |
  And Ingreso al directorio de empleados y realizo busqueda del registro guardado
    |keyFilaDataExcel    |<filaDataExcel>|
    |keyFeature          |<feature>      |
  Then Valido la información del empleado coincide con los datos introducidos
    |keyFilaDataExcel    |<filaDataExcel>|
    |keyFeature          |<feature>      |

    Examples:
      |filaDataExcel  |feature               |
      |2              |employeeManagement    |