package co.edu.unbosque.model;

public class Cancion {

	private String nombre;
	private String genero;
	private String autor;
	private String nombreArchivo;

	public Cancion(String nombre, String genero, String autor, String nombreArchivo) {
		this.nombre = nombre;
		this.genero = genero;
		this.autor = autor;
		this.nombreArchivo = nombreArchivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}
