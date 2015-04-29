package utils;

public class PoissonSimulator {
    private int cantidad;
    private int minutos;

    /*
     * Para simular un proceso de Poisson se toma como parámetros, la frecuencia
     * entendida como cantidad de eventos que ocurren en una cantidad de minutos
     */
    public PoissonSimulator(int cant, int min) throws PoissonSimulatorException {
	if (min <= 0.0) {
	    throw new PoissonSimulatorException(
		    "Frecuencia infinita o sin sentido");
	}
	if (cant <= 0.0) {
	    throw new PoissonSimulatorException(
		    "Frecuencia nula o negativa: nada que simular");
	}
	cantidad = cant;
	minutos = min;
    }

    /*
     * Devuelve en cuantos minutos se producira el proximo arribo
     */
    public double proximoArribo() {
	double f = ((double) cantidad) / minutos;

	return (-Math.log(1.0 - Math.random()) / f);

    }
}
