package persistidor.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sesion")
public class Sesion
{
	@Id
	@Column(name="id_sesion")
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ultimo_acceso")
	private Date ultimoAcceso;
	
	// Los valores para los atributos de este objeto
	@OneToMany(mappedBy = "sesion")
	private List<Objeto> objetos;

	public long getId()
	{
		return id;
	}

	public Date getUltimoAcceso()
	{
		return ultimoAcceso;
	}
	
	public List<Objeto> getObjetos()
	{
		return objetos;
	}
}