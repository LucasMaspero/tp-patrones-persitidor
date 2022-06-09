package persistidor.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistidor.comandos.ObtenerObjetosYValoresAsociadosAObjetoComando;
import persistidor.entidades.Objeto;
import persistidor.entidades.Valor;
import persistidor.repositorios.RepositorioDeObjetos;
import persistidor.repositorios.RepositorioDeValores;

@Service
public class ServicioDeObjetos
{
	@Autowired
	private RepositorioDeObjetos repositorioDeObjetos;
	
	@Autowired
	private RepositorioDeValores repositorioDeValores;
	
	@Autowired
	private ObtenerObjetosYValoresAsociadosAObjetoComando obtenerObjetosYValoresAsociadosAObjetoComando;
	
	public void eliminarObjetoPorId(long idObjeto)
	{
		Objeto objetoPadre = repositorioDeObjetos.findById(idObjeto).orElse(null);
		
		if (objetoPadre == null) return;
		
		obtenerObjetosYValoresAsociadosAObjetoComando.ejecutar(objetoPadre);
		
		List<Objeto> objetosAEliminar = obtenerObjetosYValoresAsociadosAObjetoComando.getObjetosAsociados();
		List<Valor> valoresAEliminar = obtenerObjetosYValoresAsociadosAObjetoComando.getValoresAsociados();
		
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
