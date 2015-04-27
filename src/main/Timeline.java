package main;

import java.util.PriorityQueue;

import events.Evento;
import utils.Comparador;

public class Timeline {
    private PriorityQueue<Evento> timeline;
    private double horarioActual;
    private Comparador comparador = new Comparador();

    public Timeline() {
	this.horarioActual = 0;
	this.timeline = new PriorityQueue<Evento>(comparador);
    }

    public double getHorarioActual() {
	return this.horarioActual;
    }

    public Evento getNextEvento() {
	Evento evento = (Evento) timeline.poll();
	this.horarioActual = this.horarioActual + evento.getHorario();
	return evento;
    }

    public boolean newEvent(Evento evento) {
	return this.timeline.add(evento);
    }
}
