package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class ActualizarObjetoAsociadoASesionComando
{
	@Autowired
	private EliminarObjetoDeClaseAsociadoASesionComando eliminarObjetoDeClaseAsociadoASesionComando;
	
	public void ejecutar(long idSesion, Object o) throws NoExisteSesionException
	{
		Class<?> claseDelObjeto = o.getClass();
		
		eliminarObjetoDeClaseAsociadoASesionComando.ejecutar(idSesion, claseDelObjeto);
		
		// TO DO
	}
}
