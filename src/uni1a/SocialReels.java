/**
 * Class SocialReels
 */
package uni1a;

import java.util.ArrayList;

//Subclase SocialReels que extiende de ContenidoAudiovisual
public class SocialReels extends ContenidoAudiovisual{
     private String nombredelreels;
     private int numerodereacciones;
     private String descripciondelreels;
     private ArrayList<Usuario> listadeUsuario;
     
     
     public SocialReels(String titulo, int duracionEnMinutos, String genero, int numerodereacciones) {
         super(titulo, genero, duracionEnMinutos);
    	 this.Nombredelreels();
    	 this.numerodereacciones = numerodereacciones;
    	 this.listadeUsuario = new ArrayList<>();
     }





		private void Nombredelreels() {
		// TODO Auto-generated method stub
		
	}



		@Override
	    public void mostrarDetalles() {
	        System.out.println("Detalles del SocialReels:");
	        System.out.println("ID: " + getId());
	        System.out.println("Título: " + getTitulo());
	        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
	        System.out.println("Género: " + getGenero());
	        System.out.println("Numerodereacciones: " + this.numerodereacciones);
	        System.out.println();
	    }




		public String getNombredelreels() {
			return nombredelreels;
		}




		public void setNombredelreels(String nombredelreels) {
			this.nombredelreels = nombredelreels;
		}




		public ArrayList<Usuario> getListadeUsuario() {
			return listadeUsuario;
		}


		public void setListadeUsuario(ArrayList<Usuario> listadeUsuario) {
			this.listadeUsuario = listadeUsuario;
		}





		public String getDescripciondelreels() {
			return descripciondelreels;
		}





		public void setDescripciondelreels(String descripciondelreels) {
			this.descripciondelreels = descripciondelreels;
		}
}