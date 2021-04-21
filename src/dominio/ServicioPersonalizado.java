package dominio;

import dominio.Oficio;
import dominio.Servicio;
import dominio.Trabajador;

public class ServicioPersonalizado extends Servicio {
	//Variables
	private Double valorPresupuestado;
	private Double costoMateriales;
	private Double costoTransporte;
	
	//Constructor
	public ServicioPersonalizado(String nombre,Oficio oficio, boolean urgente,Double valorPresupuestado,Double costoMateriales, Double costoTransporte) {
		super(oficio, urgente, nombre);
		this.valorPresupuestado=valorPresupuestado;
		this.costoMateriales=costoMateriales;
		this.costoTransporte=costoTransporte;
		
	}
	
	//Metodos
	@Override
	public Double costo(Trabajador t) {
		Double costo = this.valorPresupuestado+this.costoMateriales+this.costoTransporte;
		if(this.urgente) {
		costo = costo*(1+this.porcUrgente);
		}
		return costo;
	}
	
}
