package model;

/**
 * Clase que representa a un trabajador
 * Incluye sección laboral.
 */

public class Trabajador extends Entidad {

    //Atributos de la clase trabajador
    private String seccion;

    /**
     * Constructor de la clase trabajador
     * @param nombre            nombre del trabajador.
     * @param rut               rut del trabajador.
     * @param seccion           sección laboral del trabajador.
     */

    public Trabajador(String nombre, Rut rut, String seccion) {
        super(nombre, rut);

        //Asignación de atributos
        this.seccion = seccion;
    }

    //Método getter
    public String getSeccion() {
        return seccion;
    }

    //Método setter
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * Método mostrarInformacion:
     * @return datos del trabajador.
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nSeccion: " + seccion;
    }

    /**
     * Método mostrarResumen
     * @return el mensaje de confirmación de registro del trabajador.
     */
    @Override
    public String mostrarResumen() {
        return "Trabajador registrado correctamente.";
    }

}
