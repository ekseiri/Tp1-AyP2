package events;

import main.Auto;

/**
 * Evento que marca la llegada de un auto al lavadero
 */
public class LlegadaAuto extends Evento {
    
    /**
     * El evento se inicializa con un Auto
     * @param auto
     */
    public LlegadaAuto(Auto auto) {
	super(auto);
	// TODO Auto-generated constructor stub
    }

    /**
     * Devuelve el horario de llegada del auto
     */
    public double getHorario() {
	return this.getAuto().getTicket().getHorario();
    }
}
