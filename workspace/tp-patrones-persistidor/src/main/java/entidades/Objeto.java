package entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="objeto")
public class Objeto
{
	@Id
	@Column(name="id_objeto")
	private int id;
	
	// A que sesion pertenece el objeto
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_sesion")
	private Sesion sesion;
	
	// De que clase es instancia este objeto
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_clase")
	private Clase clase;
	
	// Los valores para los atributos de este objeto
	@OneToMany(mappedBy = "valorObjeto")
	private List<Valor> valores;
}