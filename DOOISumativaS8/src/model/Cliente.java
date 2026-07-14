package model;

/**
 * Clase que representa a un cliente.
 * Incluye nacionalidad.
 */

public class Cliente extends Entidad {

    //Atributos de la clase Cliente
    private String nacionalidad;

    /**
     * Constructor de la clase cliente
     * @param nombre       nombre del cliente.
     * @param rut          número de rut o pasaporte del cliente.
     * @param nacionalidad nacionalidad del cliente.
     */
    public Cliente(String nombre, Rut rut, String nacionalidad) {
        super(nombre, rut);

        //Asignación de atributos.
        this.nacionalidad = nacionalidad;
    }

    //Método getter
    public String getNacionalidad() {
        return nacionalidad;
    }


    //Método setter
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Metodo mostrarInformación:
     * @return datos del cliente
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nNacionalidad: " + nacionalidad;
    }

    /**
     * Método mostrarResumen
     * @return el mensaje de confirmación de registro del cliente.
     */
    @Override
    public String mostrarResumen() {
        return "Cliente registrado correctamente.";
    }

}



