package dominio;

import java.time.Instant;
import java.time.LocalDate;

public class Trabajo implements Contratable{
	private Instant fecha;
	private Servicio servicio; 
	private Trabajador trabajador; 
	
	

	//Constructor
	public Trabajo(Instant fecha, Servicio servicio) {
		this.fecha=fecha;
		this.servicio=servicio;
	}
	
	//Getters and setters
	public Instant getFecha() {
		return fecha;
	}
	
	public Trabajador getTrabajador() {
		return trabajador;
	}
	
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	//Metodos
	@Override
	public Double costo() {
		return servicio.costo(trabajador);
	}
	
	public Oficio oficioTrabajo() {
		return servicio.getOficio();
	}

	public boolean finalizado() {
		return fecha.isBefore(Instant.now());		
	}
	
	public boolean esAlquiler() {
		return false;
	}
	
	public boolean esTrabajo() {
		return true;
	}
	
	public String toString() {
		return this.fecha.toString()+ ", "+ trabajador.getNombre()+", "+servicio.getDescripcion();
	}

	@Override
	public boolean tieneTrabajadorAsignado() {
		return trabajador!=null;
	}
	

}
