package model;

/**
 * Clase que representa a un proveedor.
 * Incluye su giro empresarial.
 */

public class Proveedor extends Entidad {

    //Atributos de la clase proveedor
    private String giroEmpresarial;

    /**
     * Constructor de la clase proveedor.
     * @param nombre            nombre del proveedor.
     * @param rut               rut del proveedor.
     * @param giroEmpresarial   giro de la empresa proveedora.
     */

    public Proveedor(String nombre, Rut rut, String giroEmpresarial) {
        super(nombre, rut);

        //Asignación de atributos
        this.giroEmpresarial = giroEmpresarial;
    }

    //Método getter
    public String getGiroEmpresarial() {
        return giroEmpresarial;
    }

    //Método setter
    public void setGiroEmpresarial(String giroEmpresarial) {
        this.giroEmpresarial = giroEmpresarial;
    }

    /**
     * Metodo mostrarInformación
     * @return datos del proveedor.
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nGiro Empresarial: " + giroEmpresarial;
    }

    /**
     * Método mostrarResumen
     * @return el mensaje de confirmación de registro del proveedor
     */
    @Override
    public String mostrarResumen() {
        return "Proveedor registrado correctamente.";
    }
}


