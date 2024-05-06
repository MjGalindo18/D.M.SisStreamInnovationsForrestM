package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.model.persistence.Propiedades;

public class DMRadio {

	private FileManager fileManager;
	private Propiedades propiedades;
	private ArrayList<Cancion> canciones;
	private PlayList playList;
	private String nombreEmisora;
	private String modoTransmision;
	private String tipoDeMusica;
	private String[] titulosPanelDatosEmisora;
	private String[] titulosPanelParrilla;
	private String[] titulosPanelAgregarCancion;
	private String[] titulosPanelInformacionEmisora;
	private String[] titulosView;
	private String[] mensajesError;
	private String mensajeAceptar;
	private int contadorCanciones;

	public DMRadio() {
		fileManager = new FileManager();
		propiedades = new Propiedades();
		canciones = new ArrayList<>();
		playList = new PlayList();
	}

	public void asignarInformacionEmisora(String nombreEmisora, String modoTransmision, String tipoMusica) {
		this.nombreEmisora = nombreEmisora;
		this.modoTransmision = modoTransmision;
		this.tipoDeMusica = tipoMusica;
	}

	public void gestionarParrilla(String nombreCancion) {
		String[] datosCancion = new String[4];

		for (Cancion cancion : canciones) {

			if (cancion.getNombre().equals(nombreCancion)) {
				playList.agregarPistaMusical(cancion);
				datosCancion[0] = cancion.getNombre();
				datosCancion[1] = cancion.getAutor();
				datosCancion[2] = cancion.getGenero();
				datosCancion[3] = cancion.getNombreArchivo();
				fileManager.escribir(datosCancion);
			}
// busca una canción por su nombre en una lista de canciones y, si la encuentra, la agrega a una lista de reproducción y
//escribe algunos datos de la canción utilizando un objeto fileManager
		}
	}

	public String[] llenarParrilla(String nombreCancion) {
		String[] datosCancion = new String[3];

		for (Cancion cancion : canciones) {

			if (cancion.getNombre().equals(nombreCancion)) {
				playList.agregarPistaMusical(cancion);
				datosCancion[0] = cancion.getNombre();
				datosCancion[1] = cancion.getAutor();
				datosCancion[2] = cancion.getGenero();

			}
		}
		return datosCancion;
	}
//El método devuelve el arreglo datosCancion. busca una canción por su nombre en una lista de canciones y
// si la encuentra, agrega la canción a una lista de reproducción y devuelve un arreglo con algunos datos
//de la canción encontrada.


	public void gestionarCaracteristicas() {

		try {
			nombreEmisora = propiedades.leer("nombreEmisora", propiedades.getArchivoConfiguracion());
			modoTransmision = propiedades.leer("modoTransmision", propiedades.getArchivoConfiguracion());
			tipoDeMusica = propiedades.leer("tipoMusica", propiedades.getArchivoConfiguracion());
			titulosPanelDatosEmisora = propiedades.leer("titulosPanelDatosEmisora").split("~");
			titulosPanelParrilla = propiedades.leer("titulosPanelParrilla").split("~");
			titulosPanelAgregarCancion = propiedades.leer("titulosPanelAgregarCancion").split("~");
			titulosPanelInformacionEmisora = propiedades.leer("titulosPanelInformacionEmisora").split("~");
			titulosView = propiedades.leer("titulosView").split("~");
			mensajesError = propiedades.leer("mensajesError").split("~");
			mensajeAceptar = propiedades.leer("mensajesAceptar");
		} catch (Exception e) {
			escribirArchivoEmisora("");
			gestionarCaracteristicas();
		}
//se encarga de leer varias propiedades de configuración y realizar acciones adicionales en caso de que ocurra una excepción durante la lectura.

	}

	public boolean agregarPistaMusical(String nombreCancion, String nombreArtista, String generoMusical,
			String nombreArchivoMusica) {
		canciones.add(new Cancion(nombreCancion, generoMusical, nombreArtista, nombreArchivoMusica));
		return escribirArchivoPistaMusical(nombreCancion, nombreArtista, generoMusical, nombreArchivoMusica);
//crea una nueva instancia de la clase Cancion con los datos proporcionados y la agrega a una lista de canciones. Luego, llama a un método escribirArchivoPistaMusical
		//y devuelve el resultado de esa llamada.
	}

	public boolean escribirArchivoEmisora() {
		return propiedades.escribir(nombreEmisora + "~" + modoTransmision + "~" + tipoDeMusica);

	}

	public boolean escribirArchivoEmisora(String s) {
		return propiedades.escribir(s + "~" + s + "~" + s + "~" + "ES");
	}

	public void cargarAtributosArchivoPistas() {
		String[] pistas = fileManager.leer(fileManager.getRUTA_PISTAS()).split("\n");
		for (int i = 0; i < pistas.length; i++) {
			String[] atributo = pistas[i].split("~");
			if (atributo.length >= 4) {
				canciones.add(new Cancion(atributo[0], atributo[2], atributo[1], atributo[3]));
			} else {
				i = pistas.length;
			}
		}
// lee un archivo de pistas utilizando un objeto fileManager y divide su contenido en líneas
//Si los atributos tienen una longitud mayor o igual a 4, se crea una nueva instancia de la clase Cancion y se agrega a la lista canciones.


	}

