package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class ActualizarEntidadObjetoAsociadaASesionComando implements IActualizarEntidadObjetoAsociadaASesionComando
{
	@Autowired
	private IEliminarEntidadObjetoYRelacionadasAsociadoASesionComando eliminarEntidadObjetoYRelacionadasAsociadoASesionComando;
	
	@Autowired
	private IInsertarEntidadObjetoAsociadaASesionComando insertarEntidadObjetoAsociadaASesionComando;
	
	public void ejecutar(long idSesion, Object object) throws NoExisteSesionException
	{
		Class<?> claseDelObjeto = object.getClass();
		
		eliminarEntidadObjetoYRelacionadasAsociadoASesionComando.ejecutar(idSesion, claseDelObjeto);
		
		insertarEntidadObjetoAsociadaASesionComando.ejecutar(idSesion, object);
	}
}
