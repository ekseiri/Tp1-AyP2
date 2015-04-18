package events;

import main.Auto;

public class FinDeServicio extends Evento
{

	public FinDeServicio(Auto auto)
	{
		super(null);
		this.horario = horaFin; //hay que poner un setter en evento o como es esto?
								//tiene sentido agregar un horario a este evento o se maneja directo con el timeline?
	}

	public double getHorario()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
