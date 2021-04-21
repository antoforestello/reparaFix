package dominio;

import dominio.Oficio;

public class ServicioEstandar extends Servicio {
	//Variables
	private Double montoFijo;
	private Double horas;
	private String descripcion;

	//Constructor
	public ServicioEstandar(String nombre,Oficio oficio, boolean urgente, Double montoFijo,Double horas) {
		super(oficio, urgente, nombre);
		this.montoFijo=montoFijo;
		this.horas=horas;
	}

	//metodos
	
	@Override
	public Double costo(Trabajador trabajador) {
		Double costo = montoFijo+horas*trabajador.getPorcComision();
		if(this.urgente) {
			costo=costo*(1+this.porcUrgente);
		}
		return costo;
	}
	
	
	
}