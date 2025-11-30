package modelo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Asegúrate de que Pelicula esté en poo.modelo para que este import funcione
import poo.modelo.Pelicula; 

public class PeliculaTest {

    // Variables de prueba que representan los atributos específicos de una Película
    private final String TITULO = "TestMovie";
    private final String GENERO = "Accion";
    private final int DURACION = 150;
    private final String ESTUDIO = "Marvel"; // Corresponde a 'Atributodelaclase'
    private final String ACTOR = "Robert Downey Jr."; // Corresponde a 'Subclases'
    private final int ID = 51;

    @Test
    void testPeliculaConstructorYGetters() {
        // Arrange: Se inicializa Pelicula con 6 parámetros, incluyendo los específicos (Estudio y Actor)
        // Constructor de ejemplo: new Pelicula(Título, Género, Duración, Estudio, Actor, ID)
        Pelicula peli = new Pelicula(TITULO, GENERO, DURACION, ESTUDIO, ACTOR, ID);

        // Assert 1: Atributos generales
        assertEquals(ID, peli.getId(), "El ID debe coincidir.");
        assertEquals(TITULO, peli.getTitulo(), "El título debe coincidir.");
        
        // Assert 2: Atributos específicos mapeados a los getters polimórficos
        
        // Verifica que el Estudio ("Marvel") se guardó en el campo 'Atributodelaclase'
        assertEquals(ESTUDIO, peli.getAtributodelaclase(), "El estudio debe coincidir con getAtributodelaclase().");
        
        // Verifica que el Actor ("Robert Downey Jr.") se guardó en el campo 'Subclases'
        assertEquals(ACTOR, peli.getSubclases(), "El actor debe coincidir con getSubclases().");
    }

    @Test
    void testToCsvString() {
        // Arrange
        Pelicula peli = new Pelicula(TITULO, GENERO, DURACION, ESTUDIO, ACTOR, ID);
        
        // Act: Se genera la cadena CSV que se usaría para guardar el objeto
        // Formato esperado: Tipo;ID;Titulo;Duracion;Genero;AtributoClase;Subclases
        String expectedCsv = "Detalles de la Pelicula;" + ID + ";" + TITULO + ";" + DURACION + ";" + GENERO + ";" + ESTUDIO + ";" + ACTOR;
        
        // Assert: Verifica que el formato de salida sea el correcto
        assertEquals(expectedCsv, peli.toCsvString(), 
                     "El formato CSV debe usar ';' como delimitador e incluir todos los campos en orden.");
    }
}