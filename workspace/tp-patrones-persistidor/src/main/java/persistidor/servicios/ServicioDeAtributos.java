package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistidor.entidades.Atributo;
import persistidor.repositorios.RepositorioDeAtributos;

@Service
public class ServicioDeAtributos
{
	@Autowired
	private RepositorioDeAtributos repositorioDeAtributos;

	public boolean crearAtributo(Atributo Atributo)
	{
		// TODO
		return false;
	}

	public void actualizarAtributo(Atributo Atributo)
	{
		// TODO
	}

	public void eliminarAtributo(long idAtributo)
	{
		// TODO
	}
}
