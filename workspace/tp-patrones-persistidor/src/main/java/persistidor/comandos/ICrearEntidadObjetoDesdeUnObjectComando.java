package persistidor.comandos;

import persistidor.entidades.Objeto;

public interface ICrearEntidadObjetoDesdeUnObjectComando
{
	/**
	 * Crea una entidad objeto a partir de un object.
	 * Si la clase del objeto (o la propiedad) tiene la anottation NotPersistable,
	 * no agregara dicha propiedad a la entidad Objeto.
	 * NOTA: este metodo no setea IDs en ninguna entidad.
	 * @param object object a partir del cual se creara la entidad objeto.
	**/
	Objeto ejecutar(Object object);
}
