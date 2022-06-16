package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Sesion;
import persistidor.servicios.IServicioDeSesiones;

@Component
public class CrearSesionSiNoExisteUObtenerSesionActualComando implements ICrearSesionSiNoExisteUObtenerSesionActualComando
{
	@Autowired
	private IServicioDeSesiones servicioDeSesiones;
	
	public Sesion ejecutar(long idSesion)
	{
		if (!servicioDeSesiones.existeSesion(idSesion))
		{
			Sesion nuevaSesion = new Sesion(idSesion);
			servicioDeSesiones.insertarSesion(nuevaSesion);
		}

		return servicioDeSesiones.obtenerSesionPorId(idSesion);
	}
}
