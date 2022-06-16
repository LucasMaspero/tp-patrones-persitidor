package persistidor.comandos;

import persistidor.entidades.Objeto;
import persistidor.excepciones.StructureChangedException;

public interface ICrearObjectDesdeEntidadObjetoComando
{
	/**
	 * Crea un objeto de tipo T a partir de una entidad objeto.
	 * En caso de que la estructura del object no coincida con
	 * la de la enitdad objeto, lanza una excepcion.
	 * @param entidadObjeto entidad objeto a partir de la cual se crea el object de tipo T.
	**/
	<T> T ejecutar(Objeto entidadObjeto) throws StructureChangedException;
}
