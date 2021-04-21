package excepciones;

public class TrabajadorNoAsignadoException extends Exception {
	public TrabajadorNoAsignadoException() {
		super("El trabajo no cuenta con un trabajador asignado");
	}
}
