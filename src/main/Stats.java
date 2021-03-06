package main;

/**
 * Clase que contiene los datos y metodos necesarios para el calculo de
 * estadisticas
 */
public class Stats {
    private int[] cantidadServicios = new int[4];
    private double[] longitudDeCola = new double[2];
    private double[] tiempoLongitudDeCola = new double[2];
    private double[] acumuladorTiempoEnCola = new double[4];
    private double tiempoTrabajado;

    /**
     * Crea el contenedor de estadisticas, inicializando la cantidad de
     * servicios y el acumulador de tiempo para cada cola en 0
     */
    public Stats() {
	resetStats();
    }

    /**
     * Suma 1 a la cantidad de servicios realizados para el servicio indicado
     * 
     * @param tipoDeServicio
     *            TipoDeServicio requerido
     */
    public void addServicio(TipoDeServicio tipoDeServicio) {
	if (tipoDeServicio == TipoDeServicio.ECONOMICO)
	    this.cantidadServicios[0]++;
	if (tipoDeServicio == TipoDeServicio.COMPLETO)
	    this.cantidadServicios[1]++;
	if (tipoDeServicio == TipoDeServicio.PREMIUM)
	    this.cantidadServicios[2]++;
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    this.cantidadServicios[3]++;

    }

    /**
     * Devuelve la cantidad de Servicios realizados del tipo indicado
     * 
     * @param tipoDeServicio
     *            TipoDeServicio requerido
     * @return -1 Si el TipoDeServicio es inexistente
     */
    public int getServicios(TipoDeServicio tipoDeServicio) {
	if (tipoDeServicio == TipoDeServicio.ECONOMICO)
	    return this.cantidadServicios[0];
	if (tipoDeServicio == TipoDeServicio.COMPLETO)
	    return this.cantidadServicios[1];
	if (tipoDeServicio == TipoDeServicio.PREMIUM)
	    return this.cantidadServicios[2];
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    return this.cantidadServicios[3];

	return -1;
    }

    /**
     * Suma tiempo de espera en la cola indicada
     * 
     * @param tipoDeServicio
     *            TipoDeServicio requerido
     */
    public void addTiempoEnCola(TipoDeServicio tipoDeServicio, double tiempo) {
	if (tipoDeServicio == TipoDeServicio.ECONOMICO)
	    this.acumuladorTiempoEnCola[0] += tiempo;
	if (tipoDeServicio == TipoDeServicio.COMPLETO)
	    this.acumuladorTiempoEnCola[1] += tiempo;
	if (tipoDeServicio == TipoDeServicio.PREMIUM)
	    this.acumuladorTiempoEnCola[2] += tiempo;
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    this.acumuladorTiempoEnCola[3] += tiempo;
    }

    /**
     * Devuelve el tiempo de espera acumulado en la cola indicada
     * 
     * @param tipoDeServicio
     *            TipoDeServicio requerido
     * @return -1 Si el TipoDeServicio es inexistente
     */
    public double getTiempoEnCola(TipoDeServicio tipoDeServicio) {
	if (tipoDeServicio == TipoDeServicio.ECONOMICO)
	    return this.acumuladorTiempoEnCola[0];
	if (tipoDeServicio == TipoDeServicio.COMPLETO)
	    return this.acumuladorTiempoEnCola[1];
	if (tipoDeServicio == TipoDeServicio.PREMIUM)
	    return this.acumuladorTiempoEnCola[2];
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    return this.acumuladorTiempoEnCola[3];

	return -1;
    }

    /**
     * Setea en 0 los acumuladores de estadisticas
     */
    public void resetStats() {
	for (int i = 0; i < this.cantidadServicios.length; i++)
	    this.cantidadServicios[i] = 0;

	for (int i = 0; i < this.acumuladorTiempoEnCola.length; i++)
	    this.acumuladorTiempoEnCola[i] = 0;

	for (int i = 0; i < this.longitudDeCola.length; i++)
	    this.longitudDeCola[i] = 0;

	for (int i = 0; i < this.tiempoLongitudDeCola.length; i++)
	    this.tiempoLongitudDeCola[i] = 0;

	tiempoTrabajado = 0;
    }

