package persistidor.repositorios;

import org.springframework.data.repository.CrudRepository;
import persistidor.entidades.Primitivo;

public interface RepositorioDePrimitivos extends CrudRepository<Primitivo, Long>
{
}
