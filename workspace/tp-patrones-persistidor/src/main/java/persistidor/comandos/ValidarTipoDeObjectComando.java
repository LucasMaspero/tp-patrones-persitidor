package persistidor.comandos;

import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ValidarTipoDeObjectComando implements IValidarTipoDeObjectComando
{
	public boolean esValido(Object object)
	{
		Class<?> claseDelObjeto = object.getClass();
		
		boolean esEnum = claseDelObjeto.isEnum();
		boolean esInterfaz = claseDelObjeto.isInterface();
		boolean esCollection = Collection.class.isAssignableFrom(claseDelObjeto);
		boolean esDiccionario = Map.class.isAssignableFrom(claseDelObjeto);
		boolean esArray = claseDelObjeto.isArray();
		boolean esString = claseDelObjeto == String.class;
		boolean esInteger = claseDelObjeto.isPrimitive() || claseDelObjeto == Integer.class;
		boolean esByte = claseDelObjeto.isPrimitive() || claseDelObjeto == Byte.class;
		boolean esShort = claseDelObjeto.isPrimitive() || claseDelObjeto == Short.class;
		boolean esLong = claseDelObjeto.isPrimitive() || claseDelObjeto == Long.class;
		boolean esFloat = claseDelObjeto.isPrimitive() || claseDelObjeto == Float.class;
		boolean esDouble = claseDelObjeto.isPrimitive() || claseDelObjeto == Double.class;
		boolean esChar = claseDelObjeto.isPrimitive() || claseDelObjeto == Character.class;
		boolean esBoolean = claseDelObjeto.isPrimitive() || claseDelObjeto == Boolean.class;
		
		return !esEnum &&
			   !esInterfaz &&
			   !esCollection &&
			   !esDiccionario &&
			   !esArray &&
			   !esString &&
			   !esInteger &&
			   !esByte &&
			   !esShort &&
			   !esLong &&
			   !esFloat &&
			   !esDouble &&
			   !esChar &&
			   !esBoolean;
	}
}