    /**
     * Guarda las longitudes de cola a lo largo del tiempo
     * @param maquina
     */
    public void addLongitudDeCola(Maquina maquina) {

	if (maquina.getClass() == MaquinaLavado.class) {
	    this.longitudDeCola[0] += maquina.getAutosEnCola()
		    * (Main.timeline.getHorarioActual() - this.tiempoLongitudDeCola[0]);
	    this.tiempoLongitudDeCola[0] = Main.timeline.getHorarioActual();
	}
	
	if (maquina.getClass() == MaquinaEncerado.class) {
	    this.longitudDeCola[1] += maquina.getAutosEnCola()
		    * (Main.timeline.getHorarioActual() - this.tiempoLongitudDeCola[1]);
	    this.tiempoLongitudDeCola[0] = Main.timeline.getHorarioActual();
	}

    }
    
    /**
     * Cuenta el tiempo real trabajado, para compensar los servicios que deben 
     * terminarse despues de la hora de cierre
     * @param tiempoTrabajado
     */
    public void setTiempoTrabajado(double tiempoTrabajado) {
	this.tiempoTrabajado = tiempoTrabajado;
    }

    /**
     * Calcula e imprime el costo total incurrido por cada tipo de servicio
     */
    public void printCostoPorDiaYPorServicio() {
	double costoEconomicos = getServicios(TipoDeServicio.ECONOMICO)
		* Main.economico.getCosto();
	double costoCompletos = getServicios(TipoDeServicio.COMPLETO)
		* Main.completo.getCosto();
	double costoPremiums = getServicios(TipoDeServicio.PREMIUM)
		* Main.premium.getCosto();
	double costoEncerados = getServicios(TipoDeServicio.ENCERADO)
		* Main.encerado.getCosto();

	System.out.println("Costo por Servicio:");
	System.out.println();
	System.out.println("Economico: "
		+ String.format("$%.2f", costoEconomicos));
	System.out.println("Completo: "
		+ String.format("$%.2f", costoCompletos));
	System.out.println("Premium: " + String.format("$%.2f", costoPremiums));
	System.out.println("Encerado: "
		+ String.format("$%.2f", costoEncerados));
	System.out.println();
	System.out.println("Costo Total: "
		+ String.format("$%.2f", (costoEconomicos + costoCompletos
			+ costoPremiums + costoEncerados)));
	System.out.println();
    }
    
    /**
     * Calcula e imprime los tiempos de espera promedio
     */
    public void printPromedioGeneralDeEspera() {
	double promEconomicos = getTiempoEnCola(TipoDeServicio.ECONOMICO)
		/ getServicios(TipoDeServicio.ECONOMICO);
	double promCompletos = getTiempoEnCola(TipoDeServicio.COMPLETO)
		/ getServicios(TipoDeServicio.COMPLETO);
	double promPremiums = getTiempoEnCola(TipoDeServicio.PREMIUM)
		/ getServicios(TipoDeServicio.PREMIUM);
	double promEncerados = getTiempoEnCola(TipoDeServicio.ENCERADO)
		/ getServicios(TipoDeServicio.ENCERADO);
	
	double promGeneral = (getTiempoEnCola(TipoDeServicio.ECONOMICO)
		+ getTiempoEnCola(TipoDeServicio.COMPLETO) + getTiempoEnCola(TipoDeServicio.PREMIUM))
		/ (getServicios(TipoDeServicio.ECONOMICO)
			+ getServicios(TipoDeServicio.COMPLETO) + getServicios(TipoDeServicio.PREMIUM));

	System.out.println("Promedio General de Espera por Total de Servicios: "
			+ String.format("%.2f", promGeneral) + " minutos");
	System.out.println();
	System.out.println("Promedio de Espera por Servicio:");
	System.out.println("Economico: "
		+ String.format("%.2f", promEconomicos) + " minutos");
	System.out.println("Completo: " + String.format("%.2f", promCompletos)
		+ " minutos");
	System.out.println("Premium: " + String.format("%.2f", promPremiums)
		+ " minutos");
	System.out.println("Encerado: " + String.format("%.2f", promEncerados)
		+ " minutos");
	System.out.println();

    }
    
    /**
     * Imprime la longitud promedio para cada cola
     */
    public void printLongitudPromedioColas() {

	if (this.tiempoTrabajado < Main.horarioAtencion){this.tiempoTrabajado=Main.horarioAtencion;}
	System.out.println("Longitud Promedio de las Colas:");
	System.out.println();
	System.out.println("Lavado: "
		+ String.format("%.2f",
			(this.longitudDeCola[0] / this.tiempoTrabajado))
		+ " autos");
	System.out.println("Encerado: "
		+ String.format("%.2f",
			(this.longitudDeCola[1] / this.tiempoTrabajado))
		+ " autos");
	System.out.println();
    }
}
