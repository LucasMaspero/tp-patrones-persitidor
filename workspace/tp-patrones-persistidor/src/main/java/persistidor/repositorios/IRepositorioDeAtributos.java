package persistidor.repositorios;

import org.springframework.data.repository.CrudRepository;
import persistidor.entidades.Atributo;

public interface IRepositorioDeAtributos extends CrudRepository<Atributo, Long>
{
}
