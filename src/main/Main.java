package main;

import utils.io;

public class Main
{
	public static Servicio economico;
	public static Servicio completo;
	public static Servicio premium;
	public static Timeline timeline;

	public static void main(String[] args)
	{
		generarServicios();
		imprimirResultados();

	}

	static void generarServicios()
	{
		int tiempo;
		int costo;
		int[] aux;

		aux = io.buscarEnArchivo("P");
		Proceso prelavado = new Proceso(aux[0], aux[1]);
		aux = io.buscarEnArchivo("LyE");
		Proceso lavadoYEnjuague = new Proceso(aux[0], aux[1]);
		aux = io.buscarEnArchivo("LL");
		Proceso lavadoDeLlantas = new Proceso(aux[0], aux[1]);
		aux = io.buscarEnArchivo("S");
		Proceso secadoAutomatico = new Proceso(aux[0], aux[1]);
		aux = io.buscarEnArchivo("B");
		Proceso brillo = new Proceso(aux[0], aux[1]);

		// economico
		tiempo = lavadoYEnjuague.getTiempo() + lavadoDeLlantas.getTiempo() + secadoAutomatico.getTiempo();
		costo = lavadoYEnjuague.getCosto() + lavadoDeLlantas.getCosto() + secadoAutomatico.getCosto();
		economico = new Servicio(tiempo, costo);
		// completo
		tiempo += prelavado.getTiempo();
		costo += prelavado.getCosto();
		completo = new Servicio(tiempo, costo);
		// premium
		tiempo += brillo.getTiempo();
		costo += brillo.getCosto();
		premium = new Servicio(tiempo, costo);

	}

	static void imprimirResultados()
	{
		System.out.println();
	}
}
