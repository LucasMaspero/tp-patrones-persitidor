package persistidor.comandos;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Primitivo;
import persistidor.excepciones.TipoOValorInvalidoException;
import persistidor.servicios.IServicioDePrimitivos;

@Component
public class CrearEntidadClaseDesdeClassComando implements ICrearEntidadClaseDesdeClassComando
{
	@Autowired
	private IServicioDePrimitivos servicioDePrimitivos;
	
	@Autowired
	private IVerificarSiClaseEsUnPrimitivoComando verificarSiClaseEsUnPrimitivoComando;
	
	@Autowired
	private IVerificarSiClaseEsUnTipoValidoComando verificarSiClaseEsUnTipoValidoComando;
	
	public Clase ejecutar(Class clase) throws TipoOValorInvalidoException
	{
		return ejecutar(clase, new ArrayList<Clase>());
	}
	
	private Clase ejecutar(Class clase, List<Clase> entidadesClaseYaCreadas) throws TipoOValorInvalidoException
	{
		String nombreDeClase = clase.getName();
		Field[] atributos = clase.getDeclaredFields();
		List<Atributo> entidadesAtributos = new ArrayList<Atributo>();

		for (Field atributo : atributos)
		{
			Atributo entidadAtributo = crearEntidadAtributo(atributo, entidadesClaseYaCreadas);
			entidadesAtributos.add(entidadAtributo);
		}
		
		return new Clase(nombreDeClase, entidadesAtributos);
	}
	
	private Atributo crearEntidadAtributo(Field atributo, List<Clase> entidadesClaseYaCreadas) throws TipoOValorInvalidoException
	{
		String nombreDeAtributo = atributo.getName();
		Class<?> claseDelAtributo = atributo.getType();
		String nombreDeClaseDelAtributo = claseDelAtributo.getTypeName();
		String nombreNormalizadoDeClaseDelAtributo = normalizarNombreDeClase(nombreDeClaseDelAtributo);
		
		if (!verificarSiClaseEsUnTipoValidoComando.ejecutar(claseDelAtributo))
		{
			throw new TipoOValorInvalidoException("PeristentObject NO guarda objects de tipo " + nombreNormalizadoDeClaseDelAtributo);
		}
		
		boolean esColeccion = Collection.class.isAssignableFrom(claseDelAtributo);
		
		if (esColeccion)
		{
			claseDelAtributo = obtenerGenericDeColeccion(atributo);
			nombreDeClaseDelAtributo = claseDelAtributo.getTypeName();
			nombreNormalizadoDeClaseDelAtributo = normalizarNombreDeClase(nombreDeClaseDelAtributo);
		}
		
		boolean esPrimitivo = verificarSiClaseEsUnPrimitivoComando.ejecutar(claseDelAtributo);
		
		if (esPrimitivo)
		{
			Primitivo entidadPrimitivo = servicioDePrimitivos.ObtenerPrimitivoPorNombre(nombreNormalizadoDeClaseDelAtributo);
			return new Atributo(nombreDeAtributo, entidadPrimitivo, esColeccion);
		}
		
		Clase entidadClaseDelAtributo = null;
		for (Clase entidadClaseYaCreada : entidadesClaseYaCreadas)
		{
			if (entidadClaseYaCreada.getNombre() == nombreNormalizadoDeClaseDelAtributo)
			{
				entidadClaseDelAtributo = entidadClaseYaCreada;
				break;
			}
		}
		
		if (entidadClaseDelAtributo == null)
		{
			entidadClaseDelAtributo = ejecutar(claseDelAtributo, entidadesClaseYaCreadas);
			entidadesClaseYaCreadas.add(entidadClaseDelAtributo);
		}
		
		return new Atributo(nombreDeAtributo, entidadClaseDelAtributo, esColeccion);
	}
	
	private Class obtenerGenericDeColeccion(Field atributo) throws TipoOValorInvalidoException
	{
		try
		{
			ParameterizedType genericDeColeccion = (ParameterizedType) atributo.getGenericType();
			Class genericDelAtributoColeccion = (Class<?>) genericDeColeccion.getActualTypeArguments()[0];
			String nombreDeClaseDelGeneric = genericDelAtributoColeccion.getTypeName();
			
			if (!verificarSiClaseEsUnTipoValidoComando.ejecutar(genericDelAtributoColeccion))
			{
				throw new TipoOValorInvalidoException("PeristentObject NO guarda objects de tipo " + nombreDeClaseDelGeneric);
			}
			
			boolean genericDelAtributoColeccionEsColeccion = Collection.class.isAssignableFrom(genericDelAtributoColeccion);
			
			if (genericDelAtributoColeccionEsColeccion)
			{
				throw new TipoOValorInvalidoException("PeristentObject NO guarda colecciones de colecciones");
			}
			
			return genericDelAtributoColeccion;
		}
		catch (Exception ex)
		{
			throw new TipoOValorInvalidoException("NO se aceptan colecciones sin generics");
		}
	}

	private String normalizarNombreDeClase(String nombreDeClase)
	{
		return nombreDeClase == "java.lang.String" ? "string" : nombreDeClase;
	}
}
