package excepciones;

import java.time.Instant;


public class AgendaOcupadaException extends Exception {
	public AgendaOcupadaException(Instant fecha) {
		super("El d�a: "+ fecha.toString()+ " el trabajador solicitado est� ocupado");
	}
}
