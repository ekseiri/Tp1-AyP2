package main;

public class Ticket
// desde el main se lee el tipo de servicio y se aplica a la maquina
{
    private TipoDeServicio servicio;
    private double horaDeLlegada;
    private boolean encera;

    public Ticket(double horaDeLlegada) {
	this.horaDeLlegada = horaDeLlegada;
	this.servicio = DeterminadorDeServicio.getServicio();
	this.encera = DeterminadorDeServicio.getEncerado();
    }

    public double getHorario() {
	return this.horaDeLlegada;
    }

    public boolean getEncerado() {
	return this.encera;
    }

    public TipoDeServicio getTipoServicio() {
	return this.servicio;
    }

}
