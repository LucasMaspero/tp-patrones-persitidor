package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class EliminarObjetoDeClaseAsociadoASesionComando
{
	@Autowired
	private ExisteObjetoDeClaseAsociadoASesionComando existeObjetoDeClaseAsociadoASesionComando;
	
	public <T> T ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException
	{
		if (!existeObjetoDeClaseAsociadoASesionComando.ejecutar(idSesion, clazz))
		{
			return null;
		}
		
		// TO DO
		return null;
	}
}
