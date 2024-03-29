package persistidor.comandos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;

public class ObtenerEntidadesAsociadasAEntidadObjetoComando implements IObtenerEntidadesAsociadasAEntidadObjetoComando
{
	@Autowired
	private IObtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando;
	
	@Autowired
	private IObtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando;
	
	private List<Clase> clasesAsociadas;
	private List<Atributo> atributosAsociados;
	private List<Objeto> objetosAsociados;
	private List<Valor> valoresAsociados;
	
	public void ejecutar(Objeto objeto)
	{
		obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando.ejecutar(objeto);
		objetosAsociados = obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando.getEntidadesObjetoAsociadas();
		valoresAsociados = obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando.getEntidadesValorAsociadas();
		
		obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando.ejecutar(objeto.getClase());
		
		clasesAsociadas = obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando.getEntidadesClaseAsociadas();
		atributosAsociados = obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando.getEntidadesAtributoAsociadas();
	}

	public List<Clase> getEntidadesClaseAsociadas()
	{
		return clasesAsociadas;
	}

	public List<Atributo> getEntidadesAtributoAsociadas()
	{
		return atributosAsociados;
	}

	public List<Objeto> getEntidadesObjetoAsociadas()
	{
		return objetosAsociados;
	}

	public List<Valor> getEntidadesValorAsociadas()
	{
		return valoresAsociados;
	}
}
