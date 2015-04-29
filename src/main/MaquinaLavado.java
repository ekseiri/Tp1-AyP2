package main;

/**
 * Clase que representa una Maquina Automatica de Lavado
 */
public class MaquinaLavado extends Maquina {

    private double horarioUltimaSalida = 0;
    
    /**
     * Devuelve el tiempo que paso en cola el auto actualmente en la maquina 
     * @return
     */
    public double getTiempoEnCola() {
	return Main.timeline.getHorarioActual() - this.getAuto().getTicket().getHorario();
    }
    
    /**
     * Guarda el horario en el que se produjo la ultima salida de la
     * maquina
     */
    public void setHorarioUltimaSalida() {
	this.horarioUltimaSalida = Main.timeline.getHorarioActual();
    }
    
    /**
     * Devuelve el horario en el que se produjo la ultima salida de la 
     * maquina
     */
    public double getHorarioUltimaSalida() {
	return this.horarioUltimaSalida;
    }
}
