package persistidor.comandos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Clase;
import persistidor.entidades.Objeto;
import persistidor.entidades.Sesion;
import persistidor.excepciones.NoExisteSesionException;
import persistidor.servicios.ServicioDeSesiones;

@Component
public class ObtenerObjetoDeClaseAsociadoASesionComando
{
	@Autowired
	private ServicioDeSesiones servicioDeSesiones;
	
	@Autowired
	private ExisteObjetoDeClaseAsociadoASesionComando existeObjetoDeClaseAsociadoASesionComando;
	
	@Autowired
	private CrearObjectDesdeEntidadObjetoComando crearObjectDesdeEntidadObjetoComando;
	
	// Obtiene la instancia de tipo clazz para la sesion de ID idSesion.
	// 	* Si la sesion NO existe, tira excepcion.
	// 	* Si la sesion existe, pero NO tiene ninguna instancia del tipo clazz, devuelve null.
	// 	* Si la sesion existe, y tiene ninguna instancia del tipo clazz, la devuelve.
	public <T> T Ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException
	{
		if (!existeObjetoDeClaseAsociadoASesionComando.Ejecutar(idSesion, clazz))
		{
			// La sesion NO existe
			return null;
		}
		
		String nombreDeLaClaseABuscarSiExiste = clazz.getTypeName();
		
		Sesion sesionAsociada = servicioDeSesiones.obtenerSesionPorId(idSesion);
		
		List<Objeto> objetosDeSesion = sesionAsociada.getObjetos();
		
		for (Objeto objetoDeSesion : objetosDeSesion) 
        {
			Clase claseDelObjeto = objetoDeSesion.getClase();
			String nombreDeLaClaseDelObjeto = claseDelObjeto.getNombre();
            
			if (nombreDeLaClaseDelObjeto.equals(nombreDeLaClaseABuscarSiExiste))
            {
				// La sesion existe, y tiene ninguna instancia del tipo clazz
                return crearObjectDesdeEntidadObjetoComando.Ejecutar(objetoDeSesion);
            }
        }
		
		// La sesion existe, pero NO tiene ninguna instancia del tipo clazz.
		return null;
	}
}
