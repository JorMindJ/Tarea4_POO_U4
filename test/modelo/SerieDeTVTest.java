package modelo;


import org.junit.jupiter.api.Test;

import poo.modelo.SerieDeTV;

import static org.junit.jupiter.api.Assertions.*;

public class SerieDeTVTest {

    private final String TITULO = "TestSerie";
    private final int TEMPORADAS = 5;
    private final int EPISODIOS = 45;
    private final int ID = 52;

    @Test
    void testSerieDeTVConstructorYGetters() {
        // Arrange
        SerieDeTV serie = new SerieDeTV(TITULO, "Drama", 40, TEMPORADAS, EPISODIOS, ID);

        // Assert
        assertEquals(ID, serie.getId(), "El ID debe coincidir.");
        assertEquals(TITULO, serie.getTitulo(), "El título debe coincidir.");
        
        // Assert de atributos específicos de la SerieDeTV
        assertEquals(TEMPORADAS, serie.getTemporadas(), "El número de temporadas debe coincidir.");
        assertEquals(EPISODIOS, serie.getNumEpisodios(), "El número de episodios debe coincidir.");
    }

    @Test
    void testToCsvString() {
        // Arrange
        SerieDeTV serie = new SerieDeTV(TITULO, "Drama", 40, TEMPORADAS, EPISODIOS, ID);
        
        // Act
        // NOTA: Los atributos de la subclase (Temporadas y Episodios) se convierten a String
        String expectedCsv = "Detalles de la SerieDeTV;" + ID + ";" + TITULO + ";" + 40 + ";" + "Drama" + ";" + TEMPORADAS + ";" + EPISODIOS;
        
        // Assert
        assertEquals(expectedCsv, serie.toCsvString(), 
                     "El formato CSV debe usar ';' como delimitador e incluir todos los campos.");
    }
}