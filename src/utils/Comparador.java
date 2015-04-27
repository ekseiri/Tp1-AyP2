package utils;

import java.util.Comparator;

import events.Evento;

/**
 *
 */
public class Comparador implements Comparator<Evento> {
    public int compare(Evento x, Evento y) {
	if (x.getHorario() > y.getHorario()) {
	    return 1;
	} else if (x.getHorario() < y.getHorario()) {
	    return -1;
	}

	return 0;
    }
}
