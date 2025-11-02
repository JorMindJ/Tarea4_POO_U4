package uni1a;

public class Usuario {
  private String nombredeperfil;
  private int numerodeseguidores;

  public Usuario(String nombredeperfil, int numerodeseguidores){
	  this.setNombredeperfil(nombredeperfil);
	  this.setNumerodeseguidores(numerodeseguidores);
	  
  }

  public String getNombredeperfil() {
	return nombredeperfil;
  }

  public void setNombredeperfil(String nombredeperfil) {
	this.nombredeperfil = nombredeperfil;
  }

  public int getNumerodeseguidores() {
	return numerodeseguidores;
  }

  public void setNumerodeseguidores(int numerodeseguidores) {
	this.numerodeseguidores = numerodeseguidores;
  }


}
