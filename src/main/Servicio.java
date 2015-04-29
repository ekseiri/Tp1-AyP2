package main;

/**
 * Clase que representa los Servicios disponibles, con sus tiempos
 * y costos totales
 *
 */
public class Servicio extends Proceso {
    
    /**
     * El servicio se inicializa con un tiempo y un costo, los cuales seran
     * la sumatoria de los procesos que lo componen
     * @param tiempo
     * @param costo
     */
    public Servicio(int tiempo, int costo) {
	super(tiempo, costo);
    }
    
    /**
     * Devuelve el tiempo total que demorara el servicio
     * @return
     */
    public int getTiempoTotal() {
	return super.getTiempo();
    }

}
