package persistidor.comandos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;

public class ObtenerAsociadosAObjetoComando
{
	@Autowired
	private ObtenerObjetosYValoresAsociadosAObjetoComando obtenerObjetosYValoresAsociadosAObjetoComando;
	
	@Autowired
	private ObtenerClasesYAtributosAsociadosAClaseComando obtenerClasesYAtributosAsociadosAClaseComando;
	
	private List<Clase> clasesAsociadas;
	private List<Atributo> atributosAsociados;
	private List<Objeto> objetosAsociados;
	private List<Valor> valoresAsociados;
	
	public void ejecutar(Objeto objeto)
	{
		obtenerObjetosYValoresAsociadosAObjetoComando.ejecutar(objeto);
		objetosAsociados = obtenerObjetosYValoresAsociadosAObjetoComando.getObjetosAsociados();
		valoresAsociados = obtenerObjetosYValoresAsociadosAObjetoComando.getValoresAsociados();
		
		obtenerClasesYAtributosAsociadosAClaseComando.ejecutar(objeto.getClase());
		
		clasesAsociadas = obtenerClasesYAtributosAsociadosAClaseComando.getClasesAsociadas();
		atributosAsociados = obtenerClasesYAtributosAsociadosAClaseComando.getAtributosAsociados();
	}

	public List<Clase> getClasesAsociadas()
	{
		return clasesAsociadas;
	}

	public List<Atributo> getAtributosAsociados()
	{
		return atributosAsociados;
	}

	public List<Objeto> getObjetosAsociados()
	{
		return objetosAsociados;
	}

	public List<Valor> getValoresAsociados()
	{
		return valoresAsociados;
	}
}
