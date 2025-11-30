package poo.modelo;

import java.util.ArrayList;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private String director; // 👈 Campo para la Columna 7 del CSV (Steven Soter)
    private ArrayList<Investigador> investigadores; // Composición con Investigador
    
    // 🚨 Constructor Ajustado: 6 parámetros (incluyendo tema, director y idExistente)
    public Documental(String titulo, String genero, int duracionEnMinutos, 
                      String tema, String director, int idExistente) {
        
        // Llama al constructor del padre con 4 campos
        super(titulo, genero, duracionEnMinutos, idExistente);
        this.tema = tema;
        this.director = director;
        this.investigadores = new ArrayList<>();
        
        // Opcional: Si tienes la clase Investigador, puedes instanciarlo aquí:
        // this.investigadores.add(new Investigador(director));
    }

    @Override
    public String toCsvString() {
        return "Detalles del Documental" + ";"  + this.getId() + ";"  + this.getTitulo() + ";" + this.getDuracionEnMinutos() + ";" + this.getGenero() + ";"  + this.tema + ";" + this.director;
    }


	public void agregarInvestigador(Investigador investigador) {
    	investigadores.add(investigador);
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("🔬 Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.println("Director/Investigador: " + this.director);
        System.out.println();
    }
    
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

	public Object getAtributodelaclase() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSubclases() {
		// TODO Auto-generated method stub
		return null;
	}
}