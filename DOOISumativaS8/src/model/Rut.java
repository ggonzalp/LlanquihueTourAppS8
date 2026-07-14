package model;

/**
 * Esta clase representa, almacena y valida el formato del rut
 * de la persona o empresa que se va a registrar.
 */

public class Rut {

    //Atributos de la clase rut
    private String numero;

    /**
     * Constructor de la clase Rut
     * @param numeroRUT rut de la persona.
     */

    public Rut(String numeroRUT) {

        //Validador
        if (!numeroRUT.matches("[0-9]{7,8}-[0-9kK]")) {
            throw new IllegalArgumentException("Formato de rut no valido");
        }
        this.numero = numeroRUT;
    }

    //Método getter
    public String getNumero() {
        return numero;
    }

    //Método setter
    // El RUT es un dato sensible que no debe ser modificado fácilmente.

    /**
     * Método toString:
     * @return datos del rut de la persona.
     */
    @Override
    public String toString() {
        return numero;
    }
}
