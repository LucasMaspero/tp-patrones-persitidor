package persistidor.excepciones;

@SuppressWarnings("serial")
public class TipoOValorInvalidoException extends Exception
{
	public TipoOValorInvalidoException(String mensajeDeError)
	{
		super(mensajeDeError);
	}
}