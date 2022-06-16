package persistidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Sesion;
import persistidor.repositorios.IRepositorioDeSesiones;

@Service
public class ServicioDeSesiones implements IServicioDeSesiones
{
	@Autowired
	private IRepositorioDeSesiones repositorioDeSesiones;

	public Sesion obtenerSesionPorId(long idSesion)
	{
		return repositorioDeSesiones.findById(idSesion).orElse(null);
	}

	public void insertarSesion(Sesion sesion)
	{
		repositorioDeSesiones.save(sesion);
	}
	
	public void actualizarSesion(Sesion sesion)
	{
		long idSesion = sesion.getId();
		Sesion sesionDeLaBaseDeDatos = this.obtenerSesionPorId(idSesion);
		
		sesionDeLaBaseDeDatos.setObjetos(sesion.getObjetos());
		sesionDeLaBaseDeDatos.actualizarUltimoAcceso();

		repositorioDeSesiones.save(sesionDeLaBaseDeDatos);
	}

	public void actualizarUltimoAcceso(long idSesion)
	{
		Sesion sesionDeLaBaseDeDatos = this.obtenerSesionPorId(idSesion);
		
		sesionDeLaBaseDeDatos.actualizarUltimoAcceso();

		repositorioDeSesiones.save(sesionDeLaBaseDeDatos);
	}
	
	public boolean existeSesion(long idSesion)
	{
		return repositorioDeSesiones.existsById(idSesion);
	}
}
