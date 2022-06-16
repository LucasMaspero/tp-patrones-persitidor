package persistidor.comandos;

import persistidor.entidades.Sesion;

public interface ICrearSesionSiNoExisteUObtenerSesionActualComando
{
	/**
	 * Recupera la sesion del respectivo ID o 
	 * crea una nueva Sesion si no se la encontro en la DB.
	 * @param idSesion ID de la sesion a recuperar/crear.
	**/
	Sesion ejecutar(long idSesion);
}
