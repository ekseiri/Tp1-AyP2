package main;

/**
 * Clase que representa una Maquina de Encerado Manual, preventiva para 
 * futura implementacion
 */
public class MaquinaEncerado extends Maquina {

    public MaquinaEncerado() {
    }

    double getTiempoEnCola(MaquinaLavado maquina) {
	return Main.timeline.getHorarioActual() - maquina.getHorarioUltimaSalida();
    }

}
