package dominio;

import java.util.ArrayList;
import excepciones.*;
public class Usuario {
	//Variables
	private ArrayList<Contratable> contrataciones;
	
	//Constructor
	public Usuario() {
		contrataciones = new ArrayList<Contratable>();
	}
	
	//Metodos
	public void contratar(Contratable c) throws AlquilerNoEntregadoException,TrabajadorNoAsignadoException{
		if(c.esAlquiler()) {
			if(this.tieneMuchosAlquileres()) {
				throw new AlquilerNoEntregadoException();
			}else {
				this.contrataciones.add(c);
			}
		}else if(c.esTrabajo()) {
			if(!c.tieneTrabajadorAsignado()) {
				throw new TrabajadorNoAsignadoException();
			}else {
			this.contrataciones.add(c);
			}
			}
	}
	
	public boolean tieneMuchosAlquileres() {
		int count=0;
		int maxNoDevueltos=2;
		boolean rdo=false;
		for(Contratable c: contrataciones) {
			if(c.esAlquiler() && !c.finalizado()) {
				count++;
			}
		}
		if(count>=maxNoDevueltos) {
			rdo=true;
		}
		return rdo;
	}
	
	public void mostrarContrataciones() {
		for(Contratable c: contrataciones) {
			System.out.print("("+ c.toString()+") ");
		}
		System.out.println("");
	}

}
