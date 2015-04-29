package main;

/**
 * Clase que representa una Maquina de Encerado Manual, preventiva para 
 * futura implementacion
 */
public class MaquinaEncerado extends Maquina {

    public MaquinaEncerado() {
	// TODO Auto-generated constructor stub
    }

    double getTiempoEnCola() {
	return Main.timeline.getHorarioActual() - this.getAuto().getTicket().getHorario();
    }

}
