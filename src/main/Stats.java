package main;

public class Stats {
    private int[] cantidadServicios = new int[4];
    private int[] acumuladorTiempoEnCola = new int[2];
    
    /**
     * Crea el contenedor de estadisticas, inicializando la cantidad
     * de servicios y el acumulador de tiempo para cada cola en 0
     */
    public Stats(){
	
	for (int i = 0; i < this.cantidadServicios.length; i++)
	    this.cantidadServicios[i] = 0;
	
	for (int i = 0; i < this.cantidadServicios.length; i++)
	    this.acumuladorTiempoEnCola[i] = 0;
	
    }
    
    /**
     * Suma 1 a la cantidad de servicios realizados para el servicio indicado
     * @param tipoDeServicio TipoDeServicio requerido
     */
    public void addServicio(TipoDeServicio tipoDeServicio){
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
     * @param tipoDeServicio TipoDeServicio requerido
     * @return -1 Si el TipoDeServicio es inexistente
     */
    public int getServicios(TipoDeServicio tipoDeServicio){
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
     * @param tipoDeServicio TipoDeServicio requerido
     */
    public void addTiempoEnCola(TipoDeServicio tipoDeServicio){
	if ((tipoDeServicio == TipoDeServicio.ECONOMICO) || (tipoDeServicio == TipoDeServicio.COMPLETO)
		 || (tipoDeServicio == TipoDeServicio.PREMIUM))
	    this.acumuladorTiempoEnCola[0]++;
	
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    this.acumuladorTiempoEnCola[1]++;
    }
    
    /**
     * Devuelve el tiempo de espera acumulado en la cola indicada
     * @param tipoDeServicio TipoDeServicio requerido
     * @return -1 Si el TipoDeServicio es inexistente 
     */
    public int getTiempoEnCola(TipoDeServicio tipoDeServicio){
	if ((tipoDeServicio == TipoDeServicio.ECONOMICO) || (tipoDeServicio == TipoDeServicio.COMPLETO)
		 || (tipoDeServicio == TipoDeServicio.PREMIUM))
	    return this.acumuladorTiempoEnCola[0];
	
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    return this.acumuladorTiempoEnCola[1];
	
	return -1;
    }
    
    /**
     * Setea en 0 el tiempo de espera para la cola indicada
     * @param tipoDeServicio TipoDeServicio requerido
     */
    public void resetTiempoEnCola(TipoDeServicio tipoDeServicio){
	if ((tipoDeServicio == TipoDeServicio.ECONOMICO) || (tipoDeServicio == TipoDeServicio.COMPLETO)
		 || (tipoDeServicio == TipoDeServicio.PREMIUM))
	    this.acumuladorTiempoEnCola[0] = 0;
	
	if (tipoDeServicio == TipoDeServicio.ENCERADO)
	    this.acumuladorTiempoEnCola[1] = 0;
    }
    
}
