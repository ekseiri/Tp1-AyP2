package main;

/**
 * Clase que representa una Maquina Automatica de Lavado, preventiva para 
 * futura implementacion
 */
public class MaquinaLavado extends Maquina {

    public MaquinaLavado() {
	// TODO Auto-generated constructor stub
    }
    
    double getTiempoEnCola() {
	return Main.timeline.getHorarioActual() - this.getAuto().getTicket().getHorario();
    }
}
