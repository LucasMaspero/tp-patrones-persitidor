package persistidor.comandos;

public interface IVerificarSiClaseEsUnPrimitivoComando
{
	/**
     * Verifica si la clase (tipo) representa un primitivo o un string.
     * @param clase Clase a verificar.
    **/
	boolean ejecutar(Class<?> clase);
}
