package hits;

import bag.Bag;

public interface Commit {

	public void ejecutar(Bag bag);
	public void deshacer(Bag bag);
	
}
