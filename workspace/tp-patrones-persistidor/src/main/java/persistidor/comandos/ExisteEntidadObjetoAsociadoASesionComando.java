package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class ExisteEntidadObjetoAsociadoASesionComando implements IExisteEntidadObjetoAsociadoASesionComando
{
	@Autowired
	private IObtenerEntidadObjetoAsociadoASesionComando obtenerEntidadObjetoAsociadoASesionComando;
	
	public <T> boolean ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException
	{
		Objeto entidadObjeto = obtenerEntidadObjetoAsociadoASesionComando.ejecutar(idSesion, clazz);
		
		return entidadObjeto != null;
	}
}
