package poo.controlador;

import poo.modelo.GestorContenidos;
import poo.vista.MenuVista;
import poo.modelo.ContenidoAudiovisual;
import java.util.List;

/**
 * ContenidoController: Punto de entrada (main) y coordinador entre la Vista y el Modelo.
 */
public class ContenidoController {
    
    private GestorContenidos gestor;
    private MenuVista vista;

    public ContenidoController() {
        // Inicializa el Modelo, que a su vez carga los datos del CSV
        this.gestor = new GestorContenidos(); 
        this.vista = new MenuVista();
    }

    /** Inicia el bucle principal de la aplicación. */
    public void iniciarAplicacion() {
        int opcion = -1;
        boolean salir = false;

        while (!salir) {
            opcion = vista.mostrarMenuPrincipal();
            salir = manejarOpcion(opcion);
        }
        
        // Ejecuta la lógica final (guardar) antes de salir
        gestor.guardarDatos();
        vista.mostrarMensaje("Aplicación finalizada. Datos guardados.");
    }
    
    /** Maneja la opción seleccionada por el usuario. */
    private boolean manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                // Pide los datos al Modelo y se los pasa a la Vista para mostrar
                List<ContenidoAudiovisual> lista = gestor.getListaCompleta();
                vista.mostrarLista(lista);
                break;
            case 2:
                // Búsqueda
                int idBusqueda = vista.pedirId();
                if (idBusqueda != -1) {
                    ContenidoAudiovisual encontrado = gestor.buscarPorId(idBusqueda);
                    vista.mostrarDetalle(encontrado);
                }
                break;
            case 3:
                // Simplificado: Solo un mensaje
                vista.mostrarMensaje("Funcionalidad 'Agregar Contenido' no implementada completamente.");
                // Si estuviera completo, aquí llamarías a vista.pedirDatosNuevoContenido()
                // Y luego a gestor.agregarContenido(nuevoObjeto)
                break;
            case 0:
                return true; // Salir del bucle
            default:
                vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
                break;
        }
        return false; // Continuar en el bucle
    }

    /** * Método principal (Punto de entrada).
     * Inicia la arquitectura MVC.
     */
    public static void main(String[] args) {
        ContenidoController controller = new ContenidoController();
        controller.iniciarAplicacion();
    }
}