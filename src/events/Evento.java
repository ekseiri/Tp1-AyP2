package events;

import main.Auto;

/**
 * Superclass abstracta de la cual heredan los demas eventos
 *
 */
public abstract class Evento {
    private Auto auto;
    
    /**
     * El evento se inicializa con un Auto
     * @param auto
     */
    public Evento(Auto auto) {
	try {
	    this.auto = auto;
	} catch (NullPointerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    /**
     * Debe devolver el horario en el cual se produjo el evento
     * @return
     */
    public abstract double getHorario();
    
    /**
     * Devuelve el auto asociado con el evento
     * @return
     */
    public Auto getAuto() {
	return this.auto;
    }

}
