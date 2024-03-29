package persistidor.comandos;

import persistidor.excepciones.NoExisteSesionException;

public interface IExisteEntidadObjetoAsociadoASesionComando
{
	/**
	 * Chequea si existe alguna instancia de la clase clazz asociado a una sesion.
	 * Basicamente, esto da true siempre y cuando se haya persistido de forma directa algun objeto
	 * de clase clazz con ese ID de sesion.
	 * @param idSesion ID de la sesion a chequear si existe alguna instancia asociada.
	**/
	<T> boolean ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException;
}
