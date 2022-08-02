package persistidor.controladores;

import java.util.ArrayList;
import persistidor.anotaciones.NotPersistable;
import persistidor.anotaciones.Persistable;

@Persistable
public class Persona4
{
	private int dni;
	private String nombre;
	private ArrayList<String> telefonos;
	private Direccion laMejorDireccion;
	private ArrayList<Direccion> direcciones;

	public Persona4()
	{
	}
	
	public Persona4(int dni, String nombre, ArrayList<String> telefonos, Direccion laMejorDireccion, ArrayList<Direccion> direcciones)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.telefonos = telefonos;
		this.laMejorDireccion = laMejorDireccion;
		this.direcciones = direcciones;
	}

	public int getDni()
	{
		return dni;
	}

	public void setDni(int dni)
	{
		this.dni = dni;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public ArrayList<String> getTelefonos()
	{
		return telefonos;
	}

	public void setTelefonos(ArrayList<String> telefonos)
	{
		this.telefonos = telefonos;
	}

	public Direccion getLaMejorDireccion()
	{
		return laMejorDireccion;
	}

	public void setLaMejorDireccion(Direccion laMejorDireccion)
	{
		this.laMejorDireccion = laMejorDireccion;
	}

	public ArrayList<Direccion> getDirecciones()
	{
		return direcciones;
	}

	public void setDirecciones(ArrayList<Direccion> direcciones)
	{
		this.direcciones = direcciones;
	}

	@Override
	public String toString()
	{
		return "Persona [dni="+dni+", nombre="+nombre+", telefonos="+telefonos+", laMejorDireccion="+laMejorDireccion+", direcciones="+direcciones+"]";
	}
}