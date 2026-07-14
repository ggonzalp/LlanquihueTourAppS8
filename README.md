* LlanquihueTourApp

Descripción de la propuesta de proyecto para la agencia Llanquihue Tour.
En esta octava semana debemos formular una interfaz de comportamiento común, aplicando
herencia y poliformismo entre clases que representan las distintas personas que pueden llegar 
a registrarse en el sistema de LLanquihueTourApp.
También tenemos que utilizar colecciones genéricas para almacenar y recorrer objetos diferenciándolos
mediante instanceof.
Con toda esta información debemos crear una interfaz gráfica simple para el usuario donde se le permita
ingresar nuevos objetos y mostrar los existentes.

* Tecnologías utilizadas
- Java 23
- IntellijIdea

* Estructura del proyecto
LlanquihueTourApp/
└── src/
    ├── data/
    │   └── GestorEntidades.java
    ├── model/
    │   ├── Cliente.java
    │   ├── Entidad.java
    │   ├── Proveedor.java
    │   ├── Registrable.java
    │   ├── Rut.java
    │   └── Trabajador.java
    └── ui/
        ├── FormularioRegistro.java
        └── Main.java

  * Paquetes y clases (Semana 8)
1. data
   1.1 GestorPersonas: Clase que representa al gestor de datos de las personas registradas en el sistema.
2. model
   2.1 Cliente: Clase herencia de Persona que representa a un cliente con su nombre, rut y, como dato específico, nacionalidad.
   2.2 Persona: Clase abstracta, padre de las clases Cliente, Proveedor y Trabajador. Implementa la interfaz Registrable y define los atributos comunes como lo son el formato de nombre y rut que sus hijas heredan junto con la implementación de la interfaz.
   2.3 Proveedor: Clase herencia de Persona que representa a un proveedor con su nombre (de empresa), rut (de empresa) y, como dato específico, giro empresarial.
   2.4 Registrable: Interfaz que muestra el resumen de la información registrada y cada clase que la implemente retornará el mensaje de confirmación de registro.
Esta interfaz es implementada por la clase Persona y por herencia sus tres clases hijas (Cliente, Trabajador y Proveedor).
   2.5 Rut: Clase que representa el rut de la persona con su formato y validador.
   2.6 Trabajador: Clase herencia de Persona que representa a un trabajador con su nombre, rut y, como dato específico, sección laboral.
3. ui
   3.1 FormularioRegistro: Clase que representa la Interfaz Gráfica del Usuario GUI. Permite registrar personas (clientes, trabajadores o proveedores) mediante un formulario y visualizar el listado de personas registradas.
   3.2 Main: Clase principal que da inicio al sistema.

* Ejecución

1° Clonar el repositorio: git clone 

2° Abrir el proyecto en IntelliJ IDEA

3° Ejecutar la clase principal: src/ui/Main.java

4° El programa mostrará una ventana en donde se dispone un botón con menú desplegable, campos de texto, botones de control y pantalla para mostrar información.

Autoría Estudiante: Gabriela González Peirano 
Asignatura: Desarrollo Orientado a Objetos I 
Instituto: DuocUC
