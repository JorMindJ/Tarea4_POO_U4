/**
 * Class Actor
 */
package poo.modelo;

public class Actor {
   private String nombre;
 
   public Actor(String nombre) {
		this.setNombre(nombre);
		
	}

   public String getNombre() {
	return nombre;
   }

   public void setNombre(String nombre) {
	this.nombre = nombre;
   }
}
