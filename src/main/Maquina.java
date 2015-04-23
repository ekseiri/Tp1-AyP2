package main;

import utils.Cola;
import utils.ColaException;

//Abstracta? Mepa que si => a full
public abstract class Maquina
{
	private Cola cola;
	private Auto auto;

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
	public void getNextAuto() throws NoHayAutosException
	{
		try
		{
			this.auto = (Auto) this.cola.desencolar();
		}
		catch (ColaException e)
		{
			this.auto = null;
			throw new NoHayAutosException();
		}
	}

	/**
	 * Retira el auto de la maquina y lo pasa al siguiente estado
	 */
	public Auto sacarAuto()
	{

		Auto auto = this.auto;
		this.auto = null;

		return auto;
	}
	
	/**
	 * Ingresa el auto en cola
	 * @param auto
	 */
	public void encolarAuto(Auto auto)
	{
		if (auto.getTicket().getTipoServicio() == TipoDeServicio.ECONOMICO)
		{
			
		}
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
	
	/**
	 * Devuelve el auto que se encuentra en la Maquina
	 *  
	 * @return Auto
	 */
	public Auto getAuto() 
	{
		return this.auto;
	}

}
