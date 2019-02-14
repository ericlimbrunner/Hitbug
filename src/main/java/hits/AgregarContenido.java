package hits;

import bag.Bag;
import bag.Contenido;

public class AgregarContenido implements Commit {

	private Contenido contenido;
	
	public AgregarContenido(Contenido contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public void ejecutar(Bag bag) {
		bag.agregarContenido(contenido);
	}

	@Override
	public void deshacer(Bag bag) {
		bag.quitarContenido(contenido);
	}

}
