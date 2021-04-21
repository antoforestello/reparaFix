package excepciones;

import dominio.Oficio;

public class OficioNoCoincideException extends Exception {

		public OficioNoCoincideException(Oficio oficioTrabajador, Oficio oficioTrabajo) {
			super("El trabajador que seleccionó corresponde al oficio: "+ oficioTrabajador.toString()+" y el trabajo requerido solicita un trabajador del siguiente oficio: "+ oficioTrabajo.toString());
			
		}
}
