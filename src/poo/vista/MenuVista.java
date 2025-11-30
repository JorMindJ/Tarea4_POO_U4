package poo.vista;

import poo.modelo.ContenidoAudiovisual;
import java.util.List;
import java.util.Scanner;

/**
 * MenuVista: Se encarga de la interfaz de usuario (mostrar menú, capturar entrada).
 */
public class MenuVista {

    private Scanner scanner;

    public MenuVista() {
        this.scanner = new Scanner(System.in);
    }
    
    /** Muestra las opciones principales y pide la selección del usuario. */
    public int mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Gestión de Contenidos Audiovisuales ---");
        System.out.println("1. Mostrar todos los contenidos");
        System.out.println("2. Buscar contenido por ID");
        System.out.println("3. Agregar nuevo contenido (Simplificado)");
        System.out.println("0. Salir y Guardar");
        System.out.print("Seleccione una opción: ");
        
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el buffer de entrada
            return -1; // Opción inválida
        }
    }
    
    /** Muestra el ID que el usuario desea buscar. */
    public int pedirId() {
        System.out.print("Ingrese el ID del contenido a buscar: ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Error: Ingrese un número válido.");
            return -1;
        }
    }

    /** Muestra los detalles de una lista de contenidos. */
    public void mostrarLista(List<ContenidoAudiovisual> lista) {
        if (lista.isEmpty()) {
            System.out.println("\n--- No hay contenidos para mostrar. ---");
            return;
        }
        System.out.println("\n--- Lista de Contenidos ---");
        for (ContenidoAudiovisual contenido : lista) {
            contenido.mostrarDetalles(); // Usa el método polimórfico de cada clase
        }
    }
    
    /** Muestra un único detalle (usado para buscar por ID). */
    public void mostrarDetalle(ContenidoAudiovisual contenido) {
        if (contenido != null) {
            System.out.println("\n--- Contenido Encontrado ---");
            contenido.mostrarDetalles();
        } else {
            System.out.println("\n--- Contenido no encontrado. ---");
        }
    }

    /** Muestra mensajes al usuario. */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}