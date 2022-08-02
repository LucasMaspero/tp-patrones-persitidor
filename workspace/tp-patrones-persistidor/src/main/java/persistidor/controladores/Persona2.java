package persistidor.controladores;

import java.util.ArrayList;

import persistidor.anotaciones.Persistable;

@Persistable
public class Persona2
{
	private int dni;
	private String nombre;
	private ArrayList<String> telefonos;
	
	public Persona2()
	{
	}
	
	public Persona2(int dni,String nombre,ArrayList<String> telefonos)
	{
		this.dni=dni;
		this.nombre=nombre;
		this.telefonos=telefonos;
	}

	public ArrayList<String> getTelefonos()
	{
		return telefonos;
	}
	public void setTelefonos(ArrayList<String> telefonos)
	{
		this.telefonos=telefonos;
	}
	public int getDni()
	{
		return dni;
	}
	public void setDni(int dni)
	{
		this.dni=dni;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
}
