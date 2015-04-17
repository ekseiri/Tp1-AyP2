public class Ticket 
//desde el main se lee el tipo de servicio y se aplica a la maquina
{
	private TipoDeServicio servicio;
	private int horaDeLlegada;
	private boolean encera;

	public Ticket(int horaDeLlegada, TipoDeServicio servicioElegido, boolean encerado)
	{
		this.horaDeLlegada=horaDeLlegada;
		this.servicio=servicioElegido;
		this.encera = encerado;
	}
	int getTiempo()
	{
		return this.horaDeLlegada;
	}
	TipoDeServicio getTipoServicio()
	{
		return this.servicio;
	}
	boolean encera()
	{
		return this.encera;
	}
}
