package persistidor.excepciones;

@SuppressWarnings("serial")
public class StructureChangedException extends Exception
{
	public StructureChangedException(Exception innerException)
	{
		super("ERROR -> Cambio la estructura de la clase. Mas detalles del error: " + innerException.getMessage());
	}
}
