package main;

public class Proceso {
    private int tiempo = 0;
    private int costo = 0;

    public Proceso(int tiempo, int costo) {
	this.tiempo = tiempo;
	this.costo = costo;
    }

    public int getTiempo() {
	return this.tiempo;
    }

    public int getCosto() {
	return this.costo;
    }
}
