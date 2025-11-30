**Descripción del Proyecto:**

Realizar la actividad de la tarea 1 Unidad 4 Programación Limpia tiene como propósito completar y mejorar el sistema de "Contenido Audiovisual" con manejo de archivos, añadiendo datos sobre las clases Películas, Series de TV, Documentales, Actores, Temporadas e Investigadores.

Las características principales del proyecto son:

- Aplicar principios de código limpio, refactorización, y SOLID para mejorar la mantenibilidad y calidad del código.
- La creación de nuevas clases con la implementación de los atributos, métodos y relaciones definidas. 
- Implementar un patrón de diseño para separar el modelo, la vista y el controlador (MVC).
- La creación de un diagrama de clases del proyecto con las convenciones del UML. 
- Desarrollar pruebas unitarias que cubran las funcionalidades clave del sistema utilizando JUnit.
- La creación de un repositorio personal con el proyecto subido en GitHub. 
- La gestión del repositorio con commits, descripciones y el archivo README.md

Se finaliza con la validación de la correcta funcionalidad del sistema y sin errores aparentes.


***Etapa 1. Manejo de Archivos***

Nuevas clases y funcionalidades añadidas:

**Modelo:**

- La clase ScannerContenidosAudovisuales para la lectura de datos del archivo estado\_del\_sistema.csv
- La clase BufferedWriterContenidosVisuales para la escritura de datos a un archivo creado estado\_actualizado.csv
- La clase GestorContenidos contiene la lista de ContenidosAudiovisuales y la lógica de negocio (Modelo) e Interactúa con las clases de Persistencia (Scanner/BufferedWriter).

**Vista**

- MenuVista: Se encarga de la interfaz de usuario (mostrar menú, capturar entrada).

**Controlador**

- ContenidoController: Punto de entrada (main) y coordinador entre la Vista y el Modelo.

***Etapa 2. Refactorización y Código Limpio***

Mejoras en el código de las siguientes clases cuyo propósito es la integración de las nuevas clases de manejo de archivos al sistema Contenido Audiovisual y establecer relaciones con las clases existentes.

- ContenidoAudiovisual, Películas, Series de TV, Documentales, Actores, Temporadas e Investigadores.

***Etapa 3. Aplicación de Principios SOLID***

Se aplican principios SOLID para mejorar el diseño y estructura del sistema.

***Etapa 4. Implementación del Patrón MVC***

Separación de las preocupaciones del sistema en Modelo, Vista y Controlador.

***Etapa 5. Desarrollo de Pruebas Unitarias*** 

Implementación de pruebas unitarias para todas las clases principales en la carpeta `test/` con el framework de pruebas unitarias para Java y la JVM JUnit.

***Desarrollo de un diagrama de clases del proyecto.*** 

- UML\_ContenidoAudiovisual.uxf

***Se agregan 1 commit en la rama master:*** 

- Sistema de Contenido Audiovisual actualizado a  Código Limpio -  Commit 242172e      by JorMindJ 

***Instrucciones para clonar y ejecutar el proyecto.***

1. Paso: Abrir IDE Eclipse y selecciona la opción "Importar un proyecto desde GitHub".
1. Paso: Utilizar el enlace proporcionado para clonar el repositorio en tu entorno de desarrollo. 
1. Paso: Verificar que el proyecto se ha importado correctamente. 
1. Paso: Dirigirse hacia el proyecto importado en el Paquete de Exploración del IDE, darle click derecho y seleccionar Run As en Java Application, funcionalidad que permite la interpretación y ejecución del código fuente del proyecto.
1. Paso: Dirigirse hacia el proyecto importado en el Paquete de Exploración del IDE, darle click derecho y seleccionar Run As en JUnit test para la ejecución de las clases contenidas en la carpeta `test/` del proyecto.
