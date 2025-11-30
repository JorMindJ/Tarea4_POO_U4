package poo.modelo;
import uni1a.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];
        contenidos[0] = new Pelicula("Avatar", null, 125, "Accion", "20th Century Studios", 0);
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy");
        contenidos[3] = new SocialReels("Viaje a Japon", 3, "Exploracion", 10000);
        contenidos[4] = new Publicidad("Nestle", 7, "Comparativa", "Endulza tu dia y la vida");

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
        String archivoDestino = "estado_del_sistema.csv";
        BufferedWriterContenidosVisuales.guardarContenidosEnCSV(contenidos, archivoDestino);
    }

}