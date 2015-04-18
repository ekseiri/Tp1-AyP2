package main;

import java.util.PriorityQueue;

import events.Evento;
import utils.Comparador;

public class Timeline
{
	private PriorityQueue<Evento> timeline;
	private double horarioActual;
	private Comparador comparador;

	public Timeline()
	{
		this.horarioActual = 0;
		this.timeline = new PriorityQueue<Evento>(comparador);
	}

	public double getHorarioActual()
	{
		return horarioActual;
	}

	public Evento nextEvento()
	{
		Evento aux = (Evento) timeline.poll();
		this.horarioActual = aux.getHorario();
		return aux;
	}
	public boolean newEvent(Evento evento)//puse el boolean porque .add devuelve eso, pero puede obviarse
	{
		return this.timeline.add(evento);
	}
}
