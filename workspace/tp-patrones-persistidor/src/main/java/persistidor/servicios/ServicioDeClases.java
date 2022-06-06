package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistidor.entidades.Clase;
import persistidor.repositorios.RepositorioDeClases;

@Service
public class ServicioDeClases
{
	@Autowired
	private RepositorioDeClases repositorioDeClases;

	public boolean crearClase(Clase Clase)
	{
		// TODO
		return false;
	}

	public void actualizarClase(Clase Clase)
	{
		// TODO
	}

	public void eliminarClase(long idClase)
	{
		// TODO
	}
}
