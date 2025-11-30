package poo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * GestorContenidos: Contiene la lista de ContenidosAudiovisuales y la lógica de negocio (Modelo).
 * Interactúa con las clases de Persistencia (Scanner/BufferedWriter).
 */
public class GestorContenidos {

    private List<ContenidoAudiovisual> listaContenidos;
    private ScannerContenidosAudovisuales lector;
    private BufferedWriterContenidosVisuales escritor;
    private final String ARCHIVO_DATOS = "estado_del_sistema.csv";
    private final String ARCHIVO_GUARDADO = "estado_actualizado.csv";

    public GestorContenidos() {
        this.listaContenidos = new ArrayList<>();
        this.lector = new ScannerContenidosAudovisuales();
        this.escritor = new BufferedWriterContenidosVisuales();
        cargarInicial();
    }
    
    // --- Métodos de Persistencia (Llamados por el Gestor) ---

    /** Carga inicial de datos desde el archivo CSV. */
    private void cargarInicial() {
        try {
            this.listaContenidos = lector.cargarDatos(ARCHIVO_DATOS);
            System.out.println("Carga inicial de datos finalizada.");
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de datos inicial: " + e.getMessage());
            // Inicializa la lista vacía si falla la carga
            this.listaContenidos = new ArrayList<>(); 
        }
    }

    /** Guarda todos los datos en un archivo CSV. */
    public void guardarDatos() {
        escritor.guardarContenidosEnCSV(this.listaContenidos, ARCHIVO_GUARDADO);
    }

    // --- Métodos de Lógica de Negocio (Llamados por el Controlador) ---
    
    /** Devuelve la lista completa de contenidos (para ser mostrada por la Vista). */
    public List<ContenidoAudiovisual> getListaCompleta() {
        return listaContenidos;
    }

    /** Busca un contenido por su ID. */
    public ContenidoAudiovisual buscarPorId(int id) {
        for (ContenidoAudiovisual contenido : listaContenidos) {
            if (contenido.getId() == id) {
                return contenido;
            }
        }
        return null;
    }

    /** Agrega un nuevo contenido a la lista. */
    public void agregarContenido(ContenidoAudiovisual nuevoContenido) {
        // Lógica de negocio: asignar un nuevo ID si es necesario
        // newId = ContenidoAudiovisual.asignarNuevoId(); 
        // nuevoContenido.setId(newId);
        this.listaContenidos.add(nuevoContenido);
    }
    
    // ... otros métodos de negocio (filtrar, eliminar, etc.)
}