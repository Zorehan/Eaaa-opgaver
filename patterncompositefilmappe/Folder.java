package patterncompositefilmappe;
import java.util.ArrayList;
import java.util.List;
public class Folder extends Path {
	private List<Path> paths;
	
	public Folder() {
		paths = new ArrayList<Path>();
	}

	public void addPath(Path path) {
		if (!paths.contains(path)) {
			paths.add(path);
		}
	}
	
	public void removePath(Path path) {
		paths.remove(path);
	}
	public Path getChild(int i) {
		if (i>=0 && i < paths.size()) {
			return paths.get(i);
		}
		else return null;
		
	}
	
	@Override
	public int size() {
		int sum = 0;
		for(Path p: paths) {
			sum+= p.size();
		}
		return sum;
	}


}
