package principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidades.Objeto;
import entidades.Sesion;

@RestController
public class MiRestController
{
	@Autowired
	private EntityManager em;
	
	@RequestMapping("/clases")
	public Sesion obtenerClases()
	{
		String hql="SELECT * FROM sesion";
		
		Query q = em.createNativeQuery(hql);
		
		List<Sesion> lst = q.getResultList();
		
		return lst.get(0);
	}
}