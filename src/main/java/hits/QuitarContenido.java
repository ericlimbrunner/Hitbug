package hits;

import bag.Bag;
import bag.Contenido;

public class QuitarContenido implements Commit {
	
	private Contenido contenido;
	
	public QuitarContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	@Override
	public void ejecutar(Bag bag) {
		bag.quitarContenido(contenido);
	}

	@Override
	public void deshacer(Bag bag) {
		bag.agregarContenido(contenido);
	}

}
