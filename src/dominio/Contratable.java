package dominio;

import java.time.LocalDate;

public interface Contratable {
	//metodos
	public Double costo();
	public boolean finalizado();
	public boolean esAlquiler();
	public boolean esTrabajo();
	public boolean tieneTrabajadorAsignado();
}
