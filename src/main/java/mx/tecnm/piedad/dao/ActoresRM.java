package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.piedad.models.Actores;


public class ActoresRM implements RowMapper<Actores> {
	
	
	public Actores mapRow(ResultSet rs, int rowNum)throws SQLException {
		Actores actores = new Actores ();
		actores.setId(rs.getInt("id"));
		actores.setNombreCompleto(rs.getString("nombre_completo"));
		return actores;
		
	}

}
