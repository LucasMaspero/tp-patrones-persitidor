package persistidor.comandos;

import persistidor.excepciones.NoExisteSesionException;

public interface IObtenerTiempoTranscurridoDeSesionComando
{
	/**
     * Obtiene el tiempo transcurrido desde ahora hasta el ultimo
     * acceso a la sesion.
     * @param idClase ID de la sesion a consultar.
    **/
	long ejecutar(long idSesion) throws NoExisteSesionException;
}
