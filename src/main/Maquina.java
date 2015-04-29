package main;

import utils.Cola;
import utils.ColaException;

/**
 * Clase que representa una Maquina generica
 */
public abstract class Maquina {
    private Cola cola;
    private Auto auto;

    /**
     * Crea una nueva Maquina, con su Cola asociada
     */
    public Maquina() {
	cola = new Cola();
    }

    /**
     * Devuelve true si no hay auto ingresado en la maquina
     */
    public boolean estaVacia() {
	return auto == null;
    }

    /**
     * Saca el primer auto de la cola y lo ingresa a la maquina
     */
    public void nextAuto() throws NoHayAutosException {
	try {
	    this.auto = (Auto) this.cola.desencolar();
	} catch (ColaException e) {
	    this.auto = null;
	    throw new NoHayAutosException();
	}
    }

    /**
     * Retira el auto de la maquina y lo devuelve
     * 
     * @return auto Auto
     */
    public Auto sacarAuto() {

	Auto auto = this.auto;
	this.auto = null;

	return auto;
    }

    /**
     * Ingresa el auto en cola
     * 
     * @param auto
     */
    public void encolarAuto(Auto auto) {
	if (auto.getTicket().getTipoServicio() == TipoDeServicio.ECONOMICO) {
	    //falta implementar
	}
	try {
	    this.cola.encolar(auto);
	} catch (ColaException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Devuelve el auto que se encuentra en la Maquina
     * 
     * @return Auto
     */
    public Auto getAuto() {
	return this.auto;
    }
    
    /**
     * Devuelve la cola de la maquina
     * @return
     */
    public Cola getCola() {
	return this.cola;
    }
    
    abstract double getTiempoEnCola();
    
    public int getAutosEnCola(){
	return this.cola.getCantidadEncolados();
	
    }

}
