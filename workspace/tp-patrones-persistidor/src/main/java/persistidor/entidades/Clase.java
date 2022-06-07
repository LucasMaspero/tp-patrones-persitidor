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
	
	@OneToMany(mappedBy = "clasePadre", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Atributo> atributos;
	
	@OneToMany()
	private List<Objeto> objetos;
	
	public String getNombre()
	{
		return nombre;
	}
	
	public List<Atributo> getAtributos()
	{
		return atributos;
	}
	
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
}
