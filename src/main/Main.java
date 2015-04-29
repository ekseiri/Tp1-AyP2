package main;

import events.*;
import utils.PoissonSimulator;
import utils.PoissonSimulatorException;
import utils.io;

public class Main {
    public static Servicio economico;
    public static Servicio completo;
    public static Servicio premium;
    public static Servicio encerado;
    public static Timeline timeline  = new Timeline();
    public static Stats statsContainer  = new Stats();
    public static final double horarioAtencion = 720;

    public static void main(String[] args) {
	
	generarServicios();
	proceso("Lunes");
	imprimirResultados("Lunes");
	proceso("Martes");
	imprimirResultados("Martes");
	proceso("Miercoles");
	imprimirResultados("Miercoles");
	proceso("Jueves");
	imprimirResultados("Jueves");
	proceso("Viernes");
	imprimirResultados("Viernes");
	proceso("Sabado");
	imprimirResultados("Sabado");

    }

    /**
     * post : busca en archivo y genera los servicios.
     */
    private static void generarServicios() {
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
	aux = io.buscarEnArchivo("E");
	encerado = new Servicio(aux[0], aux[1]);

	// economico
	tiempo = lavadoYEnjuague.getTiempo() + lavadoDeLlantas.getTiempo()
		+ secadoAutomatico.getTiempo();
	costo = lavadoYEnjuague.getCosto() + lavadoDeLlantas.getCosto()
		+ secadoAutomatico.getCosto();
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
     * pre : debe recibir un objeto String indicando el día. post : se simula
     * todo el trabajo correspondiente al día pasado por parámetro.
     * 
     * @param dia
     */
    private static void proceso(String dia) {
	int[] aux;
	int clientesPromedio;
	Maquina maquina = null;
	MaquinaLavado maquinaLavado = new MaquinaLavado();
	MaquinaEncerado maquinaEncerado = new MaquinaEncerado();
	PoissonSimulator poisson = null;
	Evento evento;

	aux = io.buscarEnArchivo(dia);
	clientesPromedio = aux[0];

	try {
	    poisson = new PoissonSimulator(clientesPromedio,
		    (int) horarioAtencion);
	} catch (PoissonSimulatorException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	/**
	 * post : genera la llegada del próximo auto.
	 */
	Main.timeline.newEvento(new LlegadaAuto(new Auto(new Ticket(poisson
		.proximoArribo()))));

	do {
	    evento = Main.timeline.getNextEvento();

	    if (evento.getClass() == LlegadaAuto.class) {
		
		/*
		double h = Main.timeline.getHorarioActual();
		double p = poisson.proximoArribo();
		Ticket ticket = new Ticket(h + p);
		Auto auto = new Auto(ticket);
		Evento e = new LlegadaAuto(auto);
		Main.timeline.newEvent(e);
		*/
		
		statsContainer.addServicio(evento.getAuto().getTicket().getTipoServicio());
		if (evento.getAuto().getTicket().getEncerado()){statsContainer.addServicio(TipoDeServicio.ENCERADO);}
		
		//if (evento.getAuto().getTicket().getTipoServicio()==TipoDeServicio.ECONOMICO){statsContainer.addServicio(TipoDeServicio.ECONOMICO);}
		//if (evento.getAuto().getTicket().getTipoServicio()==TipoDeServicio.COMPLETO){statsContainer.addServicio(TipoDeServicio.COMPLETO);}
		//if (evento.getAuto().getTicket().getTipoServicio()==TipoDeServicio.PREMIUM){statsContainer.addServicio(TipoDeServicio.PREMIUM);}
		//if (evento.getAuto().getTicket().getEncerado()){statsContainer.addServicio(TipoDeServicio.ENCERADO);}
		
		if (timeline.getHorarioActual() <= Main.horarioAtencion) {
		    Main.timeline.newEvento(new LlegadaAuto(new Auto(new Ticket(
			Main.timeline.getHorarioActual() + poisson.proximoArribo()))));
		}
		
		statsContainer.addLongitudDeCola(maquinaLavado);
		
		// post : encola el auto y sabemos cuando el próximo arribo.
		maquinaLavado.encolarAuto(evento.getAuto());
		

		// Si la maquina de lavado se encuentra vacia, se ingresa el
		// auto
		if (maquinaLavado.estaVacia()) {
		    Main.timeline.newEvento(new SalidaDeCola(evento.getAuto(),
			    maquinaLavado));

		}

	    } else if (evento.getClass() == SalidaDeCola.class) {
		maquina = ((SalidaDeCola) evento).getMaquina();
		statsContainer.addLongitudDeCola(maquina);
		try {
		    maquina.nextAuto();
		    
		    Main.timeline.newEvento(new SalidaDeMaquina(evento.getAuto(),
			    maquina));
		} catch (NoHayAutosException e) {}

	    } else if (evento.getClass() == SalidaDeMaquina.class) {
		maquina = ((SalidaDeMaquina) evento).getMaquina();
		
		if (maquina.getClass()==MaquinaLavado.class){
		    statsContainer.addTiempoEnCola(maquina.getAuto().getTicket().getTipoServicio(),((MaquinaLavado)maquina).getTiempoEnCola());
		} 
		
		
		if (((SalidaDeMaquina) evento).esFinDeServicio()) {
		    maquina.sacarAuto();
		    if (!maquina.getCola().colaVacia()) {
			Main.timeline.newEvento(new SalidaDeCola(evento.getAuto(),
				maquina));
		    }
		}

		else if (evento.getAuto().getTicket().getEncerado()) {
		    
		    maquinaEncerado.encolarAuto(maquina.sacarAuto());

		    if (maquinaEncerado.estaVacia()) {
			Main.timeline.newEvento(new SalidaDeCola(evento.getAuto(),
				maquinaEncerado));
		    }
		    
		}

	    }
	} while (! timeline.finDelDia());
	
	statsContainer.setTiempoTrabajado(timeline.getHorarioActual());
	timeline.reset();
    }

    private static void imprimirResultados(String dia) {
	System.out.println("Resultados para el d�a "+ dia + ":");
	System.out.println();
	statsContainer.printCostoPorDiaYPorServicio();
	statsContainer.printPromedioGeneralDeEspera();
	statsContainer.printLongitudPromedioColas();
	
	statsContainer.resetStats();
    }
    
}
