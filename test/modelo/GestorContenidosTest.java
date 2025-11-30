package modelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poo.modelo.ContenidoAudiovisual;
import poo.modelo.GestorContenidos;
import poo.modelo.Pelicula;
import poo.modelo.Documental; // Import añadido para resolver el error
import poo.modelo.SerieDeTV; // Import añadido para resolver el error

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorContenidosTest {

    private GestorContenidos gestor;
    private Pelicula peliculaNueva;

    @BeforeEach
    void setUp() {
        // Inicializa el Gestor, lo que automáticamente llama a cargarInicial() 
        // y lee los 3 contenidos del CSV.
        gestor = new GestorContenidos(); 

        // Crear objeto de prueba con ID que no colisiona con el CSV (0, 1, 2)
        peliculaNueva = new Pelicula("Nova Movie", "Sci-Fi", 120, "Estudio Test", "Actor Test", 100);
    }

    // --- PRUEBAS BASADAS EN DATOS DEL CSV ---

    @Test
    void testCargaInicial_DebeTenerTresElementos() {
        assertEquals(3, gestor.getListaCompleta().size(), 
                     "La carga inicial debe contener 3 elementos.");
    }
    
    @Test
    void testBuscarPorId_PeliculaAvatar_VerificarAtributos() {
        // ID 0
        ContenidoAudiovisual encontrado = gestor.buscarPorId(0);
        
        assertNotNull(encontrado, "El contenido con ID 0 no debe ser null.");
        assertTrue(encontrado instanceof Pelicula, "El objeto debe ser una Pelicula.");

        Pelicula peli = (Pelicula) encontrado;
        // Verifica el 'Atributo de la clase' del CSV: "20th Century Studios"
        assertEquals("20th Century Studios", peli.getAtributodelaclase(), 
                     "El estudio debe ser '20th Century Studios'."); 
        // Verifica el 'Subclases' del CSV: "Sam Worthington"
        assertEquals("Sam Worthington", peli.getSubclases(), 
                     "El actor debe ser 'Sam Worthington'."); 
    }
    
    @Test
    void testBuscarPorId_SerieGoT_VerificarNumericos() {
        // ID 1
        ContenidoAudiovisual encontrado = gestor.buscarPorId(1);
        
        assertTrue(encontrado instanceof SerieDeTV, "El objeto debe ser una SerieDeTV.");
        
        SerieDeTV serie = (SerieDeTV) encontrado;
        // Verifica el 'Atributo de la clase' del CSV: "8" (Temporadas)
        assertEquals(8, serie.getTemporadas(), "La serie debe tener 8 temporadas.");
        // Verifica el 'Subclases' del CSV: "73" (Episodios)
        assertEquals(73, serie.getNumEpisodios(), "La serie debe tener 73 episodios.");
    }

    @Test
    void testBuscarPorId_DocumentalCosmos_VerificarDuracion() {
        // ID 2
        ContenidoAudiovisual encontrado = gestor.buscarPorId(2);
        
        assertTrue(encontrado instanceof Documental, "El objeto debe ser un Documental.");
        // Verifica la Duración del CSV: 45
        assertEquals(45, encontrado.getDuracionEnMinutos(), "La duración debe ser 45 minutos.");
    }

    // --- PRUEBAS DE MANIPULACIÓN DE LISTA ---
    
    @Test
    void testAgregarContenido_DebeAumentarElTamanioDeLaLista() {
        int tamanioInicial = gestor.getListaCompleta().size(); 
        
        gestor.agregarContenido(peliculaNueva);
        
        assertEquals(tamanioInicial + 1, gestor.getListaCompleta().size(), 
                     "El tamaño debe aumentar en 1 después de agregar.");
        
        // Verifica que el nuevo objeto se pueda buscar
        assertNotNull(gestor.buscarPorId(100), "El nuevo objeto con ID 100 debe ser encontrado.");
    }
    
    @Test
    void testBuscarPorId_NoEncontrado() {
        assertNull(gestor.buscarPorId(9999), "La búsqueda de un ID inexistente debe devolver null.");
    }
}