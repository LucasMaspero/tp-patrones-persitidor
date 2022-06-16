package persistidor.controladores;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import persistidor.api.IPersistentObject;
import persistidor.excepciones.NoExisteSesionException;
import persistidor.excepciones.StructureChangedException;
import persistidor.excepciones.TipoOValorInvalidoException;

@RestController
public class ControladorParaPruebas
{
	@Autowired
	private IPersistentObject persistentObject;
	
	@GetMapping("storePersona/{idSesion}")
    public ResponseEntity<?> storePersona(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearPersonaEjemplo());
    }
	
	@GetMapping("storePrimitivo/{idSesion}")
    public ResponseEntity<?> storePrimitivo(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, 2);
    }
	
	@GetMapping("storeNull/{idSesion}")
    public ResponseEntity<?> storeNull(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, null);
    }
	
	@GetMapping("storeCollecion/{idSesion}")
    public ResponseEntity<?> storeCollecion(@PathVariable("idSesion") Integer idSesion)
    {
		List<Integer> coleccion = new ArrayList<Integer>(); 
		return store(idSesion, coleccion);
    }
	
	private ResponseEntity<?> store(long idSesion, Object object)
    {
		try
		{
			boolean exists = persistentObject.store(idSesion, object);
			
			return new ResponseEntity<Boolean>(exists, HttpStatus.OK);	
		}
		catch (TipoOValorInvalidoException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@GetMapping("load/{idSesion}/{nombreDeClase}")
    public ResponseEntity<?> load(@PathVariable("idSesion") Integer idSesion, @PathVariable("nombreDeClase") String nombreDeClase)
    {
		try
		{
			Class<?> clase = Class.forName(nombreDeClase);
			
			Object object = persistentObject.load(idSesion, clase);
		
			return new ResponseEntity<Object>(object, HttpStatus.OK);
		}
		catch (NoExisteSesionException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (ClassNotFoundException ex)
		{
			return new ResponseEntity<String>("No existe clase de nombre; " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (StructureChangedException ex)
		{
			return new ResponseEntity<String>("ERROR: Cambio la estructura del objeto", HttpStatus.BAD_REQUEST);
		}
    }
	
	@GetMapping("exists/{idSesion}/{nombreDeClase}")
    public ResponseEntity<?> exists(@PathVariable("idSesion") Integer idSesion, @PathVariable("nombreDeClase") String nombreDeClase)
    {
		try
		{
			Class<?> clase = Class.forName(nombreDeClase);
			
			boolean exists = persistentObject.exists(idSesion, clase);
			
			return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
		}
		catch (NoExisteSesionException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (ClassNotFoundException ex)
		{
			return new ResponseEntity<String>("No existe clase de nombre; " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@GetMapping("elapsedTime/{idSesion}")
    public ResponseEntity<?> elapsedTime(@PathVariable("idSesion") Integer idSesion)
    {
		try
		{
			long elapsedTime = persistentObject.elapsedTime(idSesion);
			
			return new ResponseEntity<Long>(elapsedTime, HttpStatus.OK);
		}
		catch (NoExisteSesionException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@GetMapping("delete/{idSesion}/{nombreDeClase}")
    public ResponseEntity<?> delete(@PathVariable("idSesion") Integer idSesion, @PathVariable("nombreDeClase") String nombreDeClase)
    {
		try
		{
			Class<?> clase = Class.forName(nombreDeClase);
			
			Object object = persistentObject.delete(idSesion, clase);
			
			return new ResponseEntity<Object>(object, HttpStatus.OK);
		}
		catch (NoExisteSesionException ex)
		{
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (ClassNotFoundException ex)
		{
			return new ResponseEntity<String>("No existe clase de nombre; " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (StructureChangedException ex)
		{
			return new ResponseEntity<String>("ERROR: Cambio la estructura del objeto", HttpStatus.BAD_REQUEST);
		}
    }
	
	private Persona CrearPersonaEjemplo()
	{
		Direccion laMejorDireccion = new Direccion("Cuenca", 1235, "C1245DQW", "CABA", "CABA", "Argentina");
		Direccion direccion1 = new Direccion("Corrientes", 452, "B5514ABC", "Buenos Aires", "Buenos Aires", "Argentina");
		Direccion direccion2 = new Direccion("Pedro Moran", 2345, "ABC123", "Buzios", "Rio de Janeiro", "Brasil");
		
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("4444-2222");
		telefonos.add("5555-3333");
		telefonos.add("6666-4444");
		
		return new Persona("123", "Pepe", telefonos, laMejorDireccion, direcciones);
	}
}
