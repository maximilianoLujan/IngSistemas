public class DirectorFinanciero implements ManejadorSolicitudes{

	String nombre = "Director Financiero";
	ManejadorSolicitudes siguiente;
	
	@Override
	public void setNext(ManejadorSolicitudes handler) {
		this.siguiente = handler;
	}

	@Override
	public void handle(Solicitud solicitud) {
		if(solicitud.getTipoSolicitud().compareTo(Solicitud.gastos) == 0) {
			System.out.println("La solicitud de " + Solicitud.gastos + " ha sido atendida "
					+ "por el " + this.nombre);
			return;
		}
		System.out.println("El " + this.nombre + " no puede atender solicitudes de " +
				solicitud.getTipoSolicitud() + ", pasando la solicitud al " + siguiente.getNombre());
		siguiente.handle(solicitud);
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
