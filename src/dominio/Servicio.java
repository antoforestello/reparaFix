package dominio;

import dominio.Oficio;


public abstract class Servicio{
	//Variables
	protected Oficio oficio;
	protected boolean urgente;
	protected Double porcUrgente;
	protected String descripcion;
	
	//Constructor
	public Servicio(Oficio oficio, boolean urgente, String desc) {
		this.descripcion=desc;
		this.oficio=oficio;
		this.urgente=urgente;
		porcUrgente=0.5;
	}
	//Metodos
	public abstract Double costo(Trabajador t);
	
	//getters ans setters
	public Oficio getOficio() {
		return oficio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	

}
