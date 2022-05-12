package persistidor.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valor")
public class Valor
{
	@Id
	@Column(name="id_valor")
	private long id;
	
	// A que objeto pertenece este valor de atributo
	// NOTA: NO AGREGARLE GETTER A ESTO
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_objeto")
	private Objeto objetoPadre;
	
	// Si el valor es primitivo, que valor tiene
	@Column(name="valor_primitivo")
	private String valorPrimitivo;
	
	// Si el valor es un objeto, que objeto es
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_objeto_valor")
	private Objeto valorObjeto;

	// Valor de que atributo es
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_atributo")
	private Atributo atributo;

	public String getValorPrimitivo()
	{
		return valorPrimitivo;
	}

	public Objeto getValorObjeto()
	{
		return valorObjeto;
	}

	public Atributo getAtributo()
	{
		return atributo;
	}
}