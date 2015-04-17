
public class Servicio {
	
	private TipoDeServicio servicio;
	private boolean encera;
	private int tiempo;
	private int costo;
	
	public Servicio(){
		
		this.servicio = DeterminadorDeServicio.getServicio();
		this.encera = DeterminadorDeServicio.getEncerado();
		
		if (TipoDeServicio = algo){
			this.tiempo = prelavado.getTiempo() + etc;
		} else if (TipoDeServicio = otro){
			this.tiempo = algo;
		}
	}
	
	public int getTiempoLavado(){
		return this.tiempo;
	}
	
	public int getCosto(){
		return this.costo;
	}
}
