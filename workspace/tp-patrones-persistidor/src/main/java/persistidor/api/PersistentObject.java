package persistidor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.comandos.ActualizarObjetoEnLaDbComando;
import persistidor.comandos.InsertarObjetoAsociadoASesionComando;
import persistidor.comandos.EliminarObjetoDeClaseAsociadoASesionComando;
import persistidor.comandos.ExisteObjetoDeClaseAsociadoASesionComando;
import persistidor.comandos.ObtenerObjetoDeClaseAsociadoASesionComando;
import persistidor.comandos.ObtenerTiempoTranscurridoDeSesionComando;
import persistidor.excepciones.NoExisteSesionException;

@Component
public class PersistentObject
{
	@Autowired
	private InsertarObjetoAsociadoASesionComando insertarObjetoAsociadoASesionComando;
	
	@Autowired
	private ActualizarObjetoEnLaDbComando actualizarObjetoEnLaDbComando;
	
	@Autowired
	private ObtenerObjetoDeClaseAsociadoASesionComando obtenerObjetoDeClaseAsociadoASesionComando;
	
	@Autowired
	private ExisteObjetoDeClaseAsociadoASesionComando existeObjetoDeClaseAsociadoASesionComando;
	
	@Autowired
	private ObtenerTiempoTranscurridoDeSesionComando obtenerTiempoTranscurridoDeSesionComando;
	
	@Autowired
	private EliminarObjetoDeClaseAsociadoASesionComando eliminarObjetoDeClaseAsociadoASesionComando;
	
	// Almacena la instancia del objeto o asociada a la clave sId, 
	// o actualiza la instancia existente retornando true o false 
	// segun actualiza o almacena. 
	// El objeto o puede ser null, en tal caso el valor que se 
	// almacenara sera null.
	public boolean store(long sId, Object o)
	{
		Class<?> claseDelObjeto = o.getClass();
		
		try
		{
			if (existeObjetoDeClaseAsociadoASesionComando.Ejecutar(sId, claseDelObjeto))
			{
				actualizarObjetoEnLaDbComando.Ejecutar(sId, o);
				return true;
			}
			
			insertarObjetoAsociadoASesionComando.Ejecutar(sId, o);
		}
		catch(NoExisteSesionException ex)
		{
			insertarObjetoAsociadoASesionComando.Ejecutar(sId, o);
		}
		
		return false;
	}
	
	// Devuelve la instancia del objeto o asociada a la clave sId.
	public <T> T load(long sId, Class<T> clazz) throws NoExisteSesionException
	{
		return obtenerObjetoDeClaseAsociadoASesionComando.Ejecutar(sId, clazz);
	}
	
	// Retorna true o false según exista o un una instancia
	// de clazz (aunque sea null) asociada a la clave sId.
	public <T> boolean exists(long sId, Class<T> clazz) throws NoExisteSesionException
	{
		return existeObjetoDeClaseAsociadoASesionComando.Ejecutar(sId, clazz);
	}
	
	// Retorna (en milisegundos) el tiempo transcurrido 
	// desde el ultimo acceso registrado para la clave sId, 
	// sin considerar las llamadas a este metodo ni a exists.
	public long elapsedTime(long sId) throws NoExisteSesionException
	{
		return obtenerTiempoTranscurridoDeSesionComando.Ejecutar(sId);
	}
	
	// retorna y elimina la instancia de clazz vinculada a la
	// clave sId, o retorna null si no existe dicha instancia
	public <T> T delete(long sId, Class<T> clazz) throws NoExisteSesionException
	{
		return eliminarObjetoDeClaseAsociadoASesionComando.Ejecutar(sId, clazz);
	}
}
