package entidades;

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
	private int id;
	
	// Si el valor es primitivo, que valor tiene
	@Column(name="valor_primitivo")
	private String valorPrimitivo;
	
	// Si el valor es un objeto, que objeto es
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_objeto_valor")
	private Objeto valorObjeto;
	
	// A que objeto pertenece este valor de atributo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_objeto")
	private Objeto objetoPadre;
	
	// Valor de que atributo es
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_atributo")
	private Atributo atributo;
}