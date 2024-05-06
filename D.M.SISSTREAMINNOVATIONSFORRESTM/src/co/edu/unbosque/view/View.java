package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private PanelPrincipal panelPrincipal;
	private PanelGestionarCanciones panelGestionarCanciones;
	private PanelParametrosDMRadio panelParametrosDMRadio;
	private PanelDMRadio panelDMRadio;
	private JTabbedPane pestanas;

	public View(Controller control) {

		cardLayout = new CardLayout();

		setLayout(cardLayout);

		panelPrincipal = new PanelPrincipal();
		add(panelPrincipal, "panelPrincipal");

		panelParametrosDMRadio = new PanelParametrosDMRadio();
		add(panelParametrosDMRadio, "panelParametrosDMRadio");

		panelGestionarCanciones = new PanelGestionarCanciones();
		add(panelGestionarCanciones, "panelGestionarCanciones");
		
		panelDMRadio = new PanelDMRadio();
		add(panelDMRadio, "panelDMRadio");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 700);
		setTitle("DMRADIO");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setBackground(Color.BLACK);

		//El ActionListener es una interfaz en Java que se utiliza para detectar y responder a las acciones del usuario en una interfaz gráfica de usuario (GUI).
		panelPrincipal.getBtnParametrizarEmisora().addActionListener(control);
		panelPrincipal.getBtnGestionarCanciones().addActionListener(control);
		panelPrincipal.getBtnProgramacion().addActionListener(control);

		panelGestionarCanciones.getBotonRegresar().addActionListener(control);
		panelGestionarCanciones.getBotonAgregar().addActionListener(control);
		
        panelParametrosDMRadio.getBotonRegresar().addActionListener(control);
		panelParametrosDMRadio.getBotonGuardar().addActionListener(control);

		panelDMRadio.getPanelEjecucion().getBotonAgregar().addActionListener(control);
		panelDMRadio.getPanelEjecucion().getBotonBorrar().addActionListener(control);
		panelDMRadio.getPanelPlay().getBotonPlay().addActionListener(control);
		panelDMRadio.getPanelPlay().getBotonPausa().addActionListener(control);
		panelDMRadio.getPanelPlay().getBotonRetrocede().addActionListener(control);
		panelDMRadio.getPanelPlay().getBotonAvanza().addActionListener(control);
		
		panelDMRadio.getPanelEjecucion().getBotonRegresar().addActionListener(control);
	}

	public ImageIcon crearIcono(String ruta) {
		ImageIcon imagen = new ImageIcon(ruta);
		return imagen;
	}

	public void actualizarView(String[] titulos) {
		pestanas.setTitleAt(0, titulos[0]);
		pestanas.setTitleAt(1, titulos[1]);
	}

	public void habilitarBotones() {
		panelDMRadio.getPanelEjecucion().getBotonAgregar().setEnabled(true);
		panelDMRadio.getPanelEjecucion().getBotonBorrar().setEnabled(true);
		panelGestionarCanciones.getBotonAgregar().setEnabled(true);
		panelGestionarCanciones.getBotonRegresar().setEnabled(true);
	}

	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de alerta", JOptionPane.WARNING_MESSAGE);
	}

	public void mostrarMensajeAviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de informacion", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarPanelParametrizar() {
		cardLayout.show(getContentPane(), "panelParametrosDMRadio");
	}
	
	public void mostrarPanelPrincipal() {
		cardLayout.show(getContentPane(), "panelPrincipal");
	}
	
	public void mostrarPanelGestionarCanciones() {
		cardLayout.show(getContentPane(), "panelGestionarCanciones");
	}
	
	public void mostrarPanelDMRadio() {
		cardLayout.show(getContentPane(), "panelDMRadio");
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(PanelPrincipal panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public PanelGestionarCanciones getPanelGestionarCanciones() {
		return panelGestionarCanciones;
	}

	public void setPanelGestionarCanciones(PanelGestionarCanciones panelGestionarCanciones) {
		this.panelGestionarCanciones = panelGestionarCanciones;
	}

	public PanelDMRadio getPanelDMRadio() {
		return panelDMRadio;
	}

	public void setPanelDMRadio(PanelDMRadio panelDMRadio) {
		this.panelDMRadio = panelDMRadio;
	}

	public JTabbedPane getPestanas() {
		return pestanas;
	}

	public void setPestanas(JTabbedPane pestanas) {
		this.pestanas = pestanas;
	}

	public PanelParametrosDMRadio getPanelParametrosDMRadio() {
		return panelParametrosDMRadio;
	}

	public void setPanelParametrosDMRadio(PanelParametrosDMRadio panelParametrosDMRadio) {
		this.panelParametrosDMRadio = panelParametrosDMRadio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
