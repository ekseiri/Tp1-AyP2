package main;

public class Stats {
    private int[] cantidadServicios = new int[4];
    private double[] acumuladorTiempoEnCola = new double[2];

    /**
     * Crea el contenedor de estadisticas, inicializando la cantidad de
     * servicios y el acumulador de tiempo para cada cola en 0
     */
    public Stats() {

	for (int i = 0; i < this.cantidadServicios.length; i++)
	    this.cantidadServicios[i] = 0;

	for (int i = 0; i < this.cantidadServicios.length; i++)
	    this.acumuladorTiempoEnCola[i] = 0;

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
	if ((tipoDeServicio == TipoDeServicio.ECONOMICO)
		|| (tipoDeServicio == TipoDeServicio.COMPLETO)
		|| (tipoDeServicio == TipoDeServicio.PREMIUM))
	    this.acumuladorTiempoEnCola[0] += tiempo;

	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    this.acumuladorTiempoEnCola[1] += tiempo;
    }

    /**
     * Devuelve el tiempo de espera acumulado en la cola indicada
     * 
     * @param tipoDeServicio
     *            TipoDeServicio requerido
     * @return -1 Si el TipoDeServicio es inexistente
     */
    public double getTiempoEnCola(TipoDeServicio tipoDeServicio) {
	if ((tipoDeServicio == TipoDeServicio.ECONOMICO)
		|| (tipoDeServicio == TipoDeServicio.COMPLETO)
		|| (tipoDeServicio == TipoDeServicio.PREMIUM))
	    return this.acumuladorTiempoEnCola[0];

	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    return this.acumuladorTiempoEnCola[1];

	return -1;
    }

    /**
     * Setea en 0 el tiempo de espera para la cola indicada
     * 
     * @param tipoDeServicio
     *            TipoDeServicio requerido
     */

    /*
     * public void resetTiempoEnCola(TipoDeServicio tipoDeServicio) { if
     * ((tipoDeServicio == TipoDeServicio.ECONOMICO) || (tipoDeServicio ==
     * TipoDeServicio.COMPLETO) || (tipoDeServicio == TipoDeServicio.PREMIUM))
     * this.acumuladorTiempoEnCola[0] = 0;
     * 
     * if (tipoDeServicio == TipoDeServicio.ENCERADO)
     * this.acumuladorTiempoEnCola[1] = 0; }
     */
    public void resetStats() {
	this.cantidadServicios[0] = 0;
	this.cantidadServicios[1] = 0;
	this.cantidadServicios[2] = 0;
	this.cantidadServicios[3] = 0;
	this.acumuladorTiempoEnCola[0] = 0;
	this.acumuladorTiempoEnCola[1] = 0;
    }

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
	System.out.println("Económico: " + costoEconomicos);
	System.out.println("Completo: " + costoCompletos);
	System.out.println("Premium: " + costoPremiums);
	System.out.println("Encerado: " + costoEncerados);
	System.out.println();
	System.out
		.println("Costo Total: "
			+ (costoEconomicos + costoCompletos + costoPremiums + costoEncerados));
	System.out.println();
    }

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
		+ getTiempoEnCola(TipoDeServicio.COMPLETO)
		+ getTiempoEnCola(TipoDeServicio.PREMIUM))
		/ (getServicios(TipoDeServicio.ECONOMICO)
		+ getServicios(TipoDeServicio.COMPLETO)
		+ getServicios(TipoDeServicio.PREMIUM));

	System.out.println("Promedio General de Espera por Total de Servicios: " + promGeneral);
	System.out.println();
	System.out.println("Promedio de Espera por Servicio:");
	System.out.println("Económico: " + promEconomicos);
	System.out.println("Completo: " + promCompletos);
	System.out.println("Premium: " + promPremiums);
	System.out.println("Encerado: " + promEncerados);
	System.out.println();

    }
}
