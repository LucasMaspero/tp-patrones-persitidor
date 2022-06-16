package persistidor.comandos;

import java.util.List;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;

public interface IObtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando
{
	/**
	 * Obtiene las entidades clase y las entidades atributo asociadas
	 * a la entidad clase. Este es el metodo que se ejecuta antes
	 * de poder utilizar los otros metodos:
	 * getEntidadesClaseAsociadas y getEntidadesAtributoAsociadas.
	 * @param entidadObjeto entidad clase a buscar las entidades relacionadas.
	**/
	void ejecutar(Clase clase);
	
	/**
	 * Obtiene las entidades clase relacionadas a la entidad clase utilizada
	 * en el metodo ejecutar.
	 * NOTA: utilizar el metodo ejecutar antes de utilizar este metodo.
	**/
	List<Clase> getEntidadesClaseAsociadas();
	
	/**
	 * Obtiene las entidades atributo relacionadas a la entidad clase utilizada
	 * en el metodo ejecutar.
	 * NOTA: utilizar el metodo ejecutar antes de utilizar este metodo.
	**/
	List<Atributo> getEntidadesAtributoAsociadas();
}
