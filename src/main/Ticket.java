package main;

/**
 * Clase que contiene los servicios pedidos por el auto y la hora de llegada 
 * del mismo
 *
 */
public class Ticket {
    private TipoDeServicio servicio;
    private double horaDeLlegada;
    private boolean encera;
    
    /**
     * El ticket se crea con la hora de llegada del auto entregada por el
     * proceso Poisson, determina el tipo de servicio que consumirá el
     * auto y si el mismo realizará encerado
     * @param horaDeLlegada
     */
    public Ticket(double horaDeLlegada) {
	    this.horaDeLlegada = horaDeLlegada;
    	    this.servicio = DeterminadorDeServicio.getServicio();
    	    this.encera = DeterminadorDeServicio.getEncerado();
    }
    
    /**
     * Devuelve el horario de llegada
     */
    public double getHorario() {
	return this.horaDeLlegada;
    }
    
    /**
     * Devuelve si se realiza encerado o no
     */
    public boolean getEncerado() {
	return this.encera;
    }
    
    /**
     * Devuelve el tipo de servicio que se realizará
     */
    public TipoDeServicio getTipoServicio() {
	return this.servicio;
    }

}
