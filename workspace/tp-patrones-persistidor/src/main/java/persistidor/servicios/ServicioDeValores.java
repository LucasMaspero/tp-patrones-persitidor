package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Valor;
import persistidor.repositorios.RepositorioDeValores;

@Service
public class ServicioDeValores
{
	@Autowired
	private RepositorioDeValores repositorioDeValores;

	public boolean crearValor(Valor Valor)
	{
		// TODO
		return false;
	}

	public void actualizarValor(Valor Valor)
	{
		// TODO
	}

	public void eliminarValor(long idValor)
	{
		// TODO
	}
}
