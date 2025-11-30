package poo.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Importamos la clase base del paquete uni1a
import uni1a.ContenidoAudiovisual; 

/**
 * Clase encargada de la persistencia de los objetos ContenidoAudiovisual 
 * escribiendo sus datos en un archivo CSV.
 */
public class BufferedWriterContenidosVisuales {
	
    /**
     * Escribe la lista de contenidos audiovisuales en un archivo CSV.
     * Utiliza el método toCsvString() de cada objeto para obtener la línea de datos.
     * * @param listaContenidos La lista de objetos ContenidoAudiovisual a guardar.
     * @param nombreArchivo El nombre del archivo CSV de destino.
     */
	public static void guardarContenidosEnCSV(List<ContenidoAudiovisual> listaContenidos, String nombreArchivo) {
		String archivoDestino = nombreArchivo;
		
		// 1. Uso de try-with-resources para garantizar el cierre automático del recurso FileWriter y BufferedWriter
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoDestino))){
			
		// 2. Escribir el encabezado del CSV (usando ';' como delimitador)
			writer.write("DetallesdelosContenidosAudioVisuales;Id;Titulo;DuracionEnMinutos;Genero;Atributodelaclase;Subclases");
			writer.newLine();

		// 3. Iterar sobre la lista de objetos y escribir cada uno
			for(ContenidoAudiovisual contenido: listaContenidos) {
				
				// Llamada polimórfica al método implementado por cada subclase (Pelicula, SerieDeTV, Documental)
				String lineaCsv = contenido.toCsvString();
				
				writer.write(lineaCsv);
				writer.newLine(); // Añade un salto de línea después de cada registro
			}
			
			// 4. Mensaje de éxito
			System.out.println("\n✅ Persistencia exitosa. Datos escritos en '" + archivoDestino + "'.");

		} catch (IOException e) {
			// 5. Manejo de errores de escritura/archivo
			System.err.println("\n❌ ERROR al escribir el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}