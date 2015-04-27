package main;

public class Servicio extends Proceso {

    public Servicio(int tiempo, int costo) {
	super(tiempo, costo);
    }

    public int getTiempoTotal() {
	return super.getTiempo();
    }

}
