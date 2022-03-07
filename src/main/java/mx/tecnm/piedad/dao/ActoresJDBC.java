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
        String sql = "INSERT INTO actores (id, nombre_completo) VALUES (?, ?)";
        conexion.update(sql, nuevo_actor.getId(), nuevo_actor.getNombreCompleto());
        sql = "SELECT LAST_INSERT_ID()";
        return conexion.queryForObject(sql, Integer.class);
	}
}


