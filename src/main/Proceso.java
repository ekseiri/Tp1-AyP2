package main;

/**
 * Clase que representa los procesos que se dan en cada Maquina
 *
 */
public class Proceso {
    private int tiempo = 0;
    private int costo = 0;
    
    /**
     * <p>El objeto se crea de acuerdo al tiempo y costo correspondiente a cada
     * proceso.</p>
     * <p>Estos valores se encuentran tabulados en el archivo Tablas.txt y deben
     * extraerse del mismo para la creación del proceso</p>
     * @param tiempo 
     * @param costo
     */
    public Proceso(int tiempo, int costo) {
	this.tiempo = tiempo;
	this.costo = costo;
    }
    
    /**
     * Devuelve el tiempo que consume el proceso
     */
    public int getTiempo() {
	return this.tiempo;
    }
    
    /**
     * Devuelve el costo del proceso
     */
    public int getCosto() {
	return this.costo;
    }
}
