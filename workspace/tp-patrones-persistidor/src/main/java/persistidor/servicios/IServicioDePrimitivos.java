package persistidor.servicios;

import persistidor.entidades.Primitivo;

public interface IServicioDePrimitivos
{
	/**
     * Obtiene un primitivo por nombre.
     * @param nombre del primitivo a obtener.
    **/
	Primitivo ObtenerPrimitivoPorNombre(String nombrePrimitivo);
}
