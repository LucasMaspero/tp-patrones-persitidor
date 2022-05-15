package persistidor.controladores;

public class Direccion
{
	private String calle;
	private int numbero;
	private String codigoPostal;
	private String localidad;
	private String provincia;
	private String pais;
	
	public Direccion(String calle, int numbero, String codigoPostal, String localidad, String provincia, String pais)
	{
		this.calle = calle;
		this.numbero = numbero;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public String getCalle()
	{
		return calle;
	}

	public void setCalle(String calle)
	{
		this.calle = calle;
	}

	public int getNumbero()
	{
		return numbero;
	}

	public void setNumbero(int numbero)
	{
		this.numbero = numbero;
	}

	public String getCodigoPostal()
	{
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal)
	{
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad()
	{
		return localidad;
	}

	public void setLocalidad(String localidad)
	{
		this.localidad = localidad;
	}

	public String getProvincia()
	{
		return provincia;
	}

	public void setProvincia(String provincia)
	{
		this.provincia = provincia;
	}

	public String getPais()
	{
		return pais;
	}

	public void setPais(String pais)
	{
		this.pais = pais;
	}
}