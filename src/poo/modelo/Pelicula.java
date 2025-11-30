package poo.modelo;

import java.util.ArrayList;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    // Usamos 'actorPrincipal' para almacenar el String del CSV (Columna 7)
    private String actorPrincipal; 
    private ArrayList<Actor> actores; // Asociación con Actor
    
    // 🚨 Constructor Ajustado: 6 parámetros (incluyendo estudio, actorPrincipal y idExistente)
    public Pelicula(String titulo, String genero, int duracionEnMinutos, 
                    String estudio, String actorPrincipal, int idExistente) {
        
        // Llama al constructor del padre con 4 campos
        super(titulo, genero, duracionEnMinutos, idExistente); 
        this.estudio = estudio;
        this.actorPrincipal = actorPrincipal; // Guardamos el String del CSV
        this.actores = new ArrayList<>(); 
        
        // Opcional: Si tienes la clase Actor, puedes instanciarlo aquí:
        // this.actores.add(new Actor(actorPrincipal));
    }

    @Override
    public String toCsvString() {
        // Usar punto y coma (;) para que coincida con el CSV
        return "Detalles de la Pelicula" + ";" + getId() + ";" + getTitulo() + ";" + getDuracionEnMinutos() + ";" + getGenero() + ";" + estudio + ";" + actorPrincipal;
    }
    
    public void agregarActor(Actor actor) {
    	this.actores.add(actor);
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("🎬 Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        System.out.println("Actor Principal (CSV): " + actorPrincipal);
        System.out.println();
        
    }

    public String getEstudio() { return estudio; }
    public void setEstudio(String estudio) { this.estudio = estudio; }

    public String getActorPrincipal() { return actorPrincipal; }
    public void setActorPrincipal(String actorPrincipal) { this.actorPrincipal = actorPrincipal; }

    public ArrayList<Actor> getActores() { return actores; }
    public void setActores(ArrayList<Actor> actores) { this.actores = actores; }

	public Object getAtributodelaclase() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSubclases() {
		// TODO Auto-generated method stub
		return null;
	}
}