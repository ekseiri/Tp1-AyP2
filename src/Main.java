import utils.io;

public class Main
{

	public static void main(String[] args)
	{
		generarServicios();
		
	}
	static void generarServicios()
	{
		int[] aux;
		
		aux = io.buscarEnArchivo("P");
		Proceso prelavado = new Proceso(aux[0],aux[1]);
		aux = io.buscarEnArchivo("LyE");
		Proceso lavadoYEnjuague = new Proceso(aux[0],aux[1]);
		aux = io.buscarEnArchivo("LL");
		Proceso lavadoDeLlantas = new Proceso(aux[0],aux[1]);
		aux = io.buscarEnArchivo("S");
		Proceso secadoAutomatico = new Proceso(aux[0],aux[1]);
		aux = io.buscarEnArchivo("B");
		Proceso brillo = new Proceso(aux[0],aux[1]);
		
		int tiempo;
		int costo;
		//economico
		tiempo=lavadoYEnjuague.getTiempo()+lavadoDeLlantas.getTiempo()+secadoAutomatico.getTiempo();
		costo=lavadoYEnjuague.getCosto()+lavadoDeLlantas.getCosto()+secadoAutomatico.getCosto();
		Servicio economico = new Servicio(tiempo,costo);
		//completo
		tiempo+=prelavado.getTiempo();
		costo+=prelavado.getCosto();
		Servicio completo = new Servicio(tiempo,costo);
		//premium
		tiempo+=brillo.getTiempo();
		costo+=brillo.getCosto();
		Servicio premium = new Servicio(tiempo,costo);
		
		prelavado=null;
		lavadoYEnjuague=null;
		lavadoDeLlantas=null;
		secadoAutomatico=null;
		brillo=null;
	}
}
