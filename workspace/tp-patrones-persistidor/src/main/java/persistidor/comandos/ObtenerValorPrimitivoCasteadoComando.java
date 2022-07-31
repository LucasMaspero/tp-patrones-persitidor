package persistidor.comandos;

import org.springframework.stereotype.Component;

@Component
public class ObtenerValorPrimitivoCasteadoComando implements IObtenerValorPrimitivoCasteadoComando
{
	public Object Ejecutar(String nombrePrimitivo, String valorPrimitivo)
	{
		switch(nombrePrimitivo.toLowerCase()) 
		{
			case "string":
				return valorPrimitivo;
			case "int":
				return Integer.parseInt(valorPrimitivo);
			case "byte":
				return Byte.parseByte(valorPrimitivo);
			case "short":
				return Short.parseShort(valorPrimitivo);
			case "long":
				return Long.parseLong(valorPrimitivo);
			case "float":
				return Float.parseFloat(valorPrimitivo);
			case "double":
				return Double.parseDouble(valorPrimitivo);
			case "char":
				return valorPrimitivo.charAt(0);
			case "boolean":
				return Boolean.parseBoolean(valorPrimitivo);
		}
		
		return null;
	}
}
