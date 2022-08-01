package persistidor.excepciones;

@SuppressWarnings("serial")
public class NadaQuePersistirException extends Exception
{
	public NadaQuePersistirException(String mensajeDeError)
	{
		super(mensajeDeError);
	}
}