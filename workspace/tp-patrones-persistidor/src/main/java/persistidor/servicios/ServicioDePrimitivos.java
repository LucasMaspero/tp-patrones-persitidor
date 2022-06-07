package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Primitivo;
import persistidor.repositorios.RepositorioDePrimitivos;

@Service
public class ServicioDePrimitivos
{
	@Autowired
	private RepositorioDePrimitivos repositorioDePrimitivos;
	
	public Primitivo ObtenerPrimitivoPorNombre(String nombrePrimitivo)
	{
		return repositorioDePrimitivos.obtenerPrimitivoPorNombre(nombrePrimitivo);
	}
}