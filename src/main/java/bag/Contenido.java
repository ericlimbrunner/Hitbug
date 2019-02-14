package bag;

import java.util.List;

public interface Contenido {

	public String getNombre();
	public void editarNombre(String nombre);
	public void contenidosMultimedia(List<Contenido> contenidos);
	public int cantContenidos();
	
}
