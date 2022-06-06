package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class ActualizarObjetoEnLaDbComando
{
	@Autowired
	private EliminarObjetoDeClaseAsociadoASesionComando eliminarObjetoDeClaseAsociadoASesionComando;
	
	public void Ejecutar(long idSesion, Object o) throws NoExisteSesionException
	{
		Class<?> claseDelObjeto = o.getClass();
		
		eliminarObjetoDeClaseAsociadoASesionComando.Ejecutar(idSesion, claseDelObjeto);
		
		// TO DO
	}
}
