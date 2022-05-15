package persistidor.comandos;

import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;

@Component
public class CrearEntidadObjetoDesdeUnObjectComando
{
	// Crea una entidad objeto a partir de un object
	public Objeto Ejecutar(Object o)
	{
		// Si la clase del objeto o (o la propiedad) tiene la anottation Persistable,
		// asegurarse de cargarla en el "Objeto"
		
		// Si la clase del objeto o (o la propiedad) tiene la anottation NotPersistable,
		// asegurarse de NO cargarla en el "Objeto"
		
		// TO DO
		return null;
	}
}
