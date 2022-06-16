package persistidor.comandos;

import persistidor.excepciones.NoExisteSesionException;
import persistidor.excepciones.StructureChangedException;

public interface IObtenerObjectAsociadoASesionComando
{
	/**
	 * Obtiene la instancia de tipo clazz dada un ID de Sesion.
	 * Si la sesion NO existe, tira NoExisteSesionException.
	 * Si la sesion existe, pero NO tiene ninguna instancia del tipo clazz, devuelve null.
	 * Si la sesion existe, y tiene ninguna instancia del tipo clazz, la devuelve.
	 * @param idSesion ID de la sesion a obtener la instancia de tipo clazz.
	**/
	<T> T ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException, StructureChangedException;
}
