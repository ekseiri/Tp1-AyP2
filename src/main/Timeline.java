package main;

import java.util.PriorityQueue;

import events.Evento;
import utils.Comparador;

public class Timeline
{
	private PriorityQueue timeline;
	private int horarioActual;
	private Comparador comparador;

	public Timeline()
	{
		this.horarioActual = 0;
		timeline = new PriorityQueue(comparador);
	}

	public int getHorarioActual()
	{
		return horarioActual;
	}
}
