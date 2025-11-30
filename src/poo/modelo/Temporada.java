/**
 * Class Temporada
 */
package poo.modelo;

public class Temporada {
private int numero;
private int episodios;

public Temporada(int numero, int episodios) {
	this.setNumero(numero);
	this.setEpisodios(episodios);

}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public int getEpisodios() {
	return episodios;
}

public void setEpisodios(int episodios) {
	this.episodios = episodios;
}

}
