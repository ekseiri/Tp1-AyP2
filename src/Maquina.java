import utils.Cola;
import utils.ColaException;

public class Maquina
{
	private Cola cola;
	private Auto auto;
	private Servicio servicio;

	public Maquina()
	{
		cola = new Cola();
	}
	
	public boolean estaVacia()
	{
		return auto == null;
	}

	public void nextAuto()
	{
		
		//no se si es una negrada esto, mepa que si
		try
		{
			this.auto = (Auto) this.cola.desencolar();
		}
		catch (ColaException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}
	
	public Auto sacarAuto()
	{
		Auto aux=this.auto; //revisar si no es otra villereada
		this.auto=null;
		
		return aux;
	}
	
	public void avanzarCola(Maquina proximaMaquina)
	{
		
	}

}
