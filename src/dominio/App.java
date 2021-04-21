package dominio;

import java.time.Instant;
import java.time.LocalDate;

import excepciones.*;

public class App {
	public static void main(String[] args) throws AlquilerNoEntregadoException, AgendaOcupadaException,OficioNoCoincideException, TrabajadorNoAsignadoException {
		//Usuarios
		Usuario yo= new Usuario();
		
		//Trabajadores
		Trabajador trabajador1= new Trabajador("Pedro", "pedrito@gamil", 300.0, 0.3, Oficio.ALBANILERIA);
		Trabajador trabajador2= new Trabajador("Anto", "anto@gmail", 400.0, 0.35,Oficio.CARPINTERIA);
		Trabajador trabajador3= new Trabajador("Santi", "santi@gmail", 400.0, 0.35,Oficio.CARPINTERIA);
		
		//Herramientas
		Herramienta herramienta1= new Herramienta("Martillo", 50.0);
		Herramienta herramienta2= new Herramienta("Taladro", 60.0);
		Herramienta herramienta3= new Herramienta("Escalera", 30.0);
		
		//Servicios
		ServicioEstandar servEstandar1= new ServicioEstandar("Hacer una mesa",Oficio.CARPINTERIA,false, 400.0, 6.0);
		ServicioPersonalizado servPersonalizado1= new ServicioPersonalizado("Revisar cañerias, limpiar tanque", Oficio.CARPINTERIA, true, 2000.0,700.0,200.0);
		
		//Trabajos
		Trabajo trabajo1= new Trabajo(Instant.now().plusSeconds(86400),servEstandar1);
		Trabajo trabajo2= new Trabajo(Instant.now().plusSeconds(86400*2),servPersonalizado1);
		Trabajo trabajo3= new Trabajo(Instant.now().plusSeconds(86400),servPersonalizado1);
		
		//Alquileres
		Alquiler alquiler1= new Alquiler(herramienta1,4);
		Alquiler alquiler2= new Alquiler(herramienta2,4);
		Alquiler alquiler3= new Alquiler(herramienta3,4);
		System.out.println("El alquiler 1 está en mora?: "+ alquiler1.enMora());
		System.out.println("El alquiler 1 está finalizado?: "+ alquiler1.finalizado());
		//alquiler1.devolver();
		//System.out.println("Luego de devolver...El alquiler 1 está finalizado?: "+ alquiler1.finalizado());
	
		
		//Contratacion alquiler1 alquiler correcto
		try {
			yo.contratar(alquiler1);
		}catch( AlquilerNoEntregadoException|TrabajadorNoAsignadoException e){
			e.printStackTrace();
		}
		
		//Contratacion alquiler2 alquiler correcto
		try {
			yo.contratar(alquiler2);
		}catch( AlquilerNoEntregadoException|TrabajadorNoAsignadoException e){
			e.printStackTrace();
		}
		
		//Contratacion 3 debe fallar porque tengo dos alquileres sin devolver (si tengo comentado el que devolvi antes)
		try {
			yo.contratar(alquiler3);
		}catch( AlquilerNoEntregadoException|TrabajadorNoAsignadoException e){
			e.printStackTrace();
		}
		
		
		//Agrego trabajo1 a trabajador2 --> correcto
		try {
			trabajador2.agregarTareas(trabajo1);
		}catch(  OficioNoCoincideException| AgendaOcupadaException e){
			e.printStackTrace();
		}
		
		//Agrego trabajo2 a trabajador 3
		try {
			trabajador3.agregarTareas(trabajo2);
		}catch(  OficioNoCoincideException| AgendaOcupadaException e){
			e.printStackTrace();
		}
				
		//Agrego un trabajo a un trabajador --> no deberia porque el trabajador es albañil y el trabajo requiere carpintero
		try{
			trabajador1.agregarTareas(trabajo1);
		}catch(  OficioNoCoincideException| AgendaOcupadaException e){
			e.printStackTrace();
		}			
		
		//Agrego un trabajo a un trabajador --> incorrecto, ya tiene un trabajo en ese dia
		
		try{
			trabajador2.agregarTareas(trabajo3);
		}catch(  OficioNoCoincideException| AgendaOcupadaException e){
			e.printStackTrace();
		}	
		
				
		//Contratacion 4 -> el trabajo1 fue asignado al trabajador2 -> correcto
		try {
			yo.contratar(trabajo1);
		}catch( AlquilerNoEntregadoException|TrabajadorNoAsignadoException e){
			e.printStackTrace();
		}
	
		
		//Contratación 5 --> TrabajoNoAsignadoException
		try {
			yo.contratar(trabajo3);
		}catch( AlquilerNoEntregadoException|TrabajadorNoAsignadoException e){
			e.printStackTrace();
		}
	
		//VAMOS A MOSTRAR LA LISTA DE TRABAJOS ASIGNADOS A CADA TRABAJADOR
		System.out.print("Trabajos del trabajador1: ");
		trabajador1.mostrarTrabajos(); //no tiene ninguno
		
		System.out.print("Trabajos del trabajador2: ");
		trabajador2.mostrarTrabajos(); //tiene el trabajo1
		
		System.out.print("Trabajos del trabajador3: ");
		trabajador3.mostrarTrabajos();//trabajo2
		
		//VAMOS A MOSTRAR LA LISTA DE CONTRATABLES DEL USUARIO
		System.out.println("Contratables del usuario 'yo': ");
		yo.mostrarContrataciones(); // tiene que tener-> alquiler1, alquiler2,trabajo1
		
		//costo
		System.out.println(trabajo1.costo());
		System.out.println(trabajo2.costo());
		System.out.println(alquiler2.costo());
	}
}
