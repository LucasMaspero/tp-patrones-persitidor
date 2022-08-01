package persistidor.comandos;

public interface IValidarTipoDeObjectComando
{
	/**
     * Valida si un object es apto para que el PersistenObject lo pueda persistir.
     * @param object Object a validar.
    **/
	boolean esValidoParaPersistirDirectamente(Object object);
}
