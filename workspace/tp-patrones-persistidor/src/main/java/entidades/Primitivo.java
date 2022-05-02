package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="primitivo")
public class Primitivo
{
	@Id
	@Column(name="id_primitivo")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
}