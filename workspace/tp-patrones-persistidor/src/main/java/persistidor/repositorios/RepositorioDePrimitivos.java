package persistidor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import persistidor.entidades.Primitivo;

public interface RepositorioDePrimitivos extends JpaRepository<Primitivo, Long>
{
	@Query(nativeQuery = true, value = "SELECT * from Primitivo p where p.nombre = :nombre LIMIT 1")
	Primitivo obtenerPrimitivoPorNombre(@Param("nombre") String nombre);
}
