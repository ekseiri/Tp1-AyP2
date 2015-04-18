package events;

import main.*;

public class SalidaDeCola extends Evento
{
	private double horario;
		
	public SalidaDeCola(Auto auto, Maquina maquina)
	{
		super(auto);
		if (maquina.getClass().getSimpleName() == "MaquinaLavado")
		{
			this.horario = Main.timeline.getHorarioActual();
		}
	}

    public double getHorario()
    {
        return this.horario;
    }

    public double getTiempoEnCola()
    {
    	// Tiempo en Cola = (Horario Actual) - (Horario De Entrada)
    	return Main.timeline.getHorarioActual() - this.horario;
    }

}
