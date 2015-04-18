package main;

public class Ticket 
//desde el main se lee el tipo de servicio y se aplica a la maquina
{
	private TipoDeServicio servicio;
	private int horaDeLlegada;
	private boolean encera;

	public Ticket(int horaDeLlegada)
	{
		this.horaDeLlegada=horaDeLlegada;
		this.servicio=DeterminadorDeServicio.getServicio();
		this.encera = DeterminadorDeServicio.getEncerado();
	}
	
	public int getHorario()
	{
		return this.horaDeLlegada;
	}
	
	public boolean getEncerado()
	{
		return this.encera;
	}

}
