package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class PanelParametrosDMRadio extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel etiquetaNombreEmisora;
	private JLabel etiquetaModoTransmision;
	private JLabel etiquetaTipoMusica;

	private JComboBox<String> comboModoTransmision;

	private JTextField campoTextoNombreEmisora;
	private JTextField campoTextoTipoMusica;

	private JButton botonGuardar;
	private JButton botonRegresar;

	public final String REGRESAR = "Regresar";
	public final String GUARDAR = "Guardar";

	public PanelParametrosDMRadio() {

		setLayout(new GridLayout(4, 2));
		
		etiquetaNombreEmisora = new JLabel();
		etiquetaModoTransmision = new JLabel();
		etiquetaTipoMusica = new JLabel();
		comboModoTransmision = new JComboBox<String>();
		campoTextoNombreEmisora = new JTextField();
		campoTextoTipoMusica = new JTextField();
		
		Color negro = Color.BLACK;
        etiquetaNombreEmisora.setOpaque(true); // 
		etiquetaNombreEmisora.setBackground(negro);
		etiquetaNombreEmisora.setForeground(Color.WHITE);
		etiquetaModoTransmision.setOpaque(true);
		etiquetaModoTransmision.setBackground(negro);
		etiquetaModoTransmision.setForeground(Color.WHITE);
		etiquetaTipoMusica.setOpaque(true);
		etiquetaTipoMusica.setBackground(negro);
		etiquetaTipoMusica.setForeground(Color.WHITE);
		campoTextoNombreEmisora.setBackground(new Color(255, 160, 122));
		campoTextoNombreEmisora.setForeground(Color.black);
		campoTextoTipoMusica.setBackground(new Color(255, 160, 122));
		campoTextoTipoMusica.setForeground(Color.black);
		Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK);
	    campoTextoNombreEmisora.setBorder(bordeNegro);
		campoTextoTipoMusica.setBorder(bordeNegro);
	    comboModoTransmision.setBorder(bordeNegro);
		
		botonGuardar = new JButton(GUARDAR);
		botonGuardar.setActionCommand(GUARDAR);
		botonRegresar = new JButton(REGRESAR);
		botonRegresar.setActionCommand(REGRESAR);

	
		botonGuardar.setBackground(new Color(244, 226, 232));
		botonGuardar.setForeground(Color.black);
		Border bordeNegro1 = BorderFactory.createLineBorder(Color.BLACK);
		botonGuardar.setBorder(bordeNegro1);

	
		botonRegresar.setBackground(new Color(244, 226, 232));
		botonRegresar.setForeground(Color.black);
		Border bordeNegro2 = BorderFactory.createLineBorder(Color.BLACK);
		botonRegresar.setBorder(bordeNegro2);
		
		add(etiquetaNombreEmisora);
		add(campoTextoNombreEmisora);

		add(etiquetaModoTransmision);
		add(comboModoTransmision);

		add(etiquetaTipoMusica);
		add(campoTextoTipoMusica);

		add(botonRegresar);
		add(botonGuardar);
	}

	public void cargarCampos(String nombre, String modo, String tipo) {
		campoTextoNombreEmisora.setText(nombre);
		comboModoTransmision.setSelectedItem(modo);
		campoTextoTipoMusica.setText(tipo);
	//el método cargarCampos actualiza los campos de texto y el elemento seleccionado de un combo con los valores proporcionados
	//en los parámetros nombre, modo y tipo.	
	}

	public void actualizarPanelInformacionEmisora(String[] titulos, String modoTransmision) {
		setBorder(new TitledBorder(titulos[0]));
		etiquetaNombreEmisora.setText(titulos[1]);
		etiquetaModoTransmision.setText(titulos[2]);
		etiquetaTipoMusica.setText(titulos[3]);
		comboModoTransmision.removeAllItems();
		comboModoTransmision.addItem(titulos[4]);
		comboModoTransmision.addItem(titulos[5]);
		comboModoTransmision.addItem(titulos[6]);
		comboModoTransmision.addItem(titulos[7]);
		botonGuardar.setText(titulos[8]);
		botonRegresar.setText(titulos[9]);

		if (modoTransmision.equals(comboModoTransmision.getItemAt(0))) {
			comboModoTransmision.setSelectedIndex(0);
		} else if (modoTransmision.equals(comboModoTransmision.getItemAt(1))) {
			comboModoTransmision.setSelectedIndex(1);
		} else if (modoTransmision.equals(comboModoTransmision.getItemAt(2))) {
			comboModoTransmision.setSelectedIndex(2);
		} else if (modoTransmision.equals(comboModoTransmision.getItemAt(3))) {
			comboModoTransmision.setSelectedIndex(3);
		}
		//actualiza el panel de información de una emisora estableciendo nuevos títulos, textos y elementos seleccionados 
		//para los componentes del panel.
	}

	public void restablecerCampos(String nombre, String tipoMusica, String modoTransmision) {

		campoTextoNombreEmisora.setText(nombre);
		campoTextoTipoMusica.setText(tipoMusica);

		if (modoTransmision.equals(comboModoTransmision.getItemAt(0))) {
			comboModoTransmision.setSelectedIndex(0);
		} else if (modoTransmision.equals(comboModoTransmision.getItemAt(1))) {
			comboModoTransmision.setSelectedIndex(1);
		} else if (modoTransmision.equals(comboModoTransmision.getItemAt(2))) {
			comboModoTransmision.setSelectedIndex(2);
		} else if (modoTransmision.equals(comboModoTransmision.getItemAt(3))) {
			comboModoTransmision.setSelectedIndex(3);
		}
	//restablece los campos de texto y el elemento seleccionado de un combo con los valores proporcionados en los parámetros nombre, tipoMusica y modoTransmision.
	}

	public JLabel getEtiquetaNombreEmisora() {
		return etiquetaNombreEmisora;
	}

	public void setEtiquetaNombreEmisora(JLabel etiquetaNombreEmisora) {
		this.etiquetaNombreEmisora = etiquetaNombreEmisora;
	}

	public JLabel getEtiquetaModoTransmision() {
		return etiquetaModoTransmision;
	}

	public void setEtiquetaModoTransmision(JLabel etiquetaModoTransmision) {
		this.etiquetaModoTransmision = etiquetaModoTransmision;
	}

	public JLabel getEtiquetaTipoMusica() {
		return etiquetaTipoMusica;
	}

	public void setEtiquetaTipoMusica(JLabel etiquetaTipoMusica) {
		this.etiquetaTipoMusica = etiquetaTipoMusica;
	}

	public JComboBox<String> getComboModoTransmision() {
		return comboModoTransmision;
	}

	public void setComboModoTransmision(JComboBox<String> comboModoTransmision) {
		this.comboModoTransmision = comboModoTransmision;
	}

	public JTextField getCampoTextoNombreEmisora() {
		return campoTextoNombreEmisora;
	}

	public void setCampoTextoNombreEmisora(JTextField campoTextoNombreEmisora) {
		this.campoTextoNombreEmisora = campoTextoNombreEmisora;
	}

	public JTextField getCampoTextoTipoMusica() {
		return campoTextoTipoMusica;
	}

	public void setCampoTextoTipoMusica(JTextField campoTextoTipoMusica) {
		this.campoTextoTipoMusica = campoTextoTipoMusica;
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	public String getREGRESAR() {
		return REGRESAR;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGUARDAR() {
		return GUARDAR;
	}

}
