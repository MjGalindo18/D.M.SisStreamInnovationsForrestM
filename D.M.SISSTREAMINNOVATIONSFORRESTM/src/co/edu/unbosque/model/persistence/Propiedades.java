package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades implements IFileManager {

	private final String ruta = "./Data/";
	private final String archivoConfiguracion = "Configuracion.properties";
	private Properties prop;

	public Propiedades() {
		prop = new Properties();
	}

	@Override
	public boolean escribir(String dato) {
		String[] listaDatos = dato.split("~");
		try {
			prop.setProperty("nombreEmisora", listaDatos[0]);
			prop.setProperty("modoTransmision", listaDatos[1]);
			prop.setProperty("tipoMusica", listaDatos[2]);
			prop.store(new FileOutputStream(ruta + archivoConfiguracion), null);
		} catch (IOException ex) {
			return false;
		}
		return true;
	}

	@Override
	public String leer(String dato) {
		Properties props = new Properties();
		try {
			prop.load(new FileInputStream(ruta + archivoConfiguracion));
			props.load(new FileInputStream(ruta + "Componentes.properties"));
			return props.getProperty(dato);

		} catch (IOException e) {
			return null;
		}
	}

	public String leer(String dato, String archivo) {
		try {
			prop.load(new FileInputStream(ruta + archivo));
			return prop.getProperty(dato);
		} catch (IOException e) {
			return null;
		}
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getArchivoConfiguracion() {
		return archivoConfiguracion;
	}

}
