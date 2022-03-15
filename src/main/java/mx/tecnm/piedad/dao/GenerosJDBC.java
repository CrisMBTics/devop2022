package mx.tecnm.piedad.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Generos;


@Repository
public class GenerosJDBC {
	
	@Autowired
	private JdbcTemplate conexion;
	
	
	public int insert (Generos nuevo_genero) {
        String sql = "INSERT INTO generos (nombre) VALUES (?)";
        conexion.update(sql, nuevo_genero.getNombre());
        sql = "SELECT LAST_INSERT_ID()";
        return conexion.queryForObject(sql, Integer.class);
	}
	
	public void modifi(int id, Generos generos) {
		String sql = "UPDATE generos SET nombre = ?, modificado=NOW()  WHERE id = ?";
		conexion.update(sql, generos.getNombre(), id);
	}
	
	
		public Generos consultar (int id) {
        String sql="SELECT * FROM generos WHERE id=? AND activo=1";
        return conexion.queryForObject(sql, new GenerosRM(), id);

    }

	public void desactivar(int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE generos SET activo=0, eliminado=NOW() WHERE id = ?";
        conexion.update(sql, id);
		
	}
	
	
}