package persistidor.comandos;

import persistidor.entidades.Clase;
import persistidor.excepciones.TipoOValorInvalidoException;

public interface ICrearEntidadClaseDesdeClassComando
{
	/**
     * Crea una entidad clase desde una class.
     * @param clase class a partir de la cual se crea la entidad clase.
    **/
	Clase ejecutar(Class clase) throws TipoOValorInvalidoException;
}