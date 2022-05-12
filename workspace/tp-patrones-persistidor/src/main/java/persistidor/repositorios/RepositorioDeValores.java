package persistidor.repositorios;

import org.springframework.data.repository.CrudRepository;
import persistidor.entidades.Valor;

public interface RepositorioDeValores extends CrudRepository<Valor, Long>
{
}
