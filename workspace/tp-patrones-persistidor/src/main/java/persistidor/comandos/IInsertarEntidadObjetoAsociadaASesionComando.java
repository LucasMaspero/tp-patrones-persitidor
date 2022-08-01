package persistidor.comandos;

import persistidor.excepciones.NadaQuePersistirException;
import persistidor.excepciones.TipoOValorInvalidoException;

public interface IInsertarEntidadObjetoAsociadaASesionComando
{
	/**
	 * Inserta un nuevo objeto en la DB asociado a una sesion.
	 * Ademas actualiza la ultima fecha de acceso a la sesion.
	 * @param idSesion ID de la sesion.
	 * @param object instancia a persistir en la DB.
	 * @throws TipoOValorInvalidoException 
	 * @throws NadaQuePersistirException 
	**/
	void ejecutar(long idSesion, Object object) throws TipoOValorInvalidoException, NadaQuePersistirException;
}
