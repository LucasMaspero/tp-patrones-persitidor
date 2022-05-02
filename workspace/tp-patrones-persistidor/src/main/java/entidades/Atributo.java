package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="atributo")
public class Atributo
{
	@Id
	@Column(name="id_atributo")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="es_coleccion")
	private Boolean esColeccion;
	
	// A que clase pertenece el atributo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_clase")
	private Clase clasePadre;
	
	// Si el atributo es NO primitivo, de que tipo clase es
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_clase")
	private Clase tipoClase;
	
	// Si el atributo es primitivo, que primitivo es
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_primitivo")
	private Primitivo tipoPrimitivo;
}