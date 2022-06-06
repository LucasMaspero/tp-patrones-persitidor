package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;
import persistidor.entidades.Sesion;
import persistidor.servicios.ServicioDeSesiones;

@Component
public class InsertarObjetoAsociadoASesionComando
{
	@Autowired
	private ServicioDeSesiones servicioDeSesiones;
	
	@Autowired
	private CrearSesionSiNoExisteUObtenerSesionActualComando crearSesionSiNoExisteUObtenerSesionActualComando;
	
	@Autowired
	private ActualizarUltimoAccesoDeSesionComando actualizarUltimoAccesoDeSesionComando;
	
	@Autowired
	private CrearEntidadObjetoDesdeUnObjectComando crearEntidadObjetoDesdeUnObjectComando;
	
	public void Ejecutar(long idSesion, Object o)
	{
		Sesion sesionActual = crearSesionSiNoExisteUObtenerSesionActualComando.Ejecutar(idSesion);
		
		Objeto objetoAInsertar = crearEntidadObjetoDesdeUnObjectComando.Ejecutar(o, sesionActual);
		
		//servicioDeObjetos.insertarObjeto(objetoAInsertar);
		
		actualizarUltimoAccesoDeSesionComando.Ejecutar(idSesion);
	}
}
