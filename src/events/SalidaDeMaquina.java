package events;

import main.Auto;
import main.Main;
import main.Maquina;
import main.MaquinaEncerado;
import main.MaquinaLavado;
import main.TipoDeServicio;

/**
 * Evento que se produce al salir un auto de una maquina 
 */
public class SalidaDeMaquina extends Evento {
    private Maquina maquina;
    private double horario;
    private boolean finDelServicio = false;

    /**
     * <p>
     * Evento generado cuando un auto sale de una maquina (lavado o encerado)
     * luego de terminar el servicio en la misma.
     * </p>
     * <p>
     * Se verifica si esto significa el finDelServiciopara el auto, esto es True
     * si la maquina desde la cual se genera el evento es la de encerado, o si
     * en evento se genera desde la maquina de lavado y el auto no realiza
     * encerado
     * </p>
     * 
     * @param auto
     *            Auto que se vinculara a este evento
     * @param maquina
     *            Maquina desde la cual sale el auto
     */
    public SalidaDeMaquina(Auto auto, Maquina maquina) {
	super(auto);

	if (maquina.getClass() == MaquinaLavado.class) {
	    if (this.getAuto().getTicket().getTipoServicio() == TipoDeServicio.ECONOMICO) {
		this.horario = Main.timeline.getHorarioActual()
			+ Main.economico.getTiempoTotal();
	    } else if (this.getAuto().getTicket().getTipoServicio() == TipoDeServicio.COMPLETO) {
		this.horario = Main.timeline.getHorarioActual()
			+ Main.completo.getTiempoTotal();
	    } else if (this.getAuto().getTicket().getTipoServicio() == TipoDeServicio.PREMIUM) {
		this.horario = Main.timeline.getHorarioActual()
			+ Main.premium.getTiempoTotal();
	    }
	} else {
	    this.horario = Main.timeline.getHorarioActual()
		    + Main.encerado.getTiempoTotal();
	}

	this.maquina = maquina;

	finDelServicio = (maquina.getClass() == MaquinaEncerado.class || !(this
		.getAuto().getTicket().getEncerado())
		&& maquina.getClass() == MaquinaLavado.class);

    }

    /**
     * Devuelve la maquina relacionada al evento
     */
    public Maquina getMaquina() {
	return this.maquina;
    }
    
    /**
     * Devuelve el horario en el cual se produjo el evento
     */
    public double getHorario() {
	return this.horario;
    }
    
    /**
     * Devuelve si este evento significa que se terminó de dar servicio al auto
     * relacionado
     */
    public boolean esFinDeServicio() {
	return this.finDelServicio;
    }
}
