package mx.tecnm.piedad.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Actores;


@Repository
public class ActoresJDBC {
	
	@Autowired
	private JdbcTemplate conexion;
	
	
	public int insert (Actores nuevo_actor) {
        String sql = "INSERT INTO actores (nombre_completo) VALUES (?)";
        conexion.update(sql, nuevo_actor.getNombre_completo());
        sql = "SELECT LAST_INSERT_ID()";
        return conexion.queryForObject(sql, Integer.class);
	}
	
	public void modifi(int id, Actores actores) {
		String sql = "UPDATE actores SET nombre_completo = ?, modificado=NOW()  WHERE id = ?";
		conexion.update(sql, actores.getNombre_completo(), id);
	}
	
	
		public Actores consultar (int id) {
        String sql="SELECT * FROM actores WHERE id= ? AND activo=1";
        return conexion.queryForObject(sql, new ActoresRM(), id);

    }

	public void desactivar(int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE actores SET activo = 0, eliminado = NOW() WHERE id = ?";
        conexion.update(sql, id);
		
	}
	
	
}


