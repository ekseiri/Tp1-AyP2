package events;

import main.Auto;
import main.Maquina;
import main.MaquinaEncerado;
import main.MaquinaLavado;

public class SalidaDeMaquina extends Evento
{
	private Maquina maquina;
	private double horario;
	private boolean finDelServicio = false;
	
	/**
	 * <p>
	 * Evento generado cuando un auto sale de una maquina (lavado o encerado)
	 * luego de terminar el servicio en la misma.
	 * </p>
	 * <p>
	 * Se verifica si esto significa el finDelServiciopara el auto, esto es 
	 * True si la maquina desde la cual se genera el evento es la de encerado, 
	 * o si en evento se genera desde la maquina de lavado y el auto no 
	 * realiza encerado
	 * </p>
	 * 
	 * @param auto Auto que se vinculara a este evento
	 * @param maquina Maquina desde la cual sale el auto
	 */
	public SalidaDeMaquina(Auto auto, Maquina maquina)
	{
		super(auto);
		
		this.maquina = maquina;
				
		finDelServicio = (maquina.getClass() == MaquinaEncerado.class 
							|| !(this.getAuto().getTicket().getEncerado())
							&& maquina.getClass() == MaquinaEncerado.class);

	}
	
	public Maquina getMaquina()
	{
		return this.maquina;
		
	}
	public double getHorario()
	{
		return this.getAuto().getTicket().getHorario();
	}
}
