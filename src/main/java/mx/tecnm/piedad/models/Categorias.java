package mx.tecnm.piedad.models;

public class Categorias {
	
	private int id;
	private String clasificacion;
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setClasificacion( String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

}
