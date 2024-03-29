package persistidor.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valor")
public class Valor
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_valor")
	private long id;
	
	// A que objeto pertenece este valor de atributo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_objeto")
	private Objeto objetoPadre;
	
	// Si el valor es un objeto, que objeto es
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="id_objeto_valor")
	private Objeto valorObjeto;

	// Valor de que atributo es
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_atributo")
	private Atributo atributo;
	
	// Si el valor es primitivo, que valor tiene
	@Column(name="valor_primitivo")
	private String valorPrimitivo;
	
	public Valor()
	{
	}
	
	public Valor(String valorPrimitivo, Atributo atributo)
	{
		this.valorPrimitivo = valorPrimitivo;
		this.atributo = atributo;
	}
	
	public Valor(Objeto valorObjeto, Atributo atributo)
	{
		this.valorObjeto = valorObjeto;
		this.atributo = atributo;
	}

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
	
	public void setObjetoPadre(Objeto objetoPadre)
	{
		this.objetoPadre = objetoPadre;
	}

	public long getId()
	{
		return id;
	}
	
	public boolean tieneRelaciones()
	{
		return this.valorObjeto != null;
	}
	
	public void limpiarRelaciones()
	{
		this.valorObjeto = null;
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
		Valor other=(Valor)obj;
		if(id!=other.id) return false;
		return true;
	}
}
