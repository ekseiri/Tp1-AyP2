package main;

/**
 * Clase que representa una Maquina Automatica de Lavado, preventiva para 
 * futura implementacion
 */
public class MaquinaLavado extends Maquina {

    private double horarioUltimaSalida = 0;
    
    public MaquinaLavado() {
	// TODO Auto-generated constructor stub
    }
    
    public double getTiempoEnCola() {
	return Main.timeline.getHorarioActual() - this.getAuto().getTicket().getHorario();
    }
    
    public void setHorarioUltimaSalida() {
	this.horarioUltimaSalida = Main.timeline.getHorarioActual();
    }
    
    public double getHorarioUltimaSalida() {
	return this.horarioUltimaSalida;
    }
}
