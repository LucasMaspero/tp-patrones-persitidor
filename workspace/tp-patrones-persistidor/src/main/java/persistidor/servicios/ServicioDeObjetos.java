package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Objeto;
import persistidor.repositorios.RepositorioDeObjetos;

@Service
public class ServicioDeObjetos
{
	@Autowired
	private RepositorioDeObjetos repositorioDeObjetos;

	public boolean crearObjeto(Objeto Objeto)
	{
		// TODO
		return false;
	}

	public void actualizarObjeto(Objeto Objeto)
	{
		// TODO
	}

	public void eliminarObjeto(long idObjeto)
	{
		// TODO
	}
}