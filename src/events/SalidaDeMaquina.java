
package events;

import main.Auto;
import main.Maquina;
import main.MaquinaEncerado;
import main.MaquinaLavado;

public class SalidaDeMaquina extends Evento
{
	private int horario;
	private boolean finDelServicio = false;
	
	public SalidaDeMaquina(Auto auto, Maquina maquina)
	{
		super(auto);
		
		// Much nigga
		// Si se les ocurre una forma mas elegante de hacer esto mejor
		if ((maquina.getClass().getSimpleName() == "MaquinaEncerado") || 
			(!(this.getAuto().getTicket().getEncerado()) && 
					(maquina.getClass().getSimpleName() == "MaquinaEncerado")))
		{
			finDelServicio = !finDelServicio;
		}
			
	}
	
	public int getHorario()
	{
		return this.getAuto().getTicket().getHorario();
	}
}
