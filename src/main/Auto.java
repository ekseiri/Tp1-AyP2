package main;

/**
 * Clase que representa los autos que llegan al lavadero 
 *
 */
public class Auto {
    private Ticket ticket;
    
    /**
     * El auto se inicializa conteniendo su Ticket
     * @param ticket
     */
    public Auto(Ticket ticket) {
	try {
	    this.ticket = ticket;
	} catch (NullPointerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    /**
     * Devuelve el ticket asociado al auto
     * @return
     */
    public Ticket getTicket() {
	return this.ticket;
    }
}
