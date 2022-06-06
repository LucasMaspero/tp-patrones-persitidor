package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class EliminarObjetoDeClaseAsociadoASesionComando
{
	@Autowired
	private ExisteObjetoDeClaseAsociadoASesionComando existeObjetoDeClaseAsociadoASesionComando;
	
	public <T> T Ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException
	{
		if (!existeObjetoDeClaseAsociadoASesionComando.Ejecutar(idSesion, clazz))
		{
			return null;
		}
		
		// TO DO
		return null;
	}
}
