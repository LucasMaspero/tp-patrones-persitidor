package persistidor.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.comandos.IObtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando;
import persistidor.entidades.Atributo;
import persistidor.entidades.Clase;
import persistidor.repositorios.IRepositorioDeAtributos;
import persistidor.repositorios.IRepositorioDeClases;

@Service
public class ServicioDeClases implements IServicioDeClases
{
	@Autowired
	private IRepositorioDeAtributos repositorioDeAtributos;
	
	@Autowired
	private IRepositorioDeClases repositorioDeClases;
	
	@Autowired
	private IObtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando;
	
	public boolean eliminarClasePorId(long idClase)
	{
		Clase clasePadre = repositorioDeClases.findById(idClase).orElse(null);
		
		if (clasePadre == null) return false;
		
		obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando.ejecutar(clasePadre);
		
		List<Clase> clasesAEliminar = obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando.getEntidadesClaseAsociadas();
		List<Atributo> atributosAEliminar = obtenerEntidadesClaseYEntidadesAtributoAsociadosAEntidadClaseComando.getEntidadesAtributoAsociadas();
		
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
		
		return true;
	}
}
