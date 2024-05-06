package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileManager implements IFileManager {

	private final String RUTA_PISTAS = "./Data/Pistas.txt";
	private final String RUTA_PARRILLA = "./Data/Parrilla.txt";

	@Override
	public boolean escribir(String dato) {
		String linea = dato + "\n";
		File f = new File(RUTA_PISTAS);
		try (FileWriter fw = new FileWriter(f, true); PrintWriter pw = new PrintWriter(fw);) {
			pw.print(linea);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean escribir(String[] datos) {
		String linea = datos[0] + "~" + datos[1] + "~" + datos[2] + "~" + datos[3] + "\n";
		File f = new File(RUTA_PARRILLA);
		try (FileWriter fw = new FileWriter(f, true); PrintWriter pw = new PrintWriter(fw);) {
			pw.print(linea);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String leer(String ruta) {
		String linea = "";
		String data = "";
		File f = new File(ruta);
			if (f.exists()) {
				try (BufferedReader br = new BufferedReader(new FileReader(f))) {
					linea = br.readLine();

					while (linea != null) {
						data += linea + "\n";
						linea = br.readLine();
					}
				} catch (Exception e) {
					return null;
				}
			} else {
				try {
					f.createNewFile();
				} catch (IOException e) {
					return null;
				}
			}
		return data;
	}

	public boolean copiarCancion(String ruta, String nombreCancion) {
		try {
			File archivoEntrada = new File(ruta.trim());
			if (archivoEntrada.canRead()) {
				File archivoDestino = new File("./Canciones/" + nombreCancion.trim() + ".mp3");
				Files.copy(archivoEntrada.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void borrarArchivoParrilla() {
		File file = new File(RUTA_PARRILLA);
		if (file.exists()) {
			file.delete();
		}
	}

	public String getRUTA_PISTAS() {
		return RUTA_PISTAS;
	}

	public String getRUTA_PARRILLA() {
		return RUTA_PARRILLA;
	}

}
