package persistidor.servicios;

import persistidor.entidades.Objeto;

public interface IServicioDeObjetos
{
	/**
     * Elimina un objeto y sus valores asociados.
     * @param Objeto objeto a eliminar.
    **/
	void eliminarObjeto(Objeto objeto, long idSesion);
}
