package bag;

import java.util.List;

public abstract class ContenidoMultimedia implements Contenido {

	protected String nombre;
	
	public ContenidoMultimedia(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void editarNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void contenidosMultimedia(List<Contenido>contenidos) {
		contenidos.add(this);
	}
	
	public int cantContenidos() {
		return 1;
	}

}
