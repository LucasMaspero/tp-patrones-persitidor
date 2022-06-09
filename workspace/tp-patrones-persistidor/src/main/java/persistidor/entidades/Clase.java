package persistidor.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clase")
public class Clase
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_clase")
	private long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "clasePadre", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Atributo> atributos;
	
	@OneToMany(mappedBy = "clase")
	private List<Objeto> objetos;
	
	public Clase()
	{
	}
	
	public Clase(String nombre, List<Atributo> atributos)
	{
		this.nombre = nombre;
		this.atributos = atributos;
		
		for (Atributo atributo : atributos)
		{
			atributo.setClase(this);
		}
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public List<Atributo> getAtributos()
	{
		return atributos;
	}
	
	public long getId()
	{
		return id;
	}

	@Override
	public int hashCode()
	{
		final int prime=31;
		int result=1;
		result=prime*result+(int)(id^(id>>>32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Clase other=(Clase)obj;
		if(id!=other.id) return false;
		return true;
	}
}
