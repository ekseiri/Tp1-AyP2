public class Ticket 
//revisar, la idea era que mandandole el TipoDeServicio se referencie al servicio creado en el main
{
	private Servicio servicio;
	int horaDeLlegada;
	// encerado

	public Ticket(TipoDeServicio servicioElegido)
	{
		if(servicioElegido==TipoDeServicio.ECONOMICO)
		{
			this.servicio = economico;
		}
		else if(servicioElegido==TipoDeServicio.COMPLETO)
		{
			this.servicio = completo;
		}
		else if(servicioElegido==TipoDeServicio.PREMIUM)
		{
			this.servicio = premium;
		}
	}
}
