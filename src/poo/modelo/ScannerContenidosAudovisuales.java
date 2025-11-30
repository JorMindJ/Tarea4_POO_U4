package poo.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Clase de Persistencia que lee el CSV y construye los objetos
public class ScannerContenidosAudovisuales {

    /**
     * Lee el archivo CSV y construye una lista de objetos ContenidoAudiovisual.
     * @param archivoOrigen El nombre del archivo CSV a leer.
     * @return Una lista de objetos ContenidoAudiovisual cargados.
     * @throws IOException Si el archivo no se encuentra o hay un error de lectura/escritura.
     */
    public List<ContenidoAudiovisual> cargarDatos(String archivoOrigen) throws IOException {
        
        // 🚨 La lista local que será devuelta.
        List<ContenidoAudiovisual> listaContenidos = new ArrayList<>();
        
        // El bloque try-with-resources y la lógica de lectura
        try (Scanner scanner = new Scanner(new File(archivoOrigen))) {
            
            scanner.useDelimiter(";"); 
            
            // Ignorar encabezado 
            if (scanner.hasNextLine()) {
                scanner.nextLine(); 
            }
            
            while (scanner.hasNextLine()) {
                
                String linea = scanner.nextLine();
                if (linea.trim().isEmpty()) continue;
                
                // Usamos el punto y coma (;) como delimitador para el split
                String[] campos = linea.split(";"); 
                
                if (campos.length < 7) {
                    System.err.println("ADVERTENCIA: Fila con formato incorrecto. Ignorando: " + linea);
                    continue;
                }
            
                // 1. Asignar todos los campos como Strings
                String DetallesdelosContenidosAudioVisuales = campos[0].trim();
                String idString = campos[1].trim(); 
                String Titulo = campos[2].trim();
                String duracionString = campos[3].trim(); 
                String Genero = campos[4].trim();
                String Atributodelaclase = campos[5].trim(); 
                String Subclases  = campos[6].trim();

                ContenidoAudiovisual nuevoContenido = null;
                
                try {
                    // 2. Parsear los campos numéricos
                    int Id = Integer.parseInt(idString); 
                    int DuracionEnMinutos = Integer.parseInt(duracionString); 
        
                    // 3. Lógica para determinar qué objeto instanciar
                    if (DetallesdelosContenidosAudioVisuales.contains("Pelicula")) {
                        nuevoContenido = new Pelicula(Titulo, Genero, DuracionEnMinutos, Atributodelaclase, Subclases, Id);
                    
                    } else if (DetallesdelosContenidosAudioVisuales.contains("SerieDeTV")) {
                        int numTemporadas = Integer.parseInt(Atributodelaclase);
                        int numEpisodios = Integer.parseInt(Subclases);
                        nuevoContenido = new SerieDeTV(Titulo, Genero, DuracionEnMinutos, numTemporadas, numEpisodios, Id);
                    
                    } else if (DetallesdelosContenidosAudioVisuales.contains("Documental")) {
                        nuevoContenido = new Documental(Titulo, Genero, DuracionEnMinutos, Atributodelaclase, Subclases, Id);
                    }
        
                    // 4. Añadir el objeto a la lista
                    if (nuevoContenido != null) {
                        listaContenidos.add(nuevoContenido);
                    }
                
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato numérico en la línea: " + linea + " | Causa: " + e.getMessage());
                }
            } // Fin del while (Lectura)
            
            System.out.println("✅ Lectura de " + archivoOrigen + " completada. Objetos cargados: " + listaContenidos.size());
            
        } catch (InputMismatchException e) {
            // Este catch es opcional si solo se usan String.split(), pero es bueno mantenerlo
            throw new IOException("Error de tipo de dato inesperado en el CSV.", e);
        }
        
        // 🚨 Devuelve la lista al Gestor
        return listaContenidos;
    }
}