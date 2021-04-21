package dominio;

public class Herramienta {
	//Variables
	private String nombre;
	private Double costoDia; 
	
	//Constructor
	public Herramienta(String nombre, Double costoDia) {
		this.nombre=nombre;
		this.costoDia=costoDia;
	}
	
	//Metodos
	public Double getCostoDia() {
		return costoDia;
	}

	public String getNombre() {
		return nombre;
	}
	
		
}
