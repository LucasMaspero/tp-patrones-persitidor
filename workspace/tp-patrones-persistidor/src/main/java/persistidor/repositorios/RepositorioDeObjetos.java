package persistidor.repositorios;

import org.springframework.data.repository.CrudRepository;
import persistidor.entidades.Objeto;

public interface RepositorioDeObjetos extends CrudRepository<Objeto, Long>
{
}
