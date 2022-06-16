package persistidor.comandos;

import persistidor.entidades.Objeto;
import persistidor.excepciones.NoExisteSesionException;

public interface IObtenerEntidadObjetoAsociadoASesionComando
{
	/**
     * Busca si existe una instancia de tipo T asociada a una sesion en la DB.
     * Si existe, devuelve su entidad objeto asociada.
     * Si NO existe, devuelve null.
     * @param idSesion ID de la sesion.
     * @param clazz clase de la instancia a buscar.
    **/
	<T> Objeto ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException;
}
