package entidades;

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
	private int id;

	@Column(name="nombre")
	private String nombre;
	
	// Instancias de la clase
	@OneToMany(mappedBy = "clase")
	private List<Objeto> objetos;
	
	// Atributos de la clase
	@OneToMany(mappedBy = "clasePadre")
	private List<Atributo> atributos;
}
