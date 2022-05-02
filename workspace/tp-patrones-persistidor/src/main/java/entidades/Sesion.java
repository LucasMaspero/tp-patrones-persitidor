package entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sesion")
public class Sesion
{
	@Id
	@Column(name="id_sesion")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ultimo_acceso")
    private Date ultimoAcceso;
	
	@OneToMany(mappedBy = "sesion")
	private List<Objeto> objetos;
}