package persistidor.comandos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;

@Component
public class ObtenerTodasLasClasesInvolucradasDeObjetoComando
{
	public ArrayList<Clase> Ejecutar(Objeto objeto)
	{
		// NO quiero repetidos
		Set<Clase> clasesInvolucradas = new HashSet<Clase>();
		
		// Agrego la clase del objeto
		clasesInvolucradas.add(objeto.getClase());
		
		List<Valor> valores = objeto.getValores();
		
		if (valores != null)
		{
			for (Valor valor : valores)
			{
				Objeto valorObjeto = valor.getValorObjeto();
				
				if (valorObjeto != null)
				{
					clasesInvolucradas.addAll(Ejecutar(valorObjeto));
				}
			}
		}
		
		return new ArrayList<Clase>(clasesInvolucradas);
	}
}
