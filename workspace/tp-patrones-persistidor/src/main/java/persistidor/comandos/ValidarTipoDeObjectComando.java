package persistidor.comandos;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTipoDeObjectComando implements IValidarTipoDeObjectComando
{
	@Autowired
	private IVerificarSiClaseEsUnPrimitivoComando verificarSiClaseEsUnPrimitivoComando;
	
	public boolean esValidoParaPersistirDirectamente(Object object)
	{
		Class<?> claseDelObjeto = object.getClass();
		
		boolean esEnum = claseDelObjeto.isEnum();
		boolean esInterfaz = claseDelObjeto.isInterface();
		boolean esCollection = Collection.class.isAssignableFrom(claseDelObjeto);
		boolean esDiccionario = Map.class.isAssignableFrom(claseDelObjeto);
		boolean esArray = claseDelObjeto.isArray();
		boolean esPrimitivo = verificarSiClaseEsUnPrimitivoComando.ejecutar(claseDelObjeto);
		
		return !esEnum &&
			   !esInterfaz &&
			   !esCollection &&
			   !esDiccionario &&
			   !esArray &&
			   !esPrimitivo;
	}
}
