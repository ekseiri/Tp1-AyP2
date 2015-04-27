package events;

import main.*;



public class SalidaDeCola extends Evento {
    private double horario;
    private Maquina maquina;

    public SalidaDeCola(Auto auto, Maquina maquina) {
	super(auto);
	
	this.maquina = maquina;
	this.horario = Main.timeline.getHorarioActual() + Double.MIN_VALUE;

    }

    public double getHorario() {
	return this.horario;
    }

    public Maquina getMaquina() {
	return this.maquina;

    }

    public double getTiempoEnCola() {
	// Tiempo en Cola = (Horario Actual) - (Horario De Entrada)
	return Main.timeline.getHorarioActual() - this.horario;
    }

}
