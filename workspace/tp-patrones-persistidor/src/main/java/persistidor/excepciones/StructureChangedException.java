package persistidor.excepciones;

@SuppressWarnings("serial")
public class StructureChangedException extends Exception
{
	public StructureChangedException(String mensajeDeError)
	{
		super(mensajeDeError);
	}
}
