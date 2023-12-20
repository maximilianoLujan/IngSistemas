public class Programa {

	public static void main(String[] args) {
		Solicitud desarrollo = new Solicitud(Solicitud.capacitacion);
		Solicitud vacaciones = new Solicitud(Solicitud.vacaciones);
		Solicitud invalida = new Solicitud("Solicitud invalida");
		ManejadorSolicitudes gerente = new GerenteDeDepartamento();
		ManejadorSolicitudes rrhh = new RecursosHumanos();
		ManejadorSolicitudes directorFinanciero = new DirectorFinanciero();
		ManejadorSolicitudes directorDesarrollo = new DirectorDeDesarrolloProfesional();
		gerente.setNext(rrhh);
		rrhh.setNext(directorFinanciero);
		directorFinanciero.setNext(directorDesarrollo);
		
		gerente.handle(desarrollo);
		System.out.println("               ----------------------------------------------------------               ");
		gerente.handle(vacaciones);
		System.out.println("               ----------------------------------------------------------               ");
		gerente.handle(invalida);
		
		
		

	}

}