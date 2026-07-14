package ui;

import javax.swing.*;

/**
 * Clase principal del proyecto LlanquihueTourApp
 * Es el punto de entrada al programa.
 */

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioRegistro().setVisible(true);
        });
    }
}

