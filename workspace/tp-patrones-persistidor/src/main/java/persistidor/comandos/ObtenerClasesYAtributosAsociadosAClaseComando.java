package persistidor.comandos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Component;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;

@Component
public class ObtenerClasesYAtributosAsociadosAClaseComando
{
	private List<Clase> clasesAsociadas;
	private List<Atributo> atributosAsociados;
	
	public void ejecutar(Clase clase)
	{
		HashSet<Clase> setClasesAsociadas = new HashSet<Clase>();
		HashSet<Atributo> setAtributosAsociados = new HashSet<Atributo>();
		
		this.obtenerClasesYAtributosAsociados(clase, setClasesAsociadas, setAtributosAsociados);
		
		clasesAsociadas = new ArrayList<Clase>(setClasesAsociadas);
		atributosAsociados = new ArrayList<Atributo>(setAtributosAsociados);
	}
	
	private void obtenerClasesYAtributosAsociados(Clase clase, HashSet<Clase> clasesAsociadas, HashSet<Atributo> atributosAsociados)
	{
		clasesAsociadas.add(clase);

		for (Atributo atributo : clase.getAtributos())
		{
			atributosAsociados.add(atributo);
			
			Clase claseTipo = atributo.getTipoClase();
			
			if (claseTipo != null)
			{
				obtenerClasesYAtributosAsociados(claseTipo, clasesAsociadas, atributosAsociados);
			}
		}
	}

	public List<Clase> getClasesAsociadas()
	{
		return clasesAsociadas;
	}

	public List<Atributo> getAtributosAsociados()
	{
		return atributosAsociados;
	}
}
