package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Sesion;
import persistidor.servicios.ServicioDeSesiones;

@Component
public class ActualizarUltimoAccesoDeSesionComando
{
	@Autowired
	private ServicioDeSesiones servicioDeSesiones;
	
	public void Ejecutar(long idSesion)
	{
		Sesion sesionExistente = servicioDeSesiones.obtenerSesionPorId(idSesion);
		sesionExistente.actualizarUltimoAcceso();
		servicioDeSesiones.actualizarSesion(sesionExistente);
	}
}