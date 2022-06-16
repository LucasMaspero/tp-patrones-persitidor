package persistidor.comandos;

public interface IInsertarEntidadObjetoAsociadaASesionComando
{
	/**
	 * Inserta un nuevo objeto en la DB asociado a una sesion.
	 * Ademas actualiza la ultima fecha de acceso a la sesion.
	 * @param idSesion ID de la sesion.
	 * @param object instancia a persistir en la DB.
	**/
	void ejecutar(long idSesion, Object object);
}
