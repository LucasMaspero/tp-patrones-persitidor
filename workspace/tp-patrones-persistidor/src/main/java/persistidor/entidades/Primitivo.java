package persistidor.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "primitivo")
public class Primitivo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_primitivo")
	private long id;
	
	@Column(name = "nombre")
	private String nombre;

	public String getNombre()
	{
		return nombre;
	}
}
