package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Sesion;
import persistidor.repositorios.RepositorioDeSesiones;

@Service
public class ServicioDeSesiones
{
	@Autowired
	private RepositorioDeSesiones repositorioDeSesiones;

	public Sesion obtenerSesionPorId(long idSesion)
	{
		return repositorioDeSesiones.findById(idSesion).orElse(null);
	}

	public boolean crearSesion(Sesion Sesion)
	{
		// TODO
		return false;
	}

	public void actualizarSesion(Sesion Sesion)
	{
		// TODO
	}

	public void eliminarSesion(long idSesion)
	{
		// TODO
	}
}