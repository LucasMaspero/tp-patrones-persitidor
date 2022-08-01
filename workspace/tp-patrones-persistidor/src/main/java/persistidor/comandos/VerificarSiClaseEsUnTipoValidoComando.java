package persistidor.comandos;

import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificarSiClaseEsUnTipoValidoComando implements IVerificarSiClaseEsUnTipoValidoComando
{
	@Autowired
	private IVerificarSiClaseEsUnPrimitivoComando verificarSiClaseEsUnPrimitivoComando;
	
	public boolean ejecutar(Class<?> clase)
	{
		boolean esEnum = clase.isEnum();
		boolean esInterfaz = clase.isInterface();
		boolean esColeccion = Collection.class.isAssignableFrom(clase);
		boolean esDiccionario = Map.class.isAssignableFrom(clase);
		boolean esArray = clase.isArray();
		boolean esPrimitivo = verificarSiClaseEsUnPrimitivoComando.ejecutar(clase);
		boolean esClaseDeUsuario = !esPrimitivo && !esColeccion && !esEnum && !esInterfaz && !esDiccionario && !esArray;
		
		return esPrimitivo || esColeccion || esClaseDeUsuario; 
	}
}