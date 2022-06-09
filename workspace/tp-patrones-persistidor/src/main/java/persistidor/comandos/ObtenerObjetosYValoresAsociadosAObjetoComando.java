package persistidor.comandos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;

@Component
public class ObtenerObjetosYValoresAsociadosAObjetoComando
{
	private List<Objeto> objetosAsociados;
	private List<Valor> valoresAsociados;
	
	public void ejecutar(Objeto objeto)
	{
		HashSet<Objeto> setObjetosAsociados = new HashSet<Objeto>();
		HashSet<Valor> setValoresAsociados = new HashSet<Valor>();
		
		this.obtenerObjetosYValoresAsociados(objeto, setObjetosAsociados, setValoresAsociados);
		
		objetosAsociados = new ArrayList<Objeto>(setObjetosAsociados);
		valoresAsociados = new ArrayList<Valor>(setValoresAsociados);
	}
	
	private void obtenerObjetosYValoresAsociados(Objeto objeto, HashSet<Objeto> objetosAsociados, HashSet<Valor> valoresAsociados)
	{
		objetosAsociados.add(objeto);

		for (Valor valor : objeto.getValores())
		{
			valoresAsociados.add(valor);
			
			Objeto valorObjeto = valor.getValorObjeto();
			
			if (valorObjeto != null)
			{
				obtenerObjetosYValoresAsociados(valorObjeto, objetosAsociados, valoresAsociados);
			}
		}
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
