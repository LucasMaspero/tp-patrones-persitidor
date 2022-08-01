package persistidor.comandos;

import persistidor.excepciones.NoExisteSesionException;
import persistidor.excepciones.TipoOValorInvalidoException;

public interface IActualizarEntidadObjetoAsociadaASesionComando
{
	/**
	 * Elimina la entidad objeto (y todas las entidades relaciones)
	 * de tipo T asociado a una sesion.
	 * Luego, inserta un nuevo objeto en la DB asociado a una sesion.
	 * Ademas actualiza la ultima fecha de acceso a la sesion.
	 * @param idSesion ID de la sesion.
	 * @param clazz clase de la instancia a actualizar.
	 * @throws TipoOValorInvalidoException 
    **/
	void ejecutar(long idSesion, Object o) throws NoExisteSesionException, TipoOValorInvalidoException;
}
