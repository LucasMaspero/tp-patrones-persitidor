package persistidor.servicios;

import persistidor.entidades.Sesion;

public interface IServicioDeSesiones
{
	/**
     * Obtiene una sesion segun un ID o null si no la encuentra.
     * @param idSesion ID de la sesion a obtener.
    **/
	Sesion obtenerSesionPorId(long idSesion);

	/**
     * Crea una sesion que antes no existia (y sus entidades asociadas) en la DB.
     * @param sesion a insertar en la DB.
    **/
	void insertarSesion(Sesion sesion);
	
	/**
     * Agrega (NO QUITA) objetos a una sesion existente (y sus entidades asociadas) a la DB.
     * Tambien actualiza el ultimo acceso a la sesion dada, utilizando la fecha y hora actual.
     * @param sesion a actualizar en la DB.
    **/
	void actualizarSesion(Sesion sesion);

	/**
     * Actualiza el ultimo acceso a la sesion dada, utilizando la fecha y hora actual.
     * @param idSesion ID de la sesion a actualizar el ultimo acceso.
    **/
	void actualizarUltimoAcceso(long idSesion);
	
	/**
     * Chequea si existe una sesion en la DB.
     * @param idSesion ID de la sesion a chequear si existe en la DB.
    **/
	boolean existeSesion(long idSesion);
}
