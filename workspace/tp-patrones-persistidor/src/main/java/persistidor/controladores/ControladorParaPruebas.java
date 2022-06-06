package persistidor.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import persistidor.api.PersistentObject;
import persistidor.entidades.Objeto;
import persistidor.entidades.Sesion;
import persistidor.excepciones.NoExisteSesionException;
import persistidor.servicios.ServicioDeSesiones;

@RestController
public class ControladorParaPruebas
{
	@Autowired
	private PersistentObject persistentObject;
	
	@Autowired
	private ServicioDeSesiones servicioDeSesiones;
	
	@GetMapping("store/{id}")
    public ResponseEntity<?> insert(@PathVariable("id") Integer sId)
    {
		Persona persona = new Persona();
		Direccion direccion = new Direccion();
		
		boolean exists = persistentObject.store(sId, persona);
		
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
    }
	
	@GetMapping("load/{id}")
    public ResponseEntity<Objeto> load(@PathVariable("id") Integer sId)
    {
		Sesion sesion = servicioDeSesiones.obtenerSesionPorId(sId);
		
		return new ResponseEntity<Objeto>(sesion.getObjetos().get(0), HttpStatus.OK);
    }
	
	@GetMapping("exists/{id}/{nombreDeClase}")
    public ResponseEntity<?> exists(@PathVariable("id") Integer sId, @PathVariable("nombreDeClase") String nombreDeClase)
    {
		try
		{
			Class<?> clase = Class.forName(nombreDeClase);
			
			boolean exists = persistentObject.exists(sId, clase);
			
			return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
		}
		catch(NoExisteSesionException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(ClassNotFoundException ex)
		{
			return new ResponseEntity<String>("No existe clase de nombre; " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@GetMapping("elapsedTime/{id}")
    public ResponseEntity<?> elapsedTime(@PathVariable("id") Integer sId)
    {
		try
		{
			long elapsedTime = persistentObject.elapsedTime(sId);
			
			return new ResponseEntity<Long>(elapsedTime, HttpStatus.OK);
		}
		catch(NoExisteSesionException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	private Persona CrearPersonaEjemplo()
	{
		
	}
}
