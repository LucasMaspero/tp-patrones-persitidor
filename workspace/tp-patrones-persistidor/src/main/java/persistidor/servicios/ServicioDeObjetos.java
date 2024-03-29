package persistidor.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.comandos.IObtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando;
import persistidor.entidades.Objeto;
import persistidor.entidades.Sesion;
import persistidor.entidades.Valor;
import persistidor.repositorios.IRepositorioDeObjetos;
import persistidor.repositorios.IRepositorioDeValores;

@Service
public class ServicioDeObjetos implements IServicioDeObjetos
{
	@Autowired
	private IRepositorioDeObjetos repositorioDeObjetos;
	
	@Autowired
	private IRepositorioDeValores repositorioDeValores;
	
	@Autowired
	private IServicioDeSesiones servicioDeSesiones;
	
	@Autowired
	private IObtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando;
	
	public void eliminarObjeto(Objeto objetoPadre, long idSesion)
	{
		obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando.ejecutar(objetoPadre);
		
		Sesion sesionAsociada = servicioDeSesiones.obtenerSesionPorId(idSesion);
		sesionAsociada.eliminarObjeto(objetoPadre);
		servicioDeSesiones.actualizarSesion(sesionAsociada);
		
		List<Objeto> objetosAEliminar = obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando.getEntidadesObjetoAsociadas();
		List<Valor> valoresAEliminar = obtenerEntidadesObjetoYEntidadesValorAsociadosAEntidadObjetoComando.getEntidadesValorAsociadas();
		
		for (Valor valor : valoresAEliminar)
		{
			if (valor.tieneRelaciones())
			{
				valor.limpiarRelaciones();
				repositorioDeValores.save(valor);
			}
		}
		
		for (Objeto objeto : objetosAEliminar)
		{
			objeto.limpiarRelaciones();
			repositorioDeObjetos.save(objeto);
			repositorioDeObjetos.deleteById(objeto.getId());
		}
	}
}
