package main;
import utils.Cola;
import utils.ColaException;

//Abstracta? Mepa que si => a full
public abstract class Maquina
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
	public void nextAuto() throws NoHayAutosException
	{
		
		//no se si es una negrada esto, mepa que si
        try
        {
            this.auto = (Auto) this.cola.desencolar();
        }
        catch (ColaException e)
        {
            this.auto = null;
            throw new NoHayAutosException("La cola de la maquina esta vacia");
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
	public void ingresarAuto(Auto auto)
	{
		try
		{
			this.cola.encolar(auto);
		}
		catch (ColaException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void avanzarCola(Maquina proximaMaquina) //para mi esto no va porque se maneja desde el main con el evento salida de maquina
	{
		
	}

}
