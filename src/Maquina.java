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

	boolean estaVacia()
	{
		return auto == null;
	}

	void nextAuto()
	{
		try
		{
			this.auto= (Auto) this.cola.desencolar(); //no se si es una negrada esto, mepa que si
		}
		catch (ColaException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Auto sacarAuto()
	{
		Auto aux=new Auto(); //revisar si no es otra villereada
		this.auto=null;
		return aux;
	}

}
