package events;

import main.Auto;

/**
 * Superclass abstracta de la cual heredan los demas eventos
 *
 */
public abstract class Evento {
    private Auto auto;

    public Evento(Auto auto) {
	try {
	    this.auto = auto;
	} catch (NullPointerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public abstract double getHorario();

    public Auto getAuto() {
	return this.auto;
    }

}
