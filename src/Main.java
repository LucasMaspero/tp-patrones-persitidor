import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.dni = 123;
		persona.nombre = "Pepe";
		
		Direccion laMejorDireccion = new Direccion();
		laMejorDireccion.calle = "Cuenca";
		laMejorDireccion.numero = 1235;
		laMejorDireccion.codigoPostal = "C1245DQW";
		laMejorDireccion.localidad = "CABA";
		laMejorDireccion.provincia = "CABA";
		laMejorDireccion.pais = "Argentina";
		persona.laMejorDireccion = laMejorDireccion;
		
		ArrayList<String> telefonos = new ArrayList<String>();
		telefonos.add("4444-2222");
		telefonos.add("5555-3333");
		telefonos.add("6666-4444");
		persona.telefonos = telefonos;
		
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		Direccion direccion1 = new Direccion();
		laMejorDireccion.calle = "Corrientes";
		laMejorDireccion.numero = 452;
		laMejorDireccion.codigoPostal = "B5514ABC";
		laMejorDireccion.localidad = "Buenos Aires";
		laMejorDireccion.provincia = "Buenos Aires";
		laMejorDireccion.pais = "Argentina";
		Direccion direccion2 = new Direccion();
		laMejorDireccion.calle = "Pedro Moran";
		laMejorDireccion.numero = 2345;
		laMejorDireccion.codigoPostal = "ABC123";
		laMejorDireccion.localidad = "Buzios";
		laMejorDireccion.provincia = "Rio de Janeiro";
		laMejorDireccion.pais = "Brasil";
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		persona.direcciones = direcciones;
		
		PersistentObject persistidor = new PersistentObject();
		persistidor.store(1, persona);
	}
}
