package modelo;


import org.junit.jupiter.api.Test;

import poo.modelo.Documental;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentalTest {

    private final String TITULO = "TestDoc";
    private final int DURACION = 90;
    private final String TEMA = "Paleontología";
    private final String DIRECTOR = "Dr. Alan Grant";
    private final int ID = 50;

    @Test
    void testDocumentalConstructorYGetters() {
        // Arrange
        Documental doc = new Documental(TITULO, "Ciencia", DURACION, TEMA, DIRECTOR, ID);

        // Assert
        assertEquals(ID, doc.getId(), "El ID debe coincidir.");
        assertEquals(TITULO, doc.getTitulo(), "El título debe coincidir.");
        assertEquals(DURACION, doc.getDuracionEnMinutos(), "La duración debe coincidir.");
        
        // Assert de atributos específicos del Documental
        // NOTA: Asumimos que TEMA se guarda en getAtributodelaclase() y DIRECTOR en getSubclases()
        assertEquals(TEMA, doc.getAtributodelaclase(), "El tema (Atributo de la clase) debe coincidir.");
        assertEquals(DIRECTOR, doc.getSubclases(), "El director (Subclases) debe coincidir.");
    }

    @Test
    void testToCsvString() {
        
        Documental doc = new Documental(TITULO, "Ciencia", DURACION, TEMA, DIRECTOR, ID);
        
        // Act
        String expectedCsv = "Detalles del Documental;" + ID + ";" + TITULO + ";" + DURACION + ";" + "Ciencia" + ";" + TEMA + ";" + DIRECTOR;
        
        // Assert
        assertEquals(expectedCsv, doc.toCsvString(), 
                     "El formato CSV debe usar ';' como delimitador e incluir todos los campos.");
    }
}