package persistidor.comandos;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Sesion;
import persistidor.excepciones.NoExisteSesionException;
import persistidor.servicios.IServicioDeSesiones;

@Component
public class ObtenerTiempoTranscurridoDeSesionComando implements IObtenerTiempoTranscurridoDeSesionComando
{
	@Autowired
	private IServicioDeSesiones servicioDeSesiones;
	
	public long ejecutar(long idSesion) throws NoExisteSesionException
	{
		if (!servicioDeSesiones.existeSesion(idSesion))
		{
			throw new NoExisteSesionException("No existe sesion de ID: " + idSesion);
		}
		
		Sesion sesionAsociada = servicioDeSesiones.obtenerSesionPorId(idSesion);
		
		Date ahora = new Date();
		Date ultimoAccesoASesion = sesionAsociada.getUltimoAcceso();
		
		return ahora.getTime() - ultimoAccesoASesion.getTime();
	}
}
