package dominio;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import excepciones.*;

public class Trabajador {
	//Variables
	private String nombre;
	private String email;
	private Double costoHora; 
	private Double porcComision;
	private Oficio oficio; 
	private ArrayList<Trabajo> trabajos;
	
	//Constructor
	public Trabajador(String nombre, String email, Double costoHora, Double porcComision, Oficio oficio) {
		trabajos = new ArrayList<Trabajo>();
		this.nombre=nombre;
		this.email=email;
		this.costoHora=costoHora;
		this.porcComision=porcComision;
		this.oficio=oficio;
	}
	
	//Getters and setters
	public Double getPorcComision() {
		return porcComision;
	}
	public String getNombre() {
		return nombre;
	}
	

	//Metodos
	public void asignarTrabajo(Trabajo t){
		trabajos.add(t);
	}
	
	public void agregarTareas(Trabajo t) throws OficioNoCoincideException, AgendaOcupadaException{
		if(this.oficio != t.oficioTrabajo()) {
			throw new OficioNoCoincideException(this.oficio, t.oficioTrabajo());
		}else if(this.estaOcupado(t.getFecha())) {
			throw new AgendaOcupadaException(t.getFecha());
		}else {
			trabajos.add(t);
			t.setTrabajador(this);
		}
	}
	
	public boolean estaOcupado(Instant unaFecha) {
		boolean resultado= false;
		for(Trabajo t: trabajos) {
			if(t.getFecha().equals(unaFecha) ) {
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public void mostrarTrabajos() {
		for(Trabajo t:trabajos) {
			System.out.print("( "+ t.toString()+" )");
		}
		System.out.println(" ");
	}
}