	public void cargarInformacionArchivoParrilla() {
		ArrayList<Cancion> pistas = new ArrayList<>();
		String[] pistasArchivo = fileManager.leer(fileManager.getRUTA_PARRILLA()).split("\n");
		for (int i = 0; i < pistasArchivo.length; i++) {
			String[] atributo = pistasArchivo[i].split("~");
			if (atributo.length >= 4) {
				pistas.add(new Cancion(atributo[0], atributo[2], atributo[1], atributo[3]));
			} else {
				i = pistasArchivo.length;
			}
		}
		playList.cargarParrilla(pistas);
//lee un archivo de parrilla utilizando un objeto fileManager y divide su contenido en líneas.
// Si los atributos tienen una longitud mayor o igual a 4, se crea una nueva instancia de la clase Cancion y se agrega al objeto ArrayList pistas.
//llama al método cargarParrilla del objeto playList para cargar las pistas en la lista de reproducción.
	}

	public String[][] asignarDatosTablaAgregarCancion() {
		String[][] tabla = new String[canciones.size()][4];
		int count = 1;
		for (int i = 0; i < canciones.size(); i++) {
			tabla[i][0] = Integer.toString(count);
			tabla[i][1] = canciones.get(i).getNombre();
			tabla[i][2] = canciones.get(i).getAutor();
			tabla[i][3] = canciones.get(i).getGenero();
			count++;
		}
		contadorCanciones = count;
		return tabla;
//crea una matriz bidimensional de tipo String y asigna los datos de las canciones almacenadas en la lista canciones a la matriz. 
	}

	public String[][] asignarDatosTablaParrilla() {
		String[][] tabla = new String[playList.getPistasMusicales().size()][4];
		int count = 1;
		for (int i = 0; i < playList.getPistasMusicales().size(); i++) {
			tabla[i][0] = Integer.toString(count);
			tabla[i][1] = playList.getPistasMusicales().get(i).getNombre();
			tabla[i][2] = playList.getPistasMusicales().get(i).getAutor();
			tabla[i][3] = playList.getPistasMusicales().get(i).getGenero();
			count++;
		}
		playList.setContadorParrilla(count);
		return tabla;
//rea una matriz bidimensional de tipo String y asigna los datos de las pistas musicales almacenadas en el objeto playList a la matriz. 
	}

	public String[] generarListaDeCancionesDisponibles() {
		String[] salida = new String[canciones.size()];
		for (int i = 0; i < canciones.size(); i++) {
			salida[i] = canciones.get(i).getNombre();
		}
		return salida;
//crea un arreglo unidimensional de tipo String y asigna los nombres de las canciones almacenadas en la lista canciones a dicho arreglo. 
	}

	public void verificarExtensionArchivo(String rutaArchivo, String nombreCancion) throws Exception {
		String mimeType = rutaArchivo.substring(rutaArchivo.lastIndexOf(".") + 1, rutaArchivo.length());
		if (!mimeType.contains("mp3")) {
			throw new Exception(mensajesError[2]);
		}
		for (Cancion pistaMusical : canciones) {
			if (nombreCancion.equals(pistaMusical.getNombre().trim())) {
				throw new Exception(mensajesError[3]);
			}
		}
	}

	public boolean escribirArchivoPistaMusical(String nombreCancion, String nombreArtista, String generoMusical,
			String nombreArchivoMusica) {
		return fileManager
				.escribir(nombreCancion + "~" + nombreArtista + "~" + generoMusical + "~" + nombreArchivoMusica);
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public Propiedades getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}

	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	public PlayList getPlayList() {
		return playList;
	}

	public void setPlayList(PlayList playList) {
		this.playList = playList;
	}

	public String getNombreEmisora() {
		return nombreEmisora;
	}

	public void setNombreEmisora(String nombreEmisora) {
		this.nombreEmisora = nombreEmisora;
	}

	public String getModoTransmision() {
		return modoTransmision;
	}

	public void setModoTransmision(String modoTransmision) {
		this.modoTransmision = modoTransmision;
	}

	public String getTipoDeMusica() {
		return tipoDeMusica;
	}

	public void setTipoDeMusica(String tipoDeMusica) {
		this.tipoDeMusica = tipoDeMusica;
	}

	public String[] getTitulosPanelDatosEmisora() {
		return titulosPanelDatosEmisora;
	}

	public void setTitulosPanelDatosEmisora(String[] titulosPanelDatosEmisora) {
		this.titulosPanelDatosEmisora = titulosPanelDatosEmisora;
	}

	public String[] getTitulosPanelParrilla() {
		return titulosPanelParrilla;
	}

	public void setTitulosPanelParrilla(String[] titulosPanelParrilla) {
		this.titulosPanelParrilla = titulosPanelParrilla;
	}

	public String[] getTitulosPanelAgregarCancion() {
		return titulosPanelAgregarCancion;
	}

	public void setTitulosPanelAgregarCancion(String[] titulosPanelAgregarCancion) {
		this.titulosPanelAgregarCancion = titulosPanelAgregarCancion;
	}

	public String[] getTitulosPanelInformacionEmisora() {
		return titulosPanelInformacionEmisora;
	}

	public void setTitulosPanelInformacionEmisora(String[] titulosPanelInformacionEmisora) {
		this.titulosPanelInformacionEmisora = titulosPanelInformacionEmisora;
	}

	public String[] getTitulosView() {
		return titulosView;
	}

	public void setTitulosView(String[] titulosView) {
		this.titulosView = titulosView;
	}

	public String[] getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(String[] mensajesError) {
		this.mensajesError = mensajesError;
	}

	public String getMensajeAceptar() {
		return mensajeAceptar;
	}

	public void setMensajeAceptar(String mensajeAceptar) {
		this.mensajeAceptar = mensajeAceptar;
	}

	public int getContadorCanciones() {
		return contadorCanciones;
	}

	public void setContadorCanciones(int contadorCanciones) {
		this.contadorCanciones = contadorCanciones;
	}

}
