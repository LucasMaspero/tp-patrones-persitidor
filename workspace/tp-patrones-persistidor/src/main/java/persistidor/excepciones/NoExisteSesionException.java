package persistidor.excepciones;

public class NoExisteSesionException extends Exception
{
	public NoExisteSesionException(String mensajeDeError)
	{
		super(mensajeDeError);
	}
}