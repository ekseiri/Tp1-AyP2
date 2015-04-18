package events;

import main.Auto;
import main.Maquina;
import main.MaquinaEncerado;
import main.MaquinaLavado;

public class SalidaDeMaquina extends Evento
{
	Maquina maquina;
	private double horario;
	private boolean finDelServicio = false;

	public SalidaDeMaquina(Auto auto, Maquina maquina)
	{
		super(auto);
		
		this.maquina= maquina;
		
		// Much nigga
		// Si se les ocurre una forma mas elegante de hacer esto mejor
		// if ((maquina.getClass().getSimpleName() == "MaquinaEncerado") ||
		// (!(this.getAuto().getTicket().getEncerado()) &&
		// (maquina.getClass().getSimpleName() == "MaquinaEncerado")))
		// {
		// finDelServicio = !finDelServicio;
		// }
		if (maquina.getClass() == MaquinaEncerado.class //se puede manejar desde el main esto
				|| !(this.getAuto().getTicket().getEncerado())
				&& maquina.getClass() == MaquinaEncerado.class)
		{

		}

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
