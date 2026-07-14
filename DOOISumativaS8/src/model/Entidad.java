package model;

/**
 * Clase que representa a la empresa o persona que puede ser cliente,
 * trabajador o proveedor con sus correspondientes atributos
 * nombre y su rut.
 * Además contiene los validadores de contenido para
 * sus atributos.
 */

public abstract class Entidad implements Registrable {

    //Atributos de la persona
    private String nombre;

    //Componente de la clase persona. La persona tiene un rut.
    private Rut rut;

    /**
     * Constructor de la clase Persona
     *
     * @param nombre nombre de la persona.
     * @param rut    rut de la persona.
     */

    public Entidad(String nombre, Rut rut) {

        //LLamada al validador
        if (validarNombre(nombre)) {
            throw new IllegalArgumentException("Ingrese nombre valido.");
        }

        //Asignación de atributos
        this.nombre = nombre;
        this.rut = rut;
    }

    //Validadores
    private static boolean validarNombre(String nombre) {
        return nombre == null || nombre.trim().isEmpty();
    }

    //Métodos getter
    public String getNombre() {
        return nombre;
    }

    public Rut getRut() {
        return rut;
    }

    //Métodos setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //setRut: el RUT es un dato sensible que no debe modificarse.

    /**
     * Método mostrarInformacion
     * @return los datos de la persona incluyendo nombre y rut.
     */

    public String mostrarInformacion() {
        return "\n--- Datos de la persona ---" +
                "\n Nombre: " + nombre +
                "\n Rut: " + rut;
    }

    /**
     * Método mostrarResumen
     * @return el mensaje de confirmación de registro.
     */

    @Override
    public String mostrarResumen() {
        return "Persona registrada correctamente.";
    }
}
