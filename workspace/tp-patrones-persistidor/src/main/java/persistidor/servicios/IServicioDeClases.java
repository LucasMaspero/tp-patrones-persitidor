package persistidor.servicios;

public interface IServicioDeClases
{
	/**
     * Elimina una clase por ID y sus atributos asociados.
     * @param idClase ID de la clase a eliminar.
     * Devuelve true si pudo eliminar la clase y sus atributos asociados
     * o false si NO pudo eliminar la clase y sus atributos asociados.
    **/
	boolean eliminarClasePorId(long idClase);
}
