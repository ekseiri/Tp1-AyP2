package main;

import events.*;
import utils.PoissonSimulator;
import utils.PoissonSimulatorException;
import utils.io;

public class Main
{
	public static Servicio economico;
	public static Servicio completo;
	public static Servicio premium;
	public static Timeline timeline;
	public static final double horarioAtencion = 720;

	public static void main(String[] args)
	{
		generarServicios();
		proceso("Lunes");
		proceso("Martes");
		proceso("Miercoles");
		proceso("Jueves");
		proceso("Viernes");
		proceso("Sabado");
		imprimirResultados();

	}

	/**
	 * post : busca en archivo y genera los servicios.
	 */
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

	/**
	 * pre : debe recibir un objeto String indicando el día.
	 * post : se genera todo el proceso de la máquina de lavado correspondiente al día pasado por parámetro.
	 * @param dia
	 */
	static void proceso(String dia)
	{
		int[] aux;
		int clientesPromedio;
		MaquinaLavado mLavado = new MaquinaLavado();
		MaquinaEncerado mEncerado = new MaquinaEncerado();
		PoissonSimulator poisson = null; // me obligo eclipse a nullear
		Timeline timeline = new Timeline();
		Evento evento;
		SalidaDeMaquina salidaDeMaquina;
		Auto auto;
		aux = io.buscarEnArchivo(dia);
		clientesPromedio = aux[0];

		try
		{
			poisson = new PoissonSimulator(clientesPromedio, (int) horarioAtencion);
		}
		catch (PoissonSimulatorException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * post : genera la llegada del próximo auto.
		 */
		timeline.newEvent( new LlegadaAuto( new Auto( new Ticket( poisson.proximoArribo() ) ) ) );

		do
		{
			evento = timeline.nextEvento();
			if (evento.getClass() == LlegadaAuto.class)
			{
				/**
				 * post : encola un auto y sabemos cuando el próximo arribo.
				 */
				mLavado.encolarAuto(evento.getAuto());
				timeline.newEvent( new LlegadaAuto( new Auto( new Ticket( poisson.proximoArribo() )	) )	);
			}
			else
				if (evento.getClass() == SalidaDeCola.class)
				{

				}
				else
					if (evento.getClass() == SalidaDeMaquina.class){// realmente salida de maquina tiene significado en
																	// la
																	// maquina de lavado, porque salir de encerado es si
																	// o si fin de servicio
						
						salidaDeMaquina = (SalidaDeMaquina) evento; // esto no se si es asi
						auto = salidaDeMaquina.getMaquina().sacarAuto();

						if (auto.getTicket().getEncerado())
						{
							mEncerado.encolarAuto(auto);
						}
					}
			if (mLavado.estaVacia())
			{
				try
				{
					mLavado.nextAuto();
				}
				catch (NoHayAutosException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (mEncerado.estaVacia())
			{
				try
				{
					mEncerado.nextAuto();
				}
				catch (NoHayAutosException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		while (timeline.getHorarioActual() < horarioAtencion);

	}

	static void imprimirResultados()
	{
		System.out.println();
	}
}
