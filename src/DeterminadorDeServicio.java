
public class DeterminadorDeServicio {
	
	/**
	 * Determina el tipo de servicio que va a requerir el auto de acuerdo al
	 * porcentaje de ocurrencia de cada uno.<br>
	 * 50% Economico<br>
	 * 30% Completo<br>
	 * 20% Premium<br>
	 * 
	 * @return TipoDeServicio 
	 */
	public static TipoDeServicio getServicio(){
		double posicion = Math.random();
		
		if (posicion >= 0.5) {
			return TipoDeServicio.ECONOMICO;
		} else if (posicion >= 0.3) {
			return TipoDeServicio.COMPLETO;
		} else {
			return TipoDeServicio.PREMIUM;
		}
	}
	
	/**
	 * Determina si el auto realiza Encerado, de acuerdo a una posibilidad del
	 * 50%
	 * 
	 * @return true si encera
	 */
	public static boolean getEncerrado(){
		return (Math.random() >= 0.5);
	}
	
}
