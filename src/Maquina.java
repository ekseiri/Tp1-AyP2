import utils.Cola;
import utils.ColaException;

public class Maquina
{
	private Cola cola;
	private Auto auto;
	private Servicio servicio;
    
    /**
     * Crea una nueva Maquina, con su Cola asociada
     */
	public Maquina()
	{
		cola = new Cola();
	}
    
    /**
     * Devuelve true si no hay ingresado en la maquina
     */
	public boolean estaVacia()
	{
		return auto == null;
	}
    
    /**
     * Saca el primer auto de la cola y lo ingresa a la maquina
     */
	public void nextAuto()
	{
		
		//no se si es una negrada esto, mepa que si
        try
        {
            this.auto = (Auto) this.cola.desencolar();
        }
        catch (ColaException e)
        {
            this.auto = null;
        } 
	}
	
    /**
     * Retira el auto de la maquina y lo pasa al siguiente estado
     */
	public Auto sacarAuto()
	{

		Auto auto = this.auto; //revisar si no es otra villereada
		this.auto=null;
		
		return auto;
	}
	
	public void avanzarCola(Maquina proximaMaquina)
	{
		
	}

}
