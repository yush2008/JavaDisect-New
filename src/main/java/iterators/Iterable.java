package iterators;

public interface Iterable<T> {
	boolean hasNext();

	T next();
}