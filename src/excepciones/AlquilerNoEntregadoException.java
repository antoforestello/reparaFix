package excepciones;

public class AlquilerNoEntregadoException extends Exception {

		public AlquilerNoEntregadoException() {
			super("Ya cuenta con más de dos alquileres sin devolcuión");
		}
}
