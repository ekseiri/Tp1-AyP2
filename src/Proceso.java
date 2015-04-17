public class Proceso
{
	private int tiempo;
	private int costo;

	public Proceso(int tiempo, int costo)
	{
		this.tiempo = tiempo;
		this.costo = costo;
	}

	public int getTiempo()
	{
		return this.tiempo;
	}

	public int getCosto()
	{
		return this.costo;
	}
}
