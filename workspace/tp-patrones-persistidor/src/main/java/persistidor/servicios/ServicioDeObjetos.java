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

	public void insertarObjeto(Objeto objeto)
	{
		repositorioDeObjetos.save(objeto);
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
