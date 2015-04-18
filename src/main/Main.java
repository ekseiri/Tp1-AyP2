package main;

import events.LlegadaAuto;
import utils.PoissonSimulator;
import utils.PoissonSimulatorException;
import utils.io;

public class Main
{
	public static Servicio economico;
	public static Servicio completo;
	public static Servicio premium;
	public static Timeline timeline;
	public static final int horarioAtencion = 720;

	public static void main(String[] args)
	{
		generarServicios();
		proceso("Lunes");
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

	static void proceso(String dia)
	{
		int[] aux;
		int clientesPromedio;
		MaquinaLavado mLavado = new MaquinaLavado();
		MaquinaEncerado mEncerado = new MaquinaEncerado();
		PoissonSimulator poisson = null; //me obligo eclipse a nullear
		Timeline timeline = new Timeline();
		aux = io.buscarEnArchivo(dia);
		clientesPromedio = aux[0];
		try
		{
			poisson = new PoissonSimulator(clientesPromedio, horarioAtencion);
		}
		catch (PoissonSimulatorException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do
		{
			timeline.newEvent(new LlegadaAuto(new Auto(new Ticket(poisson.proximoArribo()))));
			
		}
		while (timeline.getHorarioActual() < horarioAtencion);

	}

	static void imprimirResultados()
	{
		System.out.println();
	}
}
