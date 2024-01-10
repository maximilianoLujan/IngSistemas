public interface ManejadorSolicitudes {
	public void setNext(ManejadorSolicitudes handler);
	public void handle(Solicitud solicitud);
	public String getNombre();
}