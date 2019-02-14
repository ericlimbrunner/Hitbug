package bag;

public class Texto extends ContenidoMultimedia {

	public Texto(String nombre) {
		super(nombre);
	}
	private String texto;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
