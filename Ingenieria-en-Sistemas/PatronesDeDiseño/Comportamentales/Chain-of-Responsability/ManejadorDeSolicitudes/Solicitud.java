public class Solicitud {
	static final String material = "compra de material";
	static final String vacaciones = "solicitud de vacaciones";
	static final String gastos = "aprobacion de gastos";
	static final String capacitacion = "solicitud de capacitacion";
	
	String tipoSolicitud;
	
	public Solicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	public String getTipoSolicitud() {
		return this.tipoSolicitud;
	}
}
