package persistidor.comandos;

public interface IObtenerValorPrimitivoCasteadoComando
{
	/**
     * Dado un nombre de un primitivo y un valor de un primitivo como string,
     * castea dicho valor al tipo de primitivo correspondiente.
     * @param nombrePrimitivo nombre del tipo de primitivo.
     * @param valorPrimitivo valor string del primitivo a castear.
    **/
	Object Ejecutar(String nombrePrimitivo, String valorPrimitivo);
}
