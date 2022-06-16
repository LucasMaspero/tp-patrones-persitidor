package persistidor.excepciones;

@SuppressWarnings("serial")
public class NoExisteSesionException extends Exception
{
	public NoExisteSesionException(String mensajeDeError)
	{
		super(mensajeDeError);
	}
}