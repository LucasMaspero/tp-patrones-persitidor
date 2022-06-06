package persistidor.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "objeto")
public class Objeto
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_objeto")
	private long id;
	
	// A que sesion pertenece el objeto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sesion")
	private Sesion sesion;
	
	// De que clase es instancia este objeto
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_clase")
	private Clase clase;
	
	// Los valores para los atributos de este objeto
	@OneToMany(mappedBy = "objetoPadre", cascade = CascadeType.PERSIST)
	private List<Valor> valores;
	
	public Objeto()
	{
	}
	
	public Objeto(Clase clase, List<Valor> valores)
	{
		this.clase = clase;
		this.valores = valores;
		
		for (Valor valor : valores)
		{
			valor.setObjetoPadre(this);
		}
	}
	
	public Objeto(Clase clase, List<Valor> valores, Sesion sesion)
	{
		this.sesion = sesion;
		
		this.clase = clase;
		this.valores = valores;
		
		for (Valor valor : valores)
		{
			valor.setObjetoPadre(this);
		}
	}

	public Clase getClase()
	{
		return clase;
	}
	
	public List<Valor> getValores()
	{
		return valores;
	}
}
