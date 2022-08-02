package persistidor.comandos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;
import persistidor.anotaciones.NotPersistable;
import persistidor.anotaciones.Persistable;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;
import persistidor.excepciones.TipoOValorInvalidoException;

@Component
public class CrearEntidadesValorDesdeObjectComando implements ICrearEntidadesValorDesdeObjectComando
{
	public List<Valor> ejecutar(Class clase, Clase entidadClase, Object o) throws TipoOValorInvalidoException
	{
		List<Valor> entidadesValores = new ArrayList<Valor>();
		
		if (!clase.isAnnotationPresent(Persistable.class) || clase.isAnnotationPresent(NotPersistable.class))
		{
			return entidadesValores;
		}
		
		try
		{
			Field[] atributos = clase.getDeclaredFields();
			for (Field atributo : atributos)
			{
				atributo.setAccessible(true);
				
				if (atributo.isAnnotationPresent(NotPersistable.class))
				{
					continue;
				}
				
				Atributo entidadAtributoRelacionada = obtenerEntidadAtributoRelacionada(entidadClase, atributo);
				
				if (entidadAtributoRelacionada.esPrimitivo())
				{
					if (entidadAtributoRelacionada.esColeccion())
					{
						Collection coleccion = (Collection)atributo.get(o);
						for (Object valorDeColeccion : coleccion)
						{
							String valorDelAtributo = valorDeColeccion.toString();
							entidadesValores.add(new Valor(valorDelAtributo, entidadAtributoRelacionada));
						}
					}
					else
					{
						String valorDelAtributo = atributo.get(o).toString();
						entidadesValores.add(new Valor(valorDelAtributo, entidadAtributoRelacionada));
					}
				}
				else
				{
					if (entidadAtributoRelacionada.esColeccion())
					{
						Collection coleccion = (Collection)atributo.get(o);
						for (Object valorDeColeccion : coleccion)
						{
							Class claseDelValorDeColeccion = valorDeColeccion.getClass();
							
							if (!claseDelValorDeColeccion.isAnnotationPresent(Persistable.class) || claseDelValorDeColeccion.isAnnotationPresent(NotPersistable.class))
							{
								continue;
							}
							
							Valor valorDelAtributo = crearValorDesdeValorObjetoDeAtributo(valorDeColeccion, entidadAtributoRelacionada, claseDelValorDeColeccion);
							entidadesValores.add(valorDelAtributo);
						}
					}
					else
					{
						Object valorObjetoDelAtributo = atributo.get(o);
						Class claseDelValorObjetoDelAtributo = valorObjetoDelAtributo.getClass();
						
						if (!claseDelValorObjetoDelAtributo.isAnnotationPresent(Persistable.class) || claseDelValorObjetoDelAtributo.isAnnotationPresent(NotPersistable.class))
						{
							continue;
						}
						
						Valor valorDelAtributo = crearValorDesdeValorObjetoDeAtributo(valorObjetoDelAtributo, entidadAtributoRelacionada, claseDelValorObjetoDelAtributo);
						
						entidadesValores.add(valorDelAtributo);
					}
				}
			}
			
			return entidadesValores;
		}
		catch (IllegalArgumentException | IllegalAccessException ex)
		{
			throw new TipoOValorInvalidoException("Error al intentar obtener valor de atributo");
		}
	}
	
	private Valor crearValorDesdeValorObjetoDeAtributo(Object valorObjetoDelAtributo, Atributo entidadAtributoRelacionada, Class claseDelValorObjetoDelAtributo) throws TipoOValorInvalidoException
	{
		try
		{
			Clase entidadClaseDelValorObjetoDelAtributo = entidadAtributoRelacionada.getTipoClase();
			List<Valor> entidadesValoresDelValorObjetoDelAtributo = ejecutar(claseDelValorObjetoDelAtributo, entidadClaseDelValorObjetoDelAtributo, valorObjetoDelAtributo);
			Objeto entidadObjetoDelAtributo = new Objeto(entidadClaseDelValorObjetoDelAtributo, entidadesValoresDelValorObjetoDelAtributo);
			
			return new Valor(entidadObjetoDelAtributo, entidadAtributoRelacionada);
		}
		catch (IllegalArgumentException ex)
		{
			throw new TipoOValorInvalidoException("Error al intentar obtener valor de atributo");
		}
	}
	
	private Atributo obtenerEntidadAtributoRelacionada(Clase entidadClase, Field atributo)
	{
		for (Atributo entidadAtributo : entidadClase.getAtributos())
		{
			if (entidadAtributo.getNombre() == atributo.getName())
			{
				return entidadAtributo;
			}
		}
		
		return null;
	}

}
