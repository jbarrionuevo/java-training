package exercices.day6.dependency_injection.interfaces;

public interface GenericServiceInterface<T,S> {
	
	public default void save(T entity){
		
	}
}
