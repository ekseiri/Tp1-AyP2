package main;

/**
 * Clase que representa una Maquina de Encerado Manual
 */
public class MaquinaEncerado extends Maquina {

    /**
     * Devuelve el tiempo transcurrido desde el momento de la última salida de 
     * un auto en la maquina indicada y el momento actual
     * @param maquina
     * @return
     */
    double getTiempoEnCola(MaquinaLavado maquina) {
	return Main.timeline.getHorarioActual() - maquina.getHorarioUltimaSalida();
    }

}
