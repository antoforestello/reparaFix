package dominio;

import java.time.Duration;
import java.time.Instant;


public class Alquiler implements Contratable{
	//Variables
	private Double costo;
	private Instant fechaInicio;
	private Instant fechaFin;
	private Herramienta herramienta;
	private Long dias;
	private Instant devuelto;
	//Costructor
	public Alquiler(Herramienta herramienta,long dias) {
		this.fechaInicio= Instant.now();
		this.herramienta = herramienta;
		this.fechaFin=fechaInicio.plusSeconds(86400*dias);
		this.dias=dias;
	}
	//getters y setters
	public Instant getFechaInicio() {
		return fechaInicio;
	}

	public Instant getFechaFin() {
		return fechaFin;
	}
	
		//Metodos
	@Override
	public Double costo() {
		Duration dias= Duration.between(fechaInicio, fechaFin);
		Long cantDias= dias.toDaysPart();
		Double costo= cantDias*herramienta.getCostoDia();
		return costo;
	}
	
	public void devolver() {
		devuelto= Instant.now(); 
	}
	
	public boolean enMora() {
		return ((devuelto==null && fechaFin.isBefore(Instant.now())) || (devuelto !=null && (fechaFin.isBefore(devuelto))));	
	}


	public boolean finalizado() {
		return devuelto!=null;
	}
	
	public boolean esAlquiler() {
		return true;
	}
	
	public boolean esTrabajo() {
		return false;
	}
	
	public String toString() {
		return herramienta.getNombre()+ ", "+ fechaInicio.toString() + ", " + fechaFin.toString();
	}

	@Override
	public boolean tieneTrabajadorAsignado() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
