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

	public void crearSesion(Sesion sesion)
	{
		repositorioDeSesiones.save(sesion);
	}

	public void actualizarSesion(Sesion sesion)
	{
		long idSesion = sesion.getId();
		Sesion sesionDeLaBaseDeDatos = this.obtenerSesionPorId(idSesion);
	}

	public void eliminarSesion(long idSesion)
	{
		repositorioDeSesiones.deleteById(idSesion);
	}
	
	public boolean existeSesion(long idSesion)
	{
		return repositorioDeSesiones.existsById(idSesion);
	}
}
