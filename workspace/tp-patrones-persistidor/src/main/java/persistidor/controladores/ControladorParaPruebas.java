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
import persistidor.excepciones.NadaQuePersistirException;
import persistidor.excepciones.NoExisteSesionException;
import persistidor.excepciones.StructureChangedException;
import persistidor.excepciones.TipoOValorInvalidoException;

@RestController
public class ControladorParaPruebas
{
	@Autowired
	private IPersistentObject persistentObject;
	
	@GetMapping("storePersona1/{idSesion}")
    public ResponseEntity<?> storePersona1(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearPersona1());
    }
	
	@GetMapping("storePersona2/{idSesion}")
    public ResponseEntity<?> storePersona2(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearPersona2());
    }
	
	@GetMapping("storePersona3/{idSesion}")
    public ResponseEntity<?> storePersona3(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearPersona3());
    }
	
	@GetMapping("storePersona4/{idSesion}")
    public ResponseEntity<?> storePersona4(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearPersona4());
    }
	
	@GetMapping("storePersona5/{idSesion}")
    public ResponseEntity<?> storePersona5(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearPersona5());
    }
	
	@GetMapping("storeDireccion/{idSesion}")
    public ResponseEntity<?> storeDireccion(@PathVariable("idSesion") Integer idSesion)
    {
		return store(idSesion, CrearDireccion());
    }
	
	@GetMapping("storePersona1Modificada/{idSesion}")
	public ResponseEntity<?> storePersona1Modificada(@PathVariable("idSesion") Integer idSesion)
	{
		Persona1 persona1 = CrearPersona1();
		persona1.setDni(111111111);
		persona1.setNombre("Nicolas");
		
		return store(idSesion, persona1);
	}

	@GetMapping("storePersona2Modificada/{idSesion}")
	public ResponseEntity<?> storePersona2Modificada(@PathVariable("idSesion") Integer idSesion)
	{
		Persona2 persona2 = CrearPersona2();
		persona2.setDni(22222222);
		persona2.setNombre("Laura");
		
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("15-1234-1234");
		persona2.setTelefonos(telefonos);
		
		return store(idSesion, persona2);
	}

	@GetMapping("storePersona3Modificada/{idSesion}")
	public ResponseEntity<?> storePersona3Modificada(@PathVariable("idSesion") Integer idSesion)
	{
		Persona3 persona3 = CrearPersona3();
		persona3.setDni(33333333);
		persona3.setNombre("Jennifer");
		
		return store(idSesion, persona3);
	}

	@GetMapping("storePersona4Modificada/{idSesion}")
	public ResponseEntity<?> storePersona4Modificada(@PathVariable("idSesion") Integer idSesion)
	{
		Persona4 persona4 = CrearPersona4();
		persona4.setDni(44444444);
		persona4.setNombre("Cristian");
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("1111-2222");
		telefonos.add("3333-4444");
		persona4.setTelefonos(telefonos);
		
		return store(idSesion, persona4);
	}

	@GetMapping("storeDireccionModificada/{idSesion}")
	public ResponseEntity<?> storeDireccionModificada(@PathVariable("idSesion") Integer idSesion)
	{
		Direccion direccion = CrearDireccion();
		direccion.setCalle("Una calle modificada");
		direccion.setPais("Un pais modificado");
		
		return store(idSesion, direccion);
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
		catch(NadaQuePersistirException ex)
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
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
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
			return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
		}
    }
	
	private Persona1 CrearPersona1()
	{
		return new Persona1(12345678, "Lucas");
	}
	
	private Persona2 CrearPersona2()
	{
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("1111-2222");
		telefonos.add("3333-4444");
		
		return new Persona2(23456789, "Pablo", telefonos);
	}
	
	private Persona3 CrearPersona3()
	{
		Direccion direccion1 = new Direccion("Corrientes", 452, "B5514ABC", "Buenos Aires", "Buenos Aires", "Argentina");
		Direccion direccion2 = new Direccion("Pedro Moran", 2345, "ABC123", "Buzios", "Rio de Janeiro", "Brasil");
		
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("5555-6666");
		telefonos.add("7777-8888");
		telefonos.add("9999-0000");
		
		return new Persona3(34567890, "Alberto", telefonos, direcciones);
	}
	
	private Persona4 CrearPersona4()
	{
		Direccion laMejorDireccion = new Direccion("Tinogasta", 6732, "A1234AAA", "Ciudad de Mendoza", "Mendoza", "Argentina");
		Direccion direccion1 = new Direccion("Medrano", 1234, "B1234BBB", "Cordoba Capital", "Cordoba", "Argentina");
		Direccion direccion2 = new Direccion("Beiro", 2745, "C1234CCCA", "Resistencia", "Chaco", "Argentina");
		
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("1122-3344");
		
		return new Persona4(45678901, "Rinalda", telefonos, laMejorDireccion, direcciones);
	}
	
	private Persona5 CrearPersona5()
	{
		Direccion laMejorDireccion = new Direccion("Tinogasta", 6732, "A1234AAA", "Ciudad de Mendoza", "Mendoza", "Argentina");
		Direccion direccion1 = new Direccion("Medrano", 1234, "B1234BBB", "Cordoba Capital", "Cordoba", "Argentina");
		Direccion direccion2 = new Direccion("Beiro", 2745, "C1234CCCA", "Resistencia", "Chaco", "Argentina");
		
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("1122-3344");
		
		return new Persona5(45678901, "Rinalda", telefonos, laMejorDireccion, direcciones);
	}
	
	private Direccion CrearDireccion()
	{
		return new Direccion("Av San Martin", 1111, "Z1234ZZZ", "CABA", "CABA", "Argentina");
	}
}
