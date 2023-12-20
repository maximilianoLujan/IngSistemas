public class RecursosHumanos implements ManejadorSolicitudes{
	String nombre = "Recursos humanos";
	ManejadorSolicitudes siguiente;
	
	@Override
	public void setNext(ManejadorSolicitudes handler) {
		this.siguiente = handler;
	}

	@Override
	public void handle(Solicitud solicitud) {
		if(solicitud.getTipoSolicitud().compareTo(Solicitud.vacaciones) == 0) {
			System.out.println("La solicitud de " + Solicitud.vacaciones + " ha sido atendida "
					+ "por " + this.nombre);
			return;
		}
		System.out.println("El " + this.nombre + " no puede atender solicitudes de " +
				solicitud.getTipoSolicitud() + ", pasando la solicitud a el: "  + siguiente.getNombre());
		siguiente.handle(solicitud);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
