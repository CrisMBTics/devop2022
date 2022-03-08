package mx.tecnm.piedad.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.ActoresJDBC;
import mx.tecnm.piedad.models.Actores;


@RestController
@RequestMapping("api/actores")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class ActoresWs {
	
	@Autowired
	ActoresJDBC repo;
	
	@PostMapping()
    public ResponseEntity<?> insert(@RequestBody Actores nuevo_actor){
    	try {
    	return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (DataAccessException e) {
    	System.out.println(e.getMessage());
    	return new ResponseEntity<>(HttpStatus.CONFLICT);
    	
    	}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modifi (@PathVariable int id, @RequestBody Actores actores){
		repo.modifi(id, actores);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultar(@PathVariable int id){
		try {
			Actores resultado = repo.Consultar(id);
			return new ResponseEntity<Actores>(resultado, HttpStatus.OK);				
			} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> desactivar (@PathVariable int id){
			repo.desactivar(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
