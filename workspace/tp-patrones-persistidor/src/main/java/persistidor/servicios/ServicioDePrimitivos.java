package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Primitivo;
import persistidor.repositorios.IRepositorioDePrimitivos;

@Service
public class ServicioDePrimitivos implements IServicioDePrimitivos
{
	@Autowired
	private IRepositorioDePrimitivos repositorioDePrimitivos;
	
	public Primitivo ObtenerPrimitivoPorNombre(String nombrePrimitivo)
	{
		String nombrePrimitivoNormalizado = nombrePrimitivo.toLowerCase();
		return repositorioDePrimitivos.obtenerPrimitivoPorNombre(nombrePrimitivoNormalizado);
	}
}
