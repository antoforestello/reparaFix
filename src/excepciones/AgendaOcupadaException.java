package excepciones;

import java.time.Instant;


public class AgendaOcupadaException extends Exception {
	public AgendaOcupadaException(Instant fecha) {
		super("El día: "+ fecha.toString()+ " el trabajador solicitado está ocupado");
	}
}
