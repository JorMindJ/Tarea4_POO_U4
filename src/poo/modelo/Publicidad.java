/**
 * Class Publicidad
 */
package poo.modelo;

import java.util.ArrayList;

//Subclase Publicidad que extiende de ContenidoAudiovisual
public class Publicidad extends ContenidoAudiovisual {
 private String nombredelproducto;
 private String eslogan;
 private ArrayList<Producto> producto;
 
 public Publicidad(String titulo, int duracionEnMinutos, String genero, String eslogan) {
     super(titulo, genero, duracionEnMinutos, duracionEnMinutos);
	    this.setnombredelproducto(nombredelproducto);
	    this.eslogan = eslogan;
	    this.producto = new ArrayList<>();
 }
 
 @Override
 public String toCsvString() {
	 return "Detalles de la Publicidad" + ","  + this.getId() + ","  + this.getTitulo() + "," + this.getDuracionEnMinutos() + "," + this.getGenero() + ","  + this.eslogan;
 }


 private void setnombredelproducto(String nombredelproducto2) {
	// TODO Auto-generated method stub
	
}


 @Override
 public void mostrarDetalles() {
     System.out.println("Detalles de la Publicidad:");
     System.out.println("ID: " + getId());
     System.out.println("Título: " + getTitulo());
     System.out.println("Duración en minutos: " + getDuracionEnMinutos());
     System.out.println("Género: " + getGenero());
     System.out.println("Eslogan: " + eslogan);
     System.out.println();
 }


 public String getNombredelproducto() {
	return nombredelproducto;
 }


 public void setNombredelproducto(String nombredelproducto) {
	this.nombredelproducto = nombredelproducto;
 }


 public String getEslogan() {
	return eslogan;
 }


 public void setEslogan(String eslogan) {
	this.eslogan = eslogan;
 }


 public ArrayList<Producto> getProducto() {
	return producto;
 }


 public void setProducto(ArrayList<Producto> producto) {
	this.producto = producto;
 }
}
