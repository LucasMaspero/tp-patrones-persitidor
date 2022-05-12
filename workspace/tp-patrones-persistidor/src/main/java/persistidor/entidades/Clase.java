package persistidor.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clase")
public class Clase
{
	@Id
	@Column(name="id_clase")
	private long id;
	
	private String nombre;
	
	// Atributos de la clase
	@OneToMany(mappedBy = "clasePadre")
	private List<Atributo> atributos;
	
	public String getNombre()
	{
		return nombre;
	}
	
	public List<Atributo> getAtributos()
	{
		return atributos;
	}	
}