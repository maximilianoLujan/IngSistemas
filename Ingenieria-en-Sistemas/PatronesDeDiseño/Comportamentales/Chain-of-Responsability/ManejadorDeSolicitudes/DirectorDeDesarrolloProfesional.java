public class DirectorDeDesarrolloProfesional implements ManejadorSolicitudes{

	String nombre = "Director de desarrollo profesional";
	ManejadorSolicitudes siguiente;
	
	@Override
	public void setNext(ManejadorSolicitudes handler) {
		this.siguiente = handler;
	}

	@Override
	public void handle(Solicitud solicitud) {
		if(solicitud.getTipoSolicitud().compareTo(Solicitud.capacitacion) == 0) {
			System.out.println("La solicitud de " + Solicitud.capacitacion + " ha sido atendida "
					+ "por el " + this.nombre);
			return;
		}
		System.out.println("Solicitud rechazada, esta solicitud no puede ser manejada por ningun departamento");
	}
	
	public String getNombre() {
		return this.nombre;
	}

}