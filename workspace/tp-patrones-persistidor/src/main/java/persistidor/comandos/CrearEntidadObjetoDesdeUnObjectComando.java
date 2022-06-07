package persistidor.comandos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Primitivo;
import persistidor.entidades.Sesion;
import persistidor.entidades.Valor;
import persistidor.servicios.ServicioDePrimitivos;

@Component
public class CrearEntidadObjetoDesdeUnObjectComando
{
	@Autowired
	private ServicioDePrimitivos servicioDePrimitivos;
	
	// Crea una entidad objeto a partir de un object.
	// Si la clase del objeto o (o la propiedad) tiene la anottation Persistable,
	// asegurarse de cargarla en el "Objeto".
	// Si la clase del objeto o (o la propiedad) tiene la anottation NotPersistable,
	// asegurarse de NO cargarla en el "Objeto".
	// No setear IDs nunca (de ninguna entidad, eso se maneja solo en los repos).
	public Objeto Ejecutar(Object o, Sesion sesion)
	{
		Primitivo primitivoString = servicioDePrimitivos.ObtenerPrimitivoPorNombre("String");
		Primitivo primitivoInt = servicioDePrimitivos.ObtenerPrimitivoPorNombre("int");
		
		// ....................................................................................................
		// DIRECCION
		// ....................................................................................................
		Atributo atributoCalleDeDireccion = new Atributo("calle", primitivoString, false);
		Atributo atributoNumeroDeDireccion = new Atributo("numero", primitivoInt, false);
		Atributo atributoCodigoPostalDeDireccion = new Atributo("codigoPostal", primitivoString, false);
		Atributo atributoLocalidadDeDireccion = new Atributo("localidad", primitivoString, false);
		Atributo atributoProvinciaDeDireccion = new Atributo("provincia", primitivoString, false);
		Atributo atributoPaisDeDireccion = new Atributo("pais", primitivoString, false);
		
		List<Atributo> atributosDeDireccion = new ArrayList<Atributo>();
		atributosDeDireccion.add(atributoCalleDeDireccion);
		atributosDeDireccion.add(atributoNumeroDeDireccion);
		atributosDeDireccion.add(atributoCodigoPostalDeDireccion);
		atributosDeDireccion.add(atributoLocalidadDeDireccion);
		atributosDeDireccion.add(atributoProvinciaDeDireccion);
		atributosDeDireccion.add(atributoPaisDeDireccion);
		
		Clase claseDireccion = new Clase("persistidor.controladores.Direccion", atributosDeDireccion);
		// ....................................................................................................
		
		// ....................................................................................................
		// PERSONA
		// ....................................................................................................
		Atributo atributoDniDePersona = new Atributo("dni", primitivoInt, false);
		Atributo atributoNombreDePersona = new Atributo("nombre", primitivoString, false);
		Atributo atributoLaMejorDireccionDePersona = new Atributo("laMejorDireccion", claseDireccion, false);
		Atributo atributoTelefonosDePersona = new Atributo("telefonos", primitivoString, true);
		Atributo atributoDireccionesDePersona = new Atributo("direcciones", claseDireccion, true);
		
		List<Atributo> atributosDePersona = new ArrayList<Atributo>();
		atributosDePersona.add(atributoDniDePersona);
		atributosDePersona.add(atributoNombreDePersona);
		atributosDePersona.add(atributoLaMejorDireccionDePersona);
		atributosDePersona.add(atributoTelefonosDePersona);
		atributosDePersona.add(atributoDireccionesDePersona);
		
		Clase clasePersona = new Clase("persistidor.controladores.Persona", atributosDePersona);
		// ....................................................................................................
		
		// ....................................................................................................
		// LA MEJOR DIRECCION
		// ....................................................................................................
		Valor valorCalleParaObjetoLaMejorDireccion = new Valor("Cuenca", atributoCalleDeDireccion);
		Valor valorNumeroParaObjetoLaMejorDireccion = new Valor("1235", atributoNumeroDeDireccion);
		Valor valorCodigoPostalParaObjetoLaMejorDireccion = new Valor("C1245DQW", atributoCodigoPostalDeDireccion);
		Valor valorLocalidadParaObjetoLaMejorDireccion = new Valor("CABA", atributoLocalidadDeDireccion);
		Valor valorProvinciaParaObjetoLaMejorDireccion = new Valor("CABA", atributoProvinciaDeDireccion);
		Valor valorPaisParaObjetoLaMejorDireccion = new Valor("Argentina", atributoPaisDeDireccion);
		
		List<Valor> valoresDeLaMejorDireccion = new ArrayList<Valor>();
		valoresDeLaMejorDireccion.add(valorCalleParaObjetoLaMejorDireccion);
		valoresDeLaMejorDireccion.add(valorNumeroParaObjetoLaMejorDireccion);
		valoresDeLaMejorDireccion.add(valorCodigoPostalParaObjetoLaMejorDireccion);
		valoresDeLaMejorDireccion.add(valorLocalidadParaObjetoLaMejorDireccion);
		valoresDeLaMejorDireccion.add(valorProvinciaParaObjetoLaMejorDireccion);
		valoresDeLaMejorDireccion.add(valorPaisParaObjetoLaMejorDireccion);
		
		Objeto objetoLaMejorDireccion = new Objeto(claseDireccion, valoresDeLaMejorDireccion);
		// ....................................................................................................
		
		// ....................................................................................................
		// DIRECCION 1
		// ....................................................................................................
		Valor valorCalleParaObjetoDireccion1 = new Valor("Corrientes", atributoCalleDeDireccion);
		Valor valorNumeroParaObjetoDireccion1 = new Valor("452", atributoNumeroDeDireccion);
		Valor valorCodigoPostalParaObjetoDireccion1 = new Valor("B5514ABC", atributoCodigoPostalDeDireccion);
		Valor valorLocalidadParaObjetoDireccion1 = new Valor("Buenos Aires", atributoLocalidadDeDireccion);
		Valor valorProvinciaParaObjetoDireccion1 = new Valor("Buenos Aires", atributoProvinciaDeDireccion);
		Valor valorPaisParaObjetoDireccion1 = new Valor("Argentina", atributoPaisDeDireccion);
		
		List<Valor> valoresDeDireccion1 = new ArrayList<Valor>();
		valoresDeDireccion1.add(valorCalleParaObjetoDireccion1);
		valoresDeDireccion1.add(valorNumeroParaObjetoDireccion1);
		valoresDeDireccion1.add(valorCodigoPostalParaObjetoDireccion1);
		valoresDeDireccion1.add(valorLocalidadParaObjetoDireccion1);
		valoresDeDireccion1.add(valorProvinciaParaObjetoDireccion1);
		valoresDeDireccion1.add(valorPaisParaObjetoDireccion1);
		
		Objeto objetoDireccion1 = new Objeto(claseDireccion, valoresDeDireccion1);
		// ....................................................................................................
		
		// ....................................................................................................
		// DIRECCION 2
		// ....................................................................................................
		Valor valorCalleParaObjetoDireccion2 = new Valor("Pedro Moran", atributoCalleDeDireccion);
		Valor valorNumeroParaObjetoDireccion2 = new Valor("2345", atributoNumeroDeDireccion);
		Valor valorCodigoPostalParaObjetoDireccion2 = new Valor("ABC123", atributoCodigoPostalDeDireccion);
		Valor valorLocalidadParaObjetoDireccion2 = new Valor("Buzios", atributoLocalidadDeDireccion);
		Valor valorProvinciaParaObjetoDireccion2 = new Valor("Rio de Janeiro", atributoProvinciaDeDireccion);
		Valor valorPaisParaObjetoDireccion2 = new Valor("Brasil", atributoPaisDeDireccion);
		
		List<Valor> valoresDeDireccion2 = new ArrayList<Valor>();
		valoresDeDireccion2.add(valorCalleParaObjetoDireccion2);
		valoresDeDireccion2.add(valorNumeroParaObjetoDireccion2);
		valoresDeDireccion2.add(valorCodigoPostalParaObjetoDireccion2);
		valoresDeDireccion2.add(valorLocalidadParaObjetoDireccion2);
		valoresDeDireccion2.add(valorProvinciaParaObjetoDireccion2);
		valoresDeDireccion2.add(valorPaisParaObjetoDireccion2);
		
		Objeto objetoDireccion2 = new Objeto(claseDireccion, valoresDeDireccion2);
		// ....................................................................................................

		Valor valorDniParaPersona = new Valor("123", atributoDniDePersona);
		Valor valorNombreParaPersona = new Valor("Pepe", atributoNombreDePersona);
		Valor valorLaMejorDireccionParaPersona = new Valor(objetoLaMejorDireccion, atributoLaMejorDireccionDePersona);
		Valor valorTelefono1ParaPersona = new Valor("4444-2222", atributoTelefonosDePersona);
		Valor valorTelefono2ParaPersona = new Valor("5555-3333", atributoTelefonosDePersona);
		Valor valorTelefono3ParaPersona = new Valor("6666-4444", atributoTelefonosDePersona);
		Valor valorDireccion1ParaPersona = new Valor(objetoDireccion1, atributoDireccionesDePersona);
		Valor valorDireccion2ParaPersona = new Valor(objetoDireccion2, atributoDireccionesDePersona);
		
		List<Valor> valoresDePersona = new ArrayList<Valor>();
		valoresDePersona.add(valorDniParaPersona);
		valoresDePersona.add(valorNombreParaPersona);
		valoresDePersona.add(valorLaMejorDireccionParaPersona);
		valoresDePersona.add(valorTelefono1ParaPersona);
		valoresDePersona.add(valorTelefono2ParaPersona);
		valoresDePersona.add(valorTelefono3ParaPersona);
		valoresDePersona.add(valorDireccion1ParaPersona);
		valoresDePersona.add(valorDireccion2ParaPersona);
		
		Objeto objetoPersona = new Objeto(clasePersona, valoresDePersona, sesion);
		
		return objetoPersona;
	}
}
