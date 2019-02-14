package hits;

import java.util.ArrayList;
import java.util.List;

import bag.Bag;

public class Hit {

	private List<Commit> commits = new ArrayList<Commit>();
	
	public void agregarCommit(Commit commit) {
		commits.add(commit);
	}
	
	public void ejecutar(Bag bag) {
		commits.stream().forEach(commit -> commit.ejecutar(bag));
	}
	
	public void deshacer(Bag bag) {
		commits.stream().forEach(commit -> commit.deshacer(bag));
	}
	
}
