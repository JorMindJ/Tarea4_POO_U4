package modelo;


import org.junit.jupiter.api.Test;

import poo.modelo.ScannerContenidosAudovisuales;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ScannerContenidosAudovisualesTest {

    // Prueba el manejo de errores del archivo
    @Test
    void testCargarDatos_LanzaIOExceptionSiArchivoNoExiste() {
        ScannerContenidosAudovisuales lector = new ScannerContenidosAudovisuales();
        String archivoInexistente = "archivo_falso.csv";

        // Assert que se lanza IOException cuando el archivo no se encuentra
        assertThrows(IOException.class, () -> {
            lector.cargarDatos(archivoInexistente);
        }, "Debe lanzar IOException si el archivo no se encuentra.");
    }
}