package excepciones;

public class AlquilerNoEntregadoException extends Exception {

		public AlquilerNoEntregadoException() {
			super("Ya cuenta con m�s de dos alquileres sin devolcui�n");
		}
}
