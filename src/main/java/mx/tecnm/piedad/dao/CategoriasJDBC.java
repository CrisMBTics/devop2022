package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Categorias;

@Repository
public class CategoriasJDBC {

	@Autowired
	private JdbcTemplate conexion;
	
	public int insert(Categorias nueva_categoria) {
		String sql="insert into categorias (clasificacion, descripcion) values (?,?)";
		conexion.update(sql, nueva_categoria.getClasificacion(), nueva_categoria.getDescripcion());
		sql="select last_insert_id()";
		return conexion.queryForObject(sql, Integer.class);
		
	}
	
	public void modifi(int id, Categorias categorias) {
<<<<<<< HEAD
		String sql="update categorias set clasificacion=?, descripcion=?, modificado =NOW() where id=?";
=======
		String sql="update categorias set clasificacion=?, descripcion=? modificado = NOW() where id=?";
>>>>>>> dae746781f39540de2eadacfee03dc993e4ec012
		conexion.update(sql, categorias.getClasificacion(), categorias.getDescripcion(), id);
	}
	
	 public Categorias consulta(int id) {
<<<<<<< HEAD
		 String sql="select * from categorias where id=? AND activo=1";
=======
		 String sql="select * from categorias consultado=NOW() where id=?";
>>>>>>> dae746781f39540de2eadacfee03dc993e4ec012
		 return conexion.queryForObject(sql, new CategoriasRM(), id);
	 }
	 
	 public void desactivar(int id) {
		 String sql="UPDATE categorias set activo=0, eliminado=NOW() where id=?";
		 conexion.update(sql, id);
	 }
	
}
