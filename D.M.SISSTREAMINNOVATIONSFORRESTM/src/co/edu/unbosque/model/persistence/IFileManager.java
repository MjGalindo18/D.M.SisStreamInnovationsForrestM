package co.edu.unbosque.model.persistence;

public interface IFileManager {

	public abstract boolean escribir(String dato);

	public abstract String leer(String dato);
	
}
