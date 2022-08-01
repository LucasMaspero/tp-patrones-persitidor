package persistidor.comandos;

import java.util.List;
import persistidor.entidades.Clase;
import persistidor.entidades.Valor;
import persistidor.excepciones.TipoOValorInvalidoException;

public interface ICrearEntidadesValorDesdeObjectComando
{
	/**
     * .
     * @param clase clase relacionada al objeto que contiene los valores a crear.
     * @param entidadClase entidad clase relacionada al objeto que contiene los valores a crear.
     * @param o objeto que contiene los valores a crear.
    **/
	List<Valor> ejecutar(Class clase, Clase entidadClase, Object o) throws TipoOValorInvalidoException;
}
