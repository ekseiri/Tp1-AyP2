package events;

import main.*;


/**
 * Evento que se produce al salir un auto de cola e ingresar a una maquina
 */
public class SalidaDeCola extends Evento {
    private double horario;
    private Maquina maquina;
    
    /**
     * El evento se inicializa con un Auto y la Maquina a la cual pertenece la 
     * cola relacionada al evento
     * @param auto
     * @param maquina
     */
    public SalidaDeCola(Auto auto, Maquina maquina) {
	super(auto);
	
	this.maquina = maquina;
	this.horario = Main.timeline.getHorarioActual() + Double.MIN_VALUE;

    }
    
    /**
     * Devuelve el horario en el cual se produjo el evento
     */
    public double getHorario() {
	return this.horario;
    }
    
    /**
     * Devuelve la maquina relacionada al evento
     */
    public Maquina getMaquina() {
	return this.maquina;
    }
    
}
