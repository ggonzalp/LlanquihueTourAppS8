package data;

import model.*;

import java.util.ArrayList;

/**
 * Gestor de entidades que pueden ser personas o empresas. Almacena objetos que implementan Registrable.
 * Construye un resumen del listado, diferenciando cada tipo mediante instanceof.
 */

public class GestorEntidades {

    private ArrayList<Registrable> listaPersonas;

    public GestorEntidades() {
        listaPersonas = new ArrayList<>();
    }

    /**
     * Método que permite agregar una persona al sistema.
     * @param entidad se refiere a la persona que es agregada al sistema.
     */
    public void agregarPersona(Entidad entidad) {
        listaPersonas.add(entidad);
    }

    /**
     * Construye el resumen de todas las personas registradas, indicando
     * el tipo de persona detectado a través de un instanceof.
     * @return resumen del listado de personas, o un mensaje
     * indicando que no hay personas o empresas registradas.
     */
    public String mostrarResumenPersonas() {

        if (listaPersonas.isEmpty()) {
            return "No hay personas registradas";
        }

        String resumen = "------------------------------------------\n";

        for (Registrable persona : listaPersonas) {

            if (persona instanceof Cliente) {
                Cliente cliente = (Cliente) persona;

                resumen += "\nTipo detectado: Cliente. ";
                resumen += cliente.mostrarInformacion();

            } else if (persona instanceof Trabajador) {
                Trabajador trabajador = (Trabajador) persona;

                resumen += "\nTipo detectado: Trabajador. ";
                resumen += trabajador.mostrarInformacion();

            } else if (persona instanceof Proveedor) {
                Proveedor proveedor = (Proveedor) persona;

                resumen += "\nTipo detectado: Proveedor. ";
                resumen += proveedor.mostrarInformacion();
            }

            resumen += "\n-------------------------------\n";
        }
        return resumen;
    }
}