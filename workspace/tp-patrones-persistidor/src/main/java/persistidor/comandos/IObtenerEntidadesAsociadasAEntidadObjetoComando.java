package persistidor.comandos;

import java.util.List;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;

public interface IObtenerEntidadesAsociadasAEntidadObjetoComando
{
	/**
	 * Obtiene las entidades clase, atributo, objeto y valor asociadas
	 * a la entidad objeto. Este es el metodo que se ejecuta antes
	 * de poder utilizar los otros metodos:
	 * getEntidadesClaseAsociadas, getEntidadesAtributoAsociadas,
	 * getEntidadesObjetoAsociadas y getEntidadesValorAsociadas.
	 * @param entidadObjeto entidad objeto a buscar las entidades relacionadas.
	**/
	void ejecutar(Objeto objeto);
	
	/**
	 * Obtiene las entidades clase relacionadas a la entidad objeto utilizada
	 * en el metodo ejecutar.
	 * NOTA: utilizar el metodo ejecutar antes de utilizar este metodo.
	**/
	List<Clase> getEntidadesClaseAsociadas();

	/**
	 * Obtiene las entidades atributo relacionadas a la entidad objeto utilizada
	 * en el metodo ejecutar.
	 * NOTA: utilizar el metodo ejecutar antes de utilizar este metodo.
	**/
	List<Atributo> getEntidadesAtributoAsociadas();

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
