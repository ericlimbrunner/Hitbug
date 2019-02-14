package bag;

public class Video extends ContenidoMultimedia{

	public Video(String nombre) {
		super(nombre);
	}
	private String descripcion;
	private String url;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
