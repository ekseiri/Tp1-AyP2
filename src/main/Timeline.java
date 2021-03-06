package main;

import java.util.PriorityQueue;

import events.Evento;

import utils.Comparador;

/**
 * Clase utilizada para mantener registro del tiempo transcurrido, guarda los 
 * eventos ocurridos
 */
public class Timeline {
    private PriorityQueue<Evento> timeline;
    private double horarioActual;
    private Comparador comparador = new Comparador();

    /**
     * El timeline se inicializa con el horario actual en 0 (inicio del dia)
     */
    public Timeline() {
	this.horarioActual = 0;
	this.timeline = new PriorityQueue<Evento>(comparador);
    }
    
    /**
     * Devuelve el horario actual
     */
    public double getHorarioActual() {
	return this.horarioActual;
    }
    
    /**
     * Devuelve el proximo evento
     * @return Evento
     */
    public Evento getNextEvento() {
	Evento evento = (Evento) timeline.poll();
	this.horarioActual =  evento.getHorario();
	return evento;
    }
    
    /**
     * Agrega un evento al timeline, el mismo se ubica de manera automatica 
     * segun su prioridad
     * @param evento Evento
     */
    public void newEvento(Evento evento) {
	this.timeline.add(evento);
    }
    
    /**
     * Determina si el dia se terminó, esto es verdadero cuando en el timeline
     * no quedan eventos pendientes (se atendieron todos los autos) y el horario 
     * de atencion es >= 720
     */
    public boolean finDelDia(){
	return (timeline.isEmpty() && (this.horarioActual >= Main.horarioAtencion));
    }
    
    /**
     * Vuelve a 0 el horario
     */
    public void reset() {
	this.horarioActual=0;
    }
}
