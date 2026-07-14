package model;

/**
 * Interfaz Registrable que muestra el resumen de la información registrada y cada clase que la implemente
 * retornará el mensaje de confirmación de registro.
 * Esta interfaz es implementada por la clase Persona y por herencia sus tres clases hijas (Cliente, Trabajador y Proveedor).
 */

public interface Registrable {

    /**
     * Entrega el mensaje de confirmación de registro correspondiente al tipo de Persona.
     * @return mensaje de confirmación de registro.
     */
    public String mostrarResumen();

}
