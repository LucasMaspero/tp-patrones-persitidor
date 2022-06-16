package persistidor.repositorios;

import org.springframework.data.repository.CrudRepository;
import persistidor.entidades.Valor;

public interface IRepositorioDeValores extends CrudRepository<Valor, Long>
{
}
