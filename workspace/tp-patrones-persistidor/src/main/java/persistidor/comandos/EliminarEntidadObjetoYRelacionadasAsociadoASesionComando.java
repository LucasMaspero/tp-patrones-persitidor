package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;
import persistidor.excepciones.NoExisteSesionException;
import persistidor.servicios.IServicioDeClases;
import persistidor.servicios.IServicioDeObjetos;
import persistidor.servicios.IServicioDeSesiones;

@Component
public class EliminarEntidadObjetoYRelacionadasAsociadoASesionComando implements IEliminarEntidadObjetoYRelacionadasAsociadoASesionComando
{
	@Autowired
	private IServicioDeSesiones servicioDeSesiones;
	
	@Autowired
	private IServicioDeObjetos servicioDeObjetos;
	
	@Autowired
	private IServicioDeClases servicioDeClases;
	
	@Autowired
	private IObtenerEntidadObjetoAsociadoASesionComando obtenerEntidadObjetoAsociadoASesionComando;
	
	public <T> void ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException
	{
		Objeto entidadObjetoAEliminar = obtenerEntidadObjetoAsociadoASesionComando.ejecutar(idSesion, clazz);
		
		if (entidadObjetoAEliminar == null) return;
		
		long idClaseAEliminar = entidadObjetoAEliminar.getClase().getId();
		
		servicioDeObjetos.eliminarObjeto(entidadObjetoAEliminar, idSesion);
		servicioDeClases.eliminarClasePorId(idClaseAEliminar);
		servicioDeSesiones.actualizarUltimoAcceso(idSesion);
	}
}
