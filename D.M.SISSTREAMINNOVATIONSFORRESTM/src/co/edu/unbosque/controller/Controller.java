package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.DMRadio;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View vista;
	private DMRadio dmRadio;

	public Controller() {
		vista = new View(this);
		dmRadio = new DMRadio();
		dmRadio.gestionarCaracteristicas();
		dmRadio.cargarAtributosArchivoPistas();
		dmRadio.cargarInformacionArchivoParrilla();
		dmRadio.getPlayList().generarPlayList();
		actualizarComponentesVista();
		llenarDatosEmisoraTablas();
		verificarDatosEmisora();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//es un método que se ejecuta cuando ocurre una acción en un componente y se utiliza para manejar y responder esta acción

		if (event.getActionCommand().equals(vista.getPanelPrincipal().getPARAMETRIZAR())) {
			vista.mostrarPanelParametrizar();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelPrincipal().getGESTIONAR())) {
			vista.mostrarPanelGestionarCanciones();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelPrincipal().getPROGRAMACION_EMISORA())) {
			vista.mostrarPanelDMRadio();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelParametrosDMRadio().getGUARDAR())) {
			gestionarDatosEmisora();
			vista.getPanelDMRadio().getPanelGeneral().actualizarAtributos(dmRadio.getNombreEmisora(),
					dmRadio.getModoTransmision(), dmRadio.getTipoDeMusica());
			dmRadio.escribirArchivoEmisora();
			vista.habilitarBotones();
			vista.mostrarMensajeAviso("Los parámetros han sido guardados correctamente");
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelParametrosDMRadio().getREGRESAR())) {
			vista.getPanelParametrosDMRadio().restablecerCampos(dmRadio.getNombreEmisora(), dmRadio.getTipoDeMusica(),
					dmRadio.getModoTransmision());
			vista.mostrarPanelPrincipal();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelGestionarCanciones().getAGREGAR())) {
			gestionarIngresoCancion();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelGestionarCanciones().getREGRESAR())) {
			vista.mostrarPanelPrincipal();
			return;
		}

		if (event.getActionCommand()
				.equals(vista.getPanelDMRadio().getPanelEjecucion().getCOMMAND_AGREGAR_PARRILLA())) {
			gestionarAgregarCancionParrilla();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelDMRadio().getPanelPlay().getCOMMAND_REPRODUCIR())) {
			dmRadio.getPlayList().reproducir();
			vista.getPanelDMRadio().getPanelGeneral()
					.actualizarGIFStatus(vista.getPanelDMRadio().getPanelGeneral().getGIFPlay());
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelDMRadio().getPanelPlay().getCOMMAND_PAUSAR())) {
			dmRadio.getPlayList().pausar();
			vista.getPanelDMRadio().getPanelGeneral()
					.actualizarGIFStatus(vista.getPanelDMRadio().getPanelGeneral().getGIFStop());
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelDMRadio().getPanelPlay().getCOMMAND_PARAR())) {
			dmRadio.getPlayList().parar();
			vista.getPanelDMRadio().getPanelGeneral()
					.actualizarGIFStatus(vista.getPanelDMRadio().getPanelGeneral().getGIFStop());
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelDMRadio().getPanelPlay().getCOMMAND_AVANZAR())) {
			dmRadio.getPlayList().reproducirSiguiente();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelDMRadio().getPanelPlay().getCOMMAND_RETROCEDER())) {
			dmRadio.getPlayList().reproducirAnterior();
			return;
		}

		if (event.getActionCommand().equals(vista.getPanelDMRadio().getPanelEjecucion().getCOMMAND_BORRAR_PARRILLA())) {
			gestionarBorradoParrilla();
			return;
		}
	}

	public void gestionarDatosEmisora() {
		if (!vista.getPanelParametrosDMRadio().getCampoTextoNombreEmisora().getText().equals("")
				&& !vista.getPanelParametrosDMRadio().getComboModoTransmision().getSelectedItem()
						.equals("Seleccione...")
				&& !vista.getPanelParametrosDMRadio().getCampoTextoTipoMusica().getText().equals("")) {
			String nombreEmisora = vista.getPanelParametrosDMRadio().getCampoTextoNombreEmisora().getText();
			String modoTransmision = (String) vista.getPanelParametrosDMRadio().getComboModoTransmision()
					.getSelectedItem();
			String tipoMusica = vista.getPanelParametrosDMRadio().getCampoTextoTipoMusica().getText();
			dmRadio.asignarInformacionEmisora(nombreEmisora, modoTransmision, tipoMusica);
			dmRadio.escribirArchivoEmisora();
			dmRadio.gestionarCaracteristicas();
			actualizarComponentesVista();
		} else {
			vista.mostrarMensajeError(dmRadio.getMensajesError()[0]);
			vista.getPanelParametrosDMRadio().restablecerCampos(dmRadio.getNombreEmisora(), dmRadio.getTipoDeMusica(),
					dmRadio.getModoTransmision());
	//se encarga de validar y gestionar los datos de la emisora ingresados por el usuario, realizando diferentes acciones dependiendo de si los campos están vacíos o no.
		}
	}

	public void gestionarIngresoCancion() {
		if (!vista.getPanelGestionarCanciones().getCampoTextoNombreCancion().getText().equals("")
				&& !vista.getPanelGestionarCanciones().getCampoTextoNombreAutor().getText().equals("")
				&& !vista.getPanelGestionarCanciones().getCampoTextoGeneroMusica().getText().equals("")
				&& !vista.getPanelGestionarCanciones().getCampoTextoArchivo().getText().equals("")) {
			String nombreCancion = vista.getPanelGestionarCanciones().getCampoTextoNombreCancion().getText();
			String nombreArtista = vista.getPanelGestionarCanciones().getCampoTextoNombreAutor().getText();
			String genero = vista.getPanelGestionarCanciones().getCampoTextoGeneroMusica().getText();
			String rutaArchivo = vista.getPanelGestionarCanciones().getCampoTextoArchivo().getText();
			try {
				dmRadio.verificarExtensionArchivo(rutaArchivo, nombreCancion);

				if (dmRadio.agregarPistaMusical(nombreCancion, nombreArtista, genero, nombreCancion + ".mp3")
						&& dmRadio.getFileManager().copiarCancion(rutaArchivo, nombreCancion)) {
					int contador = dmRadio.getContadorCanciones();
					dmRadio.setContadorCanciones(contador + 1);
					vista.getPanelGestionarCanciones().actualizarTabla(contador, nombreCancion, nombreArtista, genero);
					vista.getPanelDMRadio().getPanelEjecucion().getComboNombreCancion().addItem(nombreCancion);
					vista.mostrarMensajeAviso(dmRadio.getMensajeAceptar());
					vista.getPanelGestionarCanciones().borrarCampos();
				} else {
					vista.mostrarMensajeError(dmRadio.getMensajesError()[1]);
					vista.getPanelGestionarCanciones().borrarCampos();
				}
			} catch (Exception e) {
				vista.mostrarMensajeError(dmRadio.getMensajesError()[4]);
				vista.getPanelGestionarCanciones().borrarCampos();
			}

		} else {
			vista.mostrarMensajeError(dmRadio.getMensajesError()[0]);
			vista.getPanelGestionarCanciones().borrarCampos();
		}
		// Se encarga de gestionar el ingreso de una nueva canción en la interfaz de usuario.

	}

	public void gestionarAgregarCancionParrilla() {
		if (!vista.getPanelDMRadio().getPanelEjecucion().getComboNombreCancion().getSelectedItem()
				.equals("Seleccionar canción")
				&& !vista.getPanelDMRadio().getPanelEjecucion().getComboNombreCancion().getSelectedItem()
						.equals("Select Song")) {
			String cancion = (String) vista.getPanelDMRadio().getPanelEjecucion().getComboNombreCancion()
					.getSelectedItem();
			dmRadio.gestionarParrilla(cancion);
			dmRadio.getPlayList().agregarCancionPlayList();
			String[] tabla = dmRadio.llenarParrilla(cancion);
			int contador = dmRadio.getPlayList().getContadorParrilla();
			if (contador <= 1) {
				dmRadio.getPlayList().reproducirSiguiente();
				dmRadio.getPlayList().parar();
			}
			dmRadio.getPlayList().setContadorParrilla(contador + 1);
			vista.getPanelDMRadio().getPanelEjecucion().actualizarTabla(contador, tabla[0], tabla[1], tabla[2]);
			vista.getPanelDMRadio().getPanelPlay().manejarBotones(true);

		} else {
			vista.mostrarMensajeError(dmRadio.getMensajesError()[0]);
		}
	//Se encarga de validar y gestionar la adición de una canción realizando diferentes acciones dependiendo de si se ha seleccionado una canción o no
	}

	public void gestionarBorradoParrilla() {

		dmRadio.getPlayList().parar();
		vista.getPanelDMRadio().getPanelGeneral()
				.actualizarGIFStatus(vista.getPanelDMRadio().getPanelGeneral().getGIFStop());
		vista.getPanelDMRadio().getPanelEjecucion().borrarContenidoTabla();
		dmRadio.getPlayList().borrarParrilla();
		dmRadio.getFileManager().borrarArchivoParrilla();
		dmRadio.getPlayList().setContadorParrilla(1);
		vista.getPanelDMRadio().getPanelPlay().manejarBotones(false);
 // se encarga de realizar varias acciones para borrar y restablecer la parrilla de reproducción en la interfaz de usuario.
	}

	public void llenarDatosEmisoraTablas() {
		vista.getPanelDMRadio().getPanelGeneral().actualizarAtributos(dmRadio.getNombreEmisora(),
				dmRadio.getModoTransmision(), dmRadio.getTipoDeMusica());
		vista.getPanelParametrosDMRadio().cargarCampos(dmRadio.getNombreEmisora(), dmRadio.getModoTransmision(),
				dmRadio.getTipoDeMusica());
		vista.getPanelGestionarCanciones().crearTabla(dmRadio.asignarDatosTablaAgregarCancion());

		vista.getPanelDMRadio().getPanelEjecucion().crearTabla(dmRadio.asignarDatosTablaParrilla());
		if (dmRadio.getPlayList().getPistasMusicales().size() == 0) {
			vista.getPanelDMRadio().getPanelPlay().manejarBotones(false);
		}
	// se encarga de llenar los datos en varias tablas de la interfaz basándose en los valores almacenados en dmRadio.
	}

	public void actualizarComponentesVista() {
		vista.getPanelDMRadio().getPanelEjecucion().actualizarPanelParrilla(dmRadio.getTitulosPanelParrilla());
		vista.getPanelDMRadio().getPanelEjecucion()
				.agregarCancionesComboBox(dmRadio.generarListaDeCancionesDisponibles());
		vista.getPanelDMRadio().getPanelGeneral().actualizarPanelDatosEmisora(dmRadio.getTitulosPanelDatosEmisora());
		vista.getPanelParametrosDMRadio().actualizarPanelInformacionEmisora(dmRadio.getTitulosPanelInformacionEmisora(),
				dmRadio.getModoTransmision());
		vista.getPanelGestionarCanciones().actualizarPanelAgregarCancion(dmRadio.getTitulosPanelAgregarCancion());
		vista.getPanelGestionarCanciones().getModeloTabla().fireTableDataChanged();
		// se encarga de actualizar varios componentes en la vista de la interfaz de usuario
	}

	public void verificarDatosEmisora() {

		if (dmRadio.getNombreEmisora().equals("")) {
			vista.mostrarMensajeAviso(
					"Por favor ingresar los datos de la emisora.\nPlease fill the station information.");
			vista.getPestanas().setSelectedIndex(1);
		} else {
			vista.habilitarBotones();
		}
	//se encarga de verificar si se han ingresado los datos de la emisora en la aplicación y toma acciones en consecuencia, mostrando un mensaje de aviso si los datos
		//no están completos y habilitando los botones si los datos están completos.

	}

}
