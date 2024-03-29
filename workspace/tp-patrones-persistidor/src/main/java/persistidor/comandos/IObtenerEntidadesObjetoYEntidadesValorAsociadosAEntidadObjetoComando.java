package persistidor.comandos;

import java.util.List;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;

public interface IObtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando
{
	/**
	 * Obtiene las entidades objeto y las entidades valor asociadas
	 * a la entidad objeto. Este es el metodo que se ejecuta antes
	 * de poder utilizar los otros metodos:
	 * getEntidadesObjetoAsociadas y getEntidadesValorAsociadas.
	 * @param entidadObjeto entidad objeto a buscar las entidades relacionadas.
	**/
	void ejecutar(Objeto entidadObjeto);
	
	/**
	 * Obtiene las entidades objeto relacionadas a la entidad objeto utilizada
	 * en el metodo ejecutar.
	 * NOTA: utilizar el metodo ejecutar antes de utilizar este metodo.
	**/
	List<Objeto> getEntidadesObjetoAsociadas();
	
	/**
	 * Obtiene las entidades valor relacionadas a la entidad objeto utilizada
	 * en el metodo ejecutar.
	 * NOTA: utilizar el metodo ejecutar antes de utilizar este metodo.
	**/
	List<Valor> getEntidadesValorAsociadas();
}
