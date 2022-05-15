package persistidor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.comandos.ActualizarObjetoEnLaDbComando;
import persistidor.comandos.CrearObjetoEnLaDbComando;
import persistidor.comandos.EliminarInstanciaDeLaClaseParaSesionComando;
import persistidor.comandos.ExisteInstanciaDeClaseParaSesionComando;
import persistidor.comandos.ExisteObjetoEnLaDbComando;
import persistidor.comandos.ObtenerInstanciaDeClaseParaSesionComando;
import persistidor.comandos.ObtenerTiempoTranscurridoDeSesionComando;

@Component
public class PersistentObject
{
	@Autowired
	private CrearObjetoEnLaDbComando crearObjetoEnLaDbComando;
	
	@Autowired
	private ExisteObjetoEnLaDbComando existeObjetoEnLaDbComando;
	
	@Autowired
	private ActualizarObjetoEnLaDbComando actualizarObjetoEnLaDbComando;
	
	@Autowired
	private ObtenerInstanciaDeClaseParaSesionComando obtenerInstanciaDeClaseParaSesionComando;
	
	@Autowired
	private ExisteInstanciaDeClaseParaSesionComando existeInstanciaDeClaseParaSesionComando;
	
	@Autowired
	private ObtenerTiempoTranscurridoDeSesionComando obtenerTiempoTranscurridoDeSesionComando;
	
	@Autowired
	private EliminarInstanciaDeLaClaseParaSesionComando eliminarInstanciaDeLaClaseParaSesionComando;
	
	// Almacena la instancia del objeto o asociada a la clave sId, 
	// o actualiza la instancia existente retornando true o false 
	// segun actualiza o almacena. 
	// El objeto o puede ser null, en tal caso el valor que se 
	// almacenara sera null.
	public boolean store(long sId, Object o)
	{
		if (existeObjetoEnLaDbComando.Ejecutar(sId, o))
		{
			actualizarObjetoEnLaDbComando.Ejecutar(sId, o);
			return true;
		}
		
		crearObjetoEnLaDbComando.Ejecutar(sId, o);
		return false;
	}
	
	// Devuelve la instancia del objeto o asociada a la clave sId.
	public <T> T load(long sId, Class<T> clazz)
	{
		return obtenerInstanciaDeClaseParaSesionComando.Ejecutar(sId, clazz);
	}
	
	// Retorna true o false según exista o un una instancia
	// de clazz (aunque sea null) asociada a la clave sId.
	public <T> boolean exists(long sId, Class<T> clazz)
	{
		return existeInstanciaDeClaseParaSesionComando.Ejecutar(sId, clazz);
	}
	
	// Retorna (en milisegundos) el tiempo transcurrido 
	// desde el ultimo acceso registrado para la clave sId, 
	// sin considerar las llamadas a este metodo ni a exists.
	public long elapsedTime(long sId)
	{
		return obtenerTiempoTranscurridoDeSesionComando.Ejecutar(sId);
	}
	
	// retorna y elimina la instancia de clazz vinculada a la
	// clave sId, o retorna null si no existe dicha instancia
	public <T> T delete(long sId, Class<T> clazz)
	{
		T instancia = obtenerInstanciaDeClaseParaSesionComando.Ejecutar(sId, clazz);
		
		eliminarInstanciaDeLaClaseParaSesionComando.Ejecutar(sId, clazz);
		
		return instancia;
	}
}
