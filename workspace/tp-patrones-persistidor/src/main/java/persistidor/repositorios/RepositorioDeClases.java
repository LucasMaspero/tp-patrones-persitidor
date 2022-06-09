package persistidor.repositorios;

import org.springframework.data.repository.CrudRepository;
import persistidor.entidades.Clase;

public interface RepositorioDeClases extends CrudRepository<Clase, Long>
{
}
