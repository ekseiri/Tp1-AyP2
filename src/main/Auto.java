package main;

public class Auto {
    private Ticket ticket;

    public Auto(Ticket ticket) {
	try {
	    this.ticket = ticket;
	} catch (NullPointerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public Ticket getTicket() {
	return this.ticket;
    }
}
