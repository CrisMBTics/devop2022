package mx.tecnm.piedad.models;

public class Actores {
	
	public int getId() {
		return id;
		
	}
	
	public String getNombreCompleto() {
		return nombre_completo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombreCompleto(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	
	
	
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}



	private int id;
	private String nombre_completo;
	private int activo;
}
