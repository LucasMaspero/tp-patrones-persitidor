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
public class ExisteObjetoDeClaseAsociadoASesionComando
{
	@Autowired
	private ServicioDeSesiones servicioDeSesiones;
	
	// Chequea si existe alguna instancia de la clase clazz para la sesion de ID idSesion.
	// (Basicamente, esto da true siempre y cuando se haya persistido de forma directa algun objeto
	// de clase clazz con ese ID de sesion).
	public <T> boolean ejecutar(long idSesion, Class<T> clazz) throws NoExisteSesionException
	{
		if (!servicioDeSesiones.existeSesion(idSesion))
		{
			throw new NoExisteSesionException("No existe sesion de ID: " + idSesion);
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
                return true;
            }
        }
		
		return false;
	}
}
