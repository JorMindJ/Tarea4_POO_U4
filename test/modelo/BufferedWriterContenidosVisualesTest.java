package modelo;


import org.junit.jupiter.api.Test;

import poo.modelo.BufferedWriterContenidosVisuales;
import poo.modelo.ContenidoAudiovisual;
import poo.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BufferedWriterContenidosVisualesTest {

    @Test
    void testGuardarContenidosEnCSV_DebeEjecutarseSinExcepciones() {
        List<ContenidoAudiovisual> listaPrueba = new ArrayList<>();
        
        // Simular algunos datos (se necesitan constructores válidos)
        Pelicula peli = new Pelicula("PeliTemp", "Drama", 90, "EstudioX", "ActorY", 999);
        listaPrueba.add(peli);
        
        String archivoTemporal = "test_escritura_temporal.csv";

        // Act & Assert
        // Verifica que el método se ejecute sin lanzar ninguna excepción (como IOException)
        assertDoesNotThrow(() -> BufferedWriterContenidosVisuales.guardarContenidosEnCSV(listaPrueba, archivoTemporal),
                           "El método de guardado no debe lanzar excepciones de IO.");
    }
}