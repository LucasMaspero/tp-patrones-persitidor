package persistidor.comandos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;
import persistidor.entidades.Sesion;
import persistidor.servicios.IServicioDeSesiones;

@Component
public class InsertarEntidadObjetoAsociadaASesionComando implements IInsertarEntidadObjetoAsociadaASesionComando
{
	@Autowired
	private IServicioDeSesiones servicioDeSesiones;
	
	@Autowired
	private ICrearSesionSiNoExisteUObtenerSesionActualComando crearSesionSiNoExisteUObtenerSesionActualComando;
	
	@Autowired
	private ICrearEntidadObjetoDesdeUnObjectComando crearEntidadObjetoDesdeUnObjectComando;
	
	public void ejecutar(long idSesion, Object object)
	{
		Sesion sesionActual = crearSesionSiNoExisteUObtenerSesionActualComando.ejecutar(idSesion);
		
		Objeto entidadObjetoAInsertar = crearEntidadObjetoDesdeUnObjectComando.ejecutar(object);
		entidadObjetoAInsertar.setSesion(sesionActual);
		
		List<Objeto> objetosDeSesionActual = sesionActual.getObjetos();
		objetosDeSesionActual.add(entidadObjetoAInsertar);
		sesionActual.setObjetos(objetosDeSesionActual);
		
		servicioDeSesiones.actualizarSesion(sesionActual);
	}
}
