package poo.modelo;

public abstract class ContenidoAudiovisual {
    private static int contar = 0;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;
    private int id;
    
    public abstract String toCsvString();
    public abstract void mostrarDetalles();
    
    // 🚨 Constructor Ajustado para recibir el ID del CSV (6to parámetro)
    public ContenidoAudiovisual(String titulo, String genero, int duracionEnMinutos, int idExistente) {
        this.id = idExistente;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
        
        // Aseguramos que el contador global sea mayor que el ID cargado
        if (idExistente >= contar) {
            contar = idExistente + 1;
        }
    }

    // --- Getters y Setters (Necesarios) ---

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDuracionEnMinutos() { return duracionEnMinutos; }
    public void setDuracionEnMinutos(int duracionEnMinutos) { this.duracionEnMinutos = duracionEnMinutos; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}