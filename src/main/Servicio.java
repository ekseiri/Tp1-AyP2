package main;
public class Servicio // si, es igual a proceso, estoy seguro que algo falta
{
	private int tiempo = 0;
	private int costo = 0;

	public Servicio(int tiempo, int costo)
	{
		this.tiempo = tiempo;
		this.costo = costo;
	}

	public int getTiempoLavado()
	{
		return this.tiempo;
	}

	public int getCosto()
	{
		return this.costo;
	}
}
