package ProductorConsumidor;

public interface IBuffer<T> {
	
	void put(T elemento);
	T get();
}
