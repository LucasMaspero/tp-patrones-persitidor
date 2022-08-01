package persistidor.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistidor.entidades.Objeto;
import java.util.ArrayList;
import java.util.List;
import persistidor.entidades.Clase;
import persistidor.entidades.Valor;
import persistidor.excepciones.TipoOValorInvalidoException;

@Component
public class CrearEntidadObjetoDesdeUnObjectComando implements ICrearEntidadObjetoDesdeUnObjectComando
{
	@Autowired
	private ICrearEntidadClaseDesdeClassComando crearEntidadClaseDesdeClassComando;
	
	public Objeto ejecutar(Object o) throws TipoOValorInvalidoException
	{
		Class clase = o.getClass();
		Clase entidadClase = crearEntidadClaseDesdeClassComando.ejecutar(clase);
		
		List<Valor> entidadesValores = new ArrayList<Valor>();
		
		return new Objeto(entidadClase, entidadesValores);
	}
}
