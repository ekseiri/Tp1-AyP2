package utils;

import java.util.Comparator;

import events.Evento;

/**
 * Comparador utilizado para determinar el orden de los eventos
 */
public class Comparador implements Comparator<Evento> {
    
    /**
     * Resuelve la comparación mediante el horario de ocurrencia
     */
    public int compare(Evento x, Evento y) {
	if (x.getHorario() > y.getHorario()) {
	    return 1;
	} else if (x.getHorario() < y.getHorario()) {
	    return -1;
	}

	return 0;
    }
}
