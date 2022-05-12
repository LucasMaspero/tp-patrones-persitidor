package persistidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import persistidor.entidades.Sesion;
import persistidor.servicios.ServicioDeSesiones;

@RestController
public class MiRestController
{
	@Autowired
	private ServicioDeSesiones servicioDeSesiones;

   @GetMapping("sesion/{id}")
	public ResponseEntity<Sesion> getSesionById(@PathVariable("id") Integer id) {
		Sesion sesion = servicioDeSesiones.obtenerSesionPorId(id);
		return new ResponseEntity<Sesion>(sesion, HttpStatus.OK);
	}
}
