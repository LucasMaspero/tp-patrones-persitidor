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
@Table(name = "atributo")
public class Atributo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_atributo")
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "es_coleccion")
	private Boolean esColeccion;
	
	// A que clase pertenece el atributo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clase")
	private Clase clasePadre;
	
	// Si el atributo es NO primitivo, de que tipo clase es
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_tipo_clase")
	private Clase tipoClase;
	
	// Si el atributo es primitivo, que primitivo es
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_primitivo")
	private Primitivo tipoPrimitivo;
	
	public Atributo()
	{
	}
	
	public Atributo(String nombre, Clase tipoClase, Boolean esColeccion)
	{
		this.nombre = nombre;
		this.esColeccion = esColeccion;
		this.tipoClase = tipoClase;
	}
	
	public Atributo(String nombre, Primitivo tipoPrimitivo, Boolean esColeccion)
	{
		this.nombre = nombre;
		this.esColeccion = esColeccion;
		this.tipoPrimitivo = tipoPrimitivo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public Boolean esColeccion()
	{
		return esColeccion;
	}

	public Clase getTipoClase()
	{
		return tipoClase;
	}

	public Primitivo getTipoPrimitivo()
	{
		return tipoPrimitivo;
	}
	
	public void setClase(Clase clasePadre)
	{
		this.clasePadre = clasePadre;
	}

	public long getId()
	{
		return id;
	}
	
	public void limpiarRelaciones()
	{
		this.tipoClase = null;
	}
	
	public boolean tieneRelaciones()
	{
		return this.tipoClase != null;
	}
	
	public boolean esPrimitivo()
	{
		return tipoPrimitivo != null;
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
		Atributo other=(Atributo)obj;
		if(id!=other.id) return false;
		return true;
	}
}
