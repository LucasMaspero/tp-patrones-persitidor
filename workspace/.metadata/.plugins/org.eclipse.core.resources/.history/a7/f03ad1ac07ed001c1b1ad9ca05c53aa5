package persistidor.comandos;

import persistidor.excepciones.NoExisteSesionException;

public interface IEliminarEntidadObjetoYRelacionadasAsociadoASesionComando
{
	/**
	 * Elimina la entidad objeto (y todas las entidades relaciones)
	 * de tipo T asociado a una sesion. Ademas actualiza la ultima fecha
	 * de acceso a la sesion.
	 * @param idSesion ID de la sesion.
	 * @param clazz clase de la instancia a eliminar.
	**/
	<T> void ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException;
}
