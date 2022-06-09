package persistidor.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.comandos.ObtenerClasesYAtributosAsociadosAClaseComando;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.repositorios.RepositorioDeAtributos;
import persistidor.repositorios.RepositorioDeClases;

@Service
public class ServicioDeClases
{
	@Autowired
	private RepositorioDeAtributos repositorioDeAtributos;
	
	@Autowired
	private RepositorioDeClases repositorioDeClases;
	
	@Autowired
	private ObtenerClasesYAtributosAsociadosAClaseComando obtenerClasesYAtributosAsociadosAClaseComando;
	
	public void eliminarClasePorId(long idClase)
	{
		Clase clasePadre = repositorioDeClases.findById(idClase).orElse(null);
		
		if (clasePadre == null) return;
		
		obtenerClasesYAtributosAsociadosAClaseComando.ejecutar(clasePadre);
		
		List<Clase> clasesAEliminar = obtenerClasesYAtributosAsociadosAClaseComando.getClasesAsociadas();
		List<Atributo> atributosAEliminar = obtenerClasesYAtributosAsociadosAClaseComando.getAtributosAsociados();
		
		for (Atributo atributo : atributosAEliminar)
		{
			if (atributo.tieneRelaciones())
			{
				atributo.limpiarRelaciones();
				repositorioDeAtributos.save(atributo);
			}
		}
		
		for (Clase clase : clasesAEliminar)
		{
			repositorioDeClases.deleteById(clase.getId());
		}
	}
}
