package persistidor.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sesion")
public class Sesion
{
	@Id
	@Column(name = "id_sesion")
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_acceso")
	private Date ultimoAcceso;
	
	// Los valores para los atributos de este objeto
	@OneToMany(mappedBy = "sesion", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Objeto> objetos;
	
	public Sesion()
	{
	}
	
	public Sesion(long idSesion)
	{
		this.id = idSesion;
		this.ultimoAcceso = new Date();
		this.objetos = new ArrayList<Objeto>();
	}

	public long getId()
	{
		return id;
	}

	public Date getUltimoAcceso()
	{
		return ultimoAcceso;
	}
	
	public void actualizarUltimoAcceso()
	{
		this.ultimoAcceso = new Date();
	}
	
	public List<Objeto> getObjetos()
	{
		return objetos;
	}

	public void setUltimoAcceso(Date ultimoAcceso)
	{
		this.ultimoAcceso = ultimoAcceso;
	}

	public void setObjetos(List<Objeto> objetos)
	{
		this.objetos = objetos;
	}
}