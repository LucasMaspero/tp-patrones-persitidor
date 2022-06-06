package persistidor.servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.entidades.Sesion;
import persistidor.repositorios.RepositorioDeSesiones;

@Service
public class ServicioDeSesiones
{
	@Autowired
	private RepositorioDeSesiones repositorioDeSesiones;

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
	
	public boolean existeSesion(long idSesion)
	{
		return repositorioDeSesiones.existsById(idSesion);
	}
}
