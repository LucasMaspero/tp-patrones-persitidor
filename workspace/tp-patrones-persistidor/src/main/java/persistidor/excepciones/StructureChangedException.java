package persistidor.excepciones;

@SuppressWarnings("serial")
public class StructureChangedException extends Exception
{
	public StructureChangedException(Exception innerException)
	{
		super("ERROR -> Cambio la estructura de la clase (StructureChangedException). Mas detalles del error: " + innerException.getMessage());
	}
}
