package hits;

import bag.Bag;

public class EditarTitulo implements Commit {
	
	private String tituloNuevo;
	private String tituloViejo;
	
	public EditarTitulo(String tituloNuevo) {
		this.tituloNuevo = tituloNuevo;
	}

	@Override
	public void ejecutar(Bag bag) {
		tituloViejo = bag.getNombre();
		bag.editarNombre(tituloNuevo);
	}

	@Override
	public void deshacer(Bag bag) {
		bag.editarNombre(tituloViejo);
	}

}
