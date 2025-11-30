package poo.modelo;

import java.util.ArrayList;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private int episodiosTotales; // 👈 Campo para la Columna 7 del CSV
    private ArrayList<Temporada> listaTemporadas; // Agregación con Temporada
    
    // 🚨 Constructor Ajustado: 6 parámetros (incluyendo temporadas, episodiosTotales y idExistente)
    public SerieDeTV(String titulo, String genero, int duracionEnMinutos, 
                     int temporadas, int episodiosTotales, int idExistente) {
        
        // Llama al constructor del padre con 4 campos
        super(titulo, genero, duracionEnMinutos, idExistente);
        this.temporadas = temporadas;
        this.episodiosTotales = episodiosTotales;
        this.listaTemporadas = new ArrayList<>();
    }


 // En Pelicula.java:
    @Override
    public String toCsvString() {
        // Usar punto y coma (;) para que coincida con el CSV
        return "Detalles de la Pelicula" + ";" + getId() + ";" + getTitulo() + ";" + getDuracionEnMinutos() + ";" + getGenero() + ";" + temporadas + ";" + episodiosTotales;
    }
   
    

	public void agregarTemporada(Temporada temporada) {
    	listaTemporadas.add(temporada);
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("📺 Detalles de la SerieDeTV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración/Episodio: " + getDuracionEnMinutos() + " min");
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println("Episodios Totales: " + this.episodiosTotales);
        System.out.println();
    }
    
    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    public int getEpisodiosTotales() { return episodiosTotales; }
    public void setEpisodiosTotales(int episodiosTotales) { this.episodiosTotales = episodiosTotales; }


	public Integer getNumEpisodios() {
		// TODO Auto-generated method stub
		return null;
	}
}