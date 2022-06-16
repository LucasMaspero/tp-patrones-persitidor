package persistidor.comandos;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import persistidor.controladores.Direccion;
import persistidor.controladores.Persona;
import persistidor.entidades.Objeto;
import persistidor.excepciones.StructureChangedException;

@Component
public class CrearObjectDesdeEntidadObjetoComando implements ICrearObjectDesdeEntidadObjetoComando
{
	public <T> T ejecutar(Objeto entidadObjeto) throws StructureChangedException
	{
		// TODO ESTO ES UN EJEMPLO DE LO QUE DEBERIIA DEVOLVER SI LE MANDAS UNA ENTIDAD OBJETO
		// DE PERSONA.
		
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
		
		return (T)new Persona("123", "Pepe", telefonos, laMejorDireccion, direcciones);
	}
}
