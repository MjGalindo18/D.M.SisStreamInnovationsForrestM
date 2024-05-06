package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelGeneral extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaTituloNombre;
	private JLabel etiquetaNombreEmisora;
	private JLabel etiquetaTituloModo;
	private JLabel etiquetaModoTransmision;
	private JLabel etiquetaTituloTipoMusica;
	private JLabel etiquetaTipoMusica;
	private JLabel etiquetaGIFPlaying;
	private JPanel panelEmisoraInfo;
	private final String rutaGIFPlay = "./Imagenes/Perrito Bailando.gif";
	private final String rutaGIFStop = "./Imagenes/Perrito quieto.jpg";
	private Icon GIFPlay;
	private Icon GIFStop;
	// estas líneas de código definen las rutas de archivo y las variables necesarias para cargar
	//y mostrar un GIF animado y una imagen estática en una interfaz gráfica de usuario.

	public PanelGeneral() {
		setLayout(new GridLayout(2, 1));
		GIFPlay = new ImageIcon(rutaGIFPlay);
		GIFStop = new ImageIcon(rutaGIFStop);
		panelEmisoraInfo = new JPanel();
		panelEmisoraInfo.setLayout(new GridLayout(3, 2));;
		panelEmisoraInfo.setBackground(new Color(244, 226, 232));
		etiquetaTituloNombre = new JLabel();
		etiquetaTituloNombre.setForeground(Color.black);
		etiquetaTituloModo = new JLabel();
		etiquetaTituloModo.setForeground(Color.black);
		etiquetaTituloTipoMusica = new JLabel();
		etiquetaTituloTipoMusica.setForeground(Color.black);
		etiquetaNombreEmisora = new JLabel();
		etiquetaNombreEmisora.setForeground(Color.black);
		etiquetaModoTransmision = new JLabel();
		etiquetaModoTransmision.setForeground(Color.black);
		etiquetaTipoMusica = new JLabel();
		etiquetaTipoMusica.setForeground(Color.black);
		etiquetaGIFPlaying = new JLabel(GIFStop);
		Border borde3 = BorderFactory.createLineBorder(Color.BLACK);
		panelEmisoraInfo.setBorder(borde3);
		
		panelEmisoraInfo.add(etiquetaTituloNombre);
		panelEmisoraInfo.add(etiquetaNombreEmisora);
		panelEmisoraInfo.add(etiquetaTituloModo);
		panelEmisoraInfo.add(etiquetaModoTransmision);
		panelEmisoraInfo.add(etiquetaTituloTipoMusica);
		panelEmisoraInfo.add(etiquetaTipoMusica);
		add(panelEmisoraInfo);
		add(etiquetaGIFPlaying);
	}

	public void actualizarAtributos(String nombreEmisora, String modoTransmision, String tipoMusica) {
		etiquetaNombreEmisora.setText(nombreEmisora);
		etiquetaModoTransmision.setText(modoTransmision);
		etiquetaTipoMusica.setText(tipoMusica);
		// este método actualiza los textos de las etiquetas en un panel o interfaz gráfica de usuario con los valores
		//proporcionados en los parámetros nombreEmisora, modoTransmision y tipoMusica.
	}

	public void actualizarPanelDatosEmisora(String[] titulos) {
		setBorder(new TitledBorder(titulos[0]));
		etiquetaTituloNombre.setText(titulos[1]);
		etiquetaTituloModo.setText(titulos[2]);
		etiquetaTituloTipoMusica.setText(titulos[3]);
		//este método actualiza el borde y los textos de las etiquetas en un panel 
		//de datos de emisora utilizando los valores proporcionados en el arreglo titulos.

	}

	public void actualizarGIFStatus(Icon icon) {
		etiquetaGIFPlaying.setIcon(icon);
	}

	public JLabel getEtiquetaTituloNombre() {
		return etiquetaTituloNombre;
	}

	public void setEtiquetaTituloNombre(JLabel etiquetaTituloNombre) {
		this.etiquetaTituloNombre = etiquetaTituloNombre;
	}

	public JLabel getEtiquetaNombreEmisora() {
		return etiquetaNombreEmisora;
	}

	public void setEtiquetaNombreEmisora(JLabel etiquetaNombreEmisora) {
		this.etiquetaNombreEmisora = etiquetaNombreEmisora;
	}

	public JLabel getEtiquetaTituloModo() {
		return etiquetaTituloModo;
	}

	public void setEtiquetaTituloModo(JLabel etiquetaTituloModo) {
		this.etiquetaTituloModo = etiquetaTituloModo;
	}

	public JLabel getEtiquetaModoTransmision() {
		return etiquetaModoTransmision;
	}

	public void setEtiquetaModoTransmision(JLabel etiquetaModoTransmision) {
		this.etiquetaModoTransmision = etiquetaModoTransmision;
	}

	public JLabel getEtiquetaTituloTipoMusica() {
		return etiquetaTituloTipoMusica;
	}

	public void setEtiquetaTituloTipoMusica(JLabel etiquetaTituloTipoMusica) {
		this.etiquetaTituloTipoMusica = etiquetaTituloTipoMusica;
	}

	public JLabel getEtiquetaTipoMusica() {
		return etiquetaTipoMusica;
	}

	public void setEtiquetaTipoMusica(JLabel etiquetaTipoMusica) {
		this.etiquetaTipoMusica = etiquetaTipoMusica;
	}

	public JLabel getEtiquetaImagenPortada() {
		return etiquetaGIFPlaying;
	}

	public void setEtiquetaImagenPortada(JLabel etiquetaImagenPortada) {
		this.etiquetaGIFPlaying = etiquetaImagenPortada;
	}

	public JPanel getPanelEmisoraInfo() {
		return panelEmisoraInfo;
	}

	public void setPanelEmisoraInfo(JPanel panelEmisoraInfo) {
		this.panelEmisoraInfo = panelEmisoraInfo;
	}

	public JLabel getEtiquetaGIFPlaying() {
		return etiquetaGIFPlaying;
	}

	public void setEtiquetaGIFPlaying(JLabel etiquetaGIFPlaying) {
		this.etiquetaGIFPlaying = etiquetaGIFPlaying;
	}

	public String getRutaGIFPlay() {
		return rutaGIFPlay;
	}

	public String getRutaGIFStop() {
		return rutaGIFStop;
	}

	public Icon getGIFPlay() {
		return GIFPlay;
	}

	public void setGIFPlay(Icon gIFPlay) {
		GIFPlay = gIFPlay;
	}

	public Icon getGIFStop() {
		return GIFStop;
	}

	public void setGIFStop(Icon gIFStop) {
		GIFStop = gIFStop;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
