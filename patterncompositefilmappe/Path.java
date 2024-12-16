package patterncompositefilmappe;

public abstract class Path {
	
	public abstract int size();
	
	public void addPath(Path path) {
		throw new UnsupportedOperationException();
	}
	public void removePath(Path path) {
		throw new UnsupportedOperationException();
	}
	public Path getChild(int i) {
		throw new UnsupportedOperationException();
	}
	

}
