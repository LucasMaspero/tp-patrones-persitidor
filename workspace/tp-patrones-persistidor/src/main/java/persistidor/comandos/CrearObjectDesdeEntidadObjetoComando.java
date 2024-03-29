package persistidor.comandos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Primitivo;
import persistidor.entidades.Valor;
import persistidor.excepciones.StructureChangedException;

@Component
public class CrearObjectDesdeEntidadObjetoComando implements ICrearObjectDesdeEntidadObjetoComando
{
	@Autowired
	private IObtenerValorPrimitivoCasteadoComando obtenerValorPrimitivoCasteadoComando;
	
	public <T> T ejecutar(Objeto entidadObjeto) throws StructureChangedException
	{
		try
		{
			Clase entidadClase = entidadObjeto.getClase();
			String nombreDeClase = entidadClase.getNombre();
			Class<?> clase = Class.forName(nombreDeClase);
			Object objeto = clase.newInstance();
			List<Valor> entidadesValor = entidadObjeto.getValores();
			
			for (Valor entidadValor : entidadesValor)
			{
				Atributo entidadAtributo = entidadValor.getAtributo();
				String nombreAtributo = entidadAtributo.getNombre();
				boolean esPrimitivo = entidadAtributo.esPrimitivo();
				boolean esColeccion = entidadAtributo.esColeccion();
				Primitivo entidadPrimitivo = entidadAtributo.getTipoPrimitivo();
				String nombrePrimitivo = esPrimitivo ? entidadPrimitivo.getNombre() : null;
				String valorPrimitivo = esPrimitivo ? entidadValor.getValorPrimitivo() : null;
				Object primitivoCasteado = esPrimitivo ? obtenerValorPrimitivoCasteadoComando.Ejecutar(nombrePrimitivo, valorPrimitivo) : null;
				Objeto entidadObjetoDeValorObjeto = entidadValor.getValorObjeto();
				Object valorObjeto = esPrimitivo ? null : ejecutar(entidadObjetoDeValorObjeto);

				Field atributo = clase.getDeclaredField(nombreAtributo);
				atributo.setAccessible(true);
				
				if (esPrimitivo && !esColeccion)
				{
					atributo.set(objeto, primitivoCasteado);
					continue;
				}
				
				if (!esPrimitivo && !esColeccion)
				{
					atributo.set(objeto, valorObjeto);
					continue;
				}
				
				ArrayList coleccion = (ArrayList)atributo.get(objeto);
				
				if (coleccion == null)
				{
					coleccion = new ArrayList();
				}
				
				if (esPrimitivo)
				{
					coleccion.add(primitivoCasteado);
					atributo.set(objeto, coleccion);
					continue;
				}
				
				coleccion.add(valorObjeto);
				atributo.set(objeto, coleccion);
			}
			
			return (T)objeto;
		}
		catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException ex)
		{
			System.out.println(ex.getMessage());
			throw new StructureChangedException(ex);
		}
	}
}
