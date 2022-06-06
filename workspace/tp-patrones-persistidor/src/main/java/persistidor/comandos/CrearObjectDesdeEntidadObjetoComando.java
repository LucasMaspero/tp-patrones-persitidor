package persistidor.comandos;

import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;

//La hacen mis compañeros
@Component
public class CrearObjectDesdeEntidadObjetoComando
{
	// Crea un objeto de tipo T a partir de una entidad objeto
	// TIRA StructureChangedException SI CAMBIO ALGO !!
	public <T> T Ejecutar(Objeto o)
	{
		// TO DO
		return null;
	}
}
