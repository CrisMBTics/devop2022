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

import mx.tecnm.piedad.dao.GenerosJDBC;
import mx.tecnm.piedad.models.Generos;

@RestController
@RequestMapping("api/generos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class GenerosWs {

	@Autowired
	GenerosJDBC repo;
	
	@PostMapping()
	public ResponseEntity<?> insert(@RequestBody Generos nuevo_genero){
		try {
			repo.insert(nuevo_genero);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modifi(@PathVariable int id, @RequestBody Generos generos){
		repo.modifi(id, generos);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consulta(@PathVariable int id){
		try {
			Generos resultado=repo.consultar(id);
			return new ResponseEntity<Generos>(resultado,HttpStatus.OK);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> desactivar(@PathVariable int id){
		repo.desactivar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
