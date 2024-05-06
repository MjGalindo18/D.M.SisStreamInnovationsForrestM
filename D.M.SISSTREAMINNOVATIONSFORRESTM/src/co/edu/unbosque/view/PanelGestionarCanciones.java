package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelGestionarCanciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaNombreCancion;
	private JLabel etiquetaNombreAutor;
	private JLabel etiquetaGeneroMusica;
	private JLabel etiquetaArchivo;
	private JTextField campoTextoNombreCancion;
	private JTextField campoTextoNombreAutor;
	private JTextField campoTextoGeneroMusica;
	private JTextArea campoTextoArchivo;
	private JTable tablaCanciones;
	private JScrollPane scroll;
	private JButton botonAgregar;
	private JButton botonRegresar;
	private JPanel panelRegistro;
	private DefaultTableModel modeloTabla;
	private final String AGREGAR = "Agregar";
	private final String REGRESAR = "REGRESAR";

	public PanelGestionarCanciones() {
		setLayout(new GridLayout(1, 2));

		panelRegistro = new JPanel();
		panelRegistro.setLayout(new GridLayout(5, 2));
		panelRegistro.setBackground(Color.black);

		etiquetaNombreCancion = new JLabel();
		etiquetaNombreCancion.setForeground(Color.white);
		etiquetaNombreAutor = new JLabel();
		etiquetaNombreAutor.setForeground(Color.white);
		etiquetaGeneroMusica = new JLabel();
		etiquetaGeneroMusica.setForeground(Color.white);
		etiquetaArchivo = new JLabel();
		etiquetaArchivo.setForeground(Color.white);

		campoTextoNombreCancion = new JTextField();
		campoTextoNombreAutor = new JTextField();
		campoTextoGeneroMusica = new JTextField();
		campoTextoArchivo = new JTextArea();
		campoTextoArchivo.setForeground(Color.black);
		Border borde = BorderFactory.createLineBorder(Color.BLACK);
		campoTextoNombreCancion.setBorder(borde);
		campoTextoNombreAutor.setBorder(borde);
		campoTextoGeneroMusica.setBorder(borde);
		campoTextoArchivo.setBorder(borde);
		campoTextoGeneroMusica.setBackground(new Color(255, 160, 122));
		campoTextoNombreAutor.setBackground(new Color(255, 160, 122));
		campoTextoNombreCancion.setBackground(new Color(255, 160, 122));

		botonAgregar = new JButton();
		botonAgregar.setActionCommand(AGREGAR);
		botonAgregar.setEnabled(true);
		botonAgregar.setBackground(new Color(244, 226, 232 )); 
		botonAgregar.setForeground(Color.black); 
		Border borde1 = BorderFactory.createLineBorder(Color.BLACK);
		botonAgregar.setBorder(borde1);

		botonRegresar = new JButton();
		botonRegresar.setActionCommand(REGRESAR);
		botonRegresar.setEnabled(false);
		botonRegresar.setBackground(new Color(244, 226, 232 )); 
		botonRegresar.setForeground(Color.black);
		Border borde2 = BorderFactory.createLineBorder(Color.BLACK);
		botonRegresar.setBorder(borde2);
		
		JPanel panelArchivo = new JPanel();
		panelArchivo.setLayout(new GridLayout(2, 1));

		campoTextoArchivo.setEditable(false);
		campoTextoArchivo.setBackground(new Color(255, 160, 122));
		
		JButton botonAbrir = new JButton("Abrir Archivo");
		botonAbrir.addActionListener(e -> openFileChooser());
		
		panelArchivo.add(botonAbrir);
		panelArchivo.add(campoTextoArchivo);
		
		modeloTabla = new DefaultTableModel();
		tablaCanciones = new JTable(modeloTabla);
		tablaCanciones.setEnabled(false);
		tablaCanciones.setDragEnabled(false);
		scroll = new JScrollPane(tablaCanciones);
		modeloTabla.addColumn("");
		modeloTabla.addColumn("");
		modeloTabla.addColumn("");
		modeloTabla.addColumn("");

		panelRegistro.add(etiquetaNombreCancion);
		panelRegistro.add(campoTextoNombreCancion);
		panelRegistro.add(etiquetaNombreAutor);
		panelRegistro.add(campoTextoNombreAutor);
		panelRegistro.add(etiquetaGeneroMusica);
		panelRegistro.add(campoTextoGeneroMusica);
		panelRegistro.add(etiquetaArchivo);
		panelRegistro.add(panelArchivo);
		panelRegistro.add(botonRegresar);
		panelRegistro.add(botonAgregar);
		add(panelRegistro);
		add(scroll);
		setBackground(Color.white);
	}

	private void openFileChooser() {
	    JFileChooser fileChooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3");
	    fileChooser.setFileFilter(filter);
	    int result = fileChooser.showOpenDialog(this);
	    if (result == JFileChooser.APPROVE_OPTION) {
	        String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();
	        campoTextoArchivo.setText(selectedFile);
	   // El JFileChooser muestra un cuadro de diálogo que permite al usuario seleccionar un archivo de su sistema de archivos.
	   // , aplica un filtro para mostrar solo archivos con la extensión ".mp3" y actualiza un campo de texto con la ruta absoluta
	   //del archivo seleccionado por el usuario.
	    }
	}

	public void crearTabla(String[][] datos) {
		for (int i = 0; i < datos.length; i++) {
			modeloTabla.addRow(datos[i]);
		//este ciclo for recorre cada fila del arreglo datos y agrega cada fila al modelo de una tabla utilizando 
			//el método addRow del objeto modeloTabla.
		}
	}

	public void actualizarTabla(int contador, String cancion, String autor, String genero) {
		modeloTabla.addRow(new String[] { Integer.toString(contador), cancion, autor, genero });
	}

	public void borrarCampos() {
		campoTextoNombreCancion.setText("");
		campoTextoNombreAutor.setText("");
		campoTextoGeneroMusica.setText("");
		campoTextoArchivo.setText("");
		// el método actualizarTabla agrega una nueva fila a una tabla con los valores proporcionados, mientras que 
		//el método borrarCampos borra el contenido de varios campos de texto.
	}

	public void actualizarPanelAgregarCancion(String[] titulos) {
		setBorder(new TitledBorder(titulos[0]));

		etiquetaNombreCancion.setText(titulos[1]);
		etiquetaNombreAutor.setText(titulos[2]);
		etiquetaGeneroMusica.setText(titulos[3]);
		etiquetaArchivo.setText(titulos[4]);
		botonAgregar.setText(titulos[5]);
		botonRegresar.setText(titulos[6]);

		modeloTabla.fireTableStructureChanged();
		tablaCanciones.getColumn(tablaCanciones.getColumnName(0)).setHeaderValue(titulos[10]);
		tablaCanciones.getColumn(tablaCanciones.getColumnName(1)).setHeaderValue(titulos[7]);
		tablaCanciones.getColumn(tablaCanciones.getColumnName(2)).setHeaderValue(titulos[8]);
		tablaCanciones.getColumn(tablaCanciones.getColumnName(3)).setHeaderValue(titulos[9]);
		tablaCanciones.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaCanciones.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaCanciones.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablaCanciones.getColumnModel().getColumn(3).setPreferredWidth(100);
		//el método actualizarPanelAgregarCancion actualiza el panel de agregar canciones estableciendo nuevos títulos, textos y anchos
		//para los componentes del panel, así como para las columnas de una tabla.
	}

	public JLabel getEtiquetaNombreCancion() {
		return etiquetaNombreCancion;
	}

	public void setEtiquetaNombreCancion(JLabel etiquetaNombreCancion) {
		this.etiquetaNombreCancion = etiquetaNombreCancion;
	}

	public JLabel getEtiquetaNombreAutor() {
		return etiquetaNombreAutor;
	}

	public void setEtiquetaNombreAutor(JLabel etiquetaNombreAutor) {
		this.etiquetaNombreAutor = etiquetaNombreAutor;
	}

	public JLabel getEtiquetaGeneroMusica() {
		return etiquetaGeneroMusica;
	}

	public void setEtiquetaGeneroMusica(JLabel etiquetaGeneroMusica) {
		this.etiquetaGeneroMusica = etiquetaGeneroMusica;
	}

	public JLabel getEtiquetaArchivo() {
		return etiquetaArchivo;
	}

	public void setEtiquetaArchivo(JLabel etiquetaArchivo) {
		this.etiquetaArchivo = etiquetaArchivo;
	}

	public JTextField getCampoTextoNombreCancion() {
		return campoTextoNombreCancion;
	}

	public void setCampoTextoNombreCancion(JTextField campoTextoNombreCancion) {
		this.campoTextoNombreCancion = campoTextoNombreCancion;
	}

	public JTextField getCampoTextoNombreAutor() {
		return campoTextoNombreAutor;
	}

	public void setCampoTextoNombreAutor(JTextField campoTextoNombreAutor) {
		this.campoTextoNombreAutor = campoTextoNombreAutor;
	}

	public JTextField getCampoTextoGeneroMusica() {
		return campoTextoGeneroMusica;
	}

	public void setCampoTextoGeneroMusica(JTextField campoTextoGeneroMusica) {
		this.campoTextoGeneroMusica = campoTextoGeneroMusica;
	}

	public JTextArea getCampoTextoArchivo() {
		return campoTextoArchivo;
	}

	public void setCampoTextoArchivo(JTextArea campoTextoArchivo) {
		this.campoTextoArchivo = campoTextoArchivo;
	}

	public JTable getTablaCanciones() {
		return tablaCanciones;
	}

	public void setTablaCanciones(JTable tablaCanciones) {
		this.tablaCanciones = tablaCanciones;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public void setBotonAgregar(JButton botonAgregar) {
		this.botonAgregar = botonAgregar;
	}

	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	public JPanel getPanelRegistro() {
		return panelRegistro;
	}

	public void setPanelRegistro(JPanel panelRegistro) {
		this.panelRegistro = panelRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAGREGAR() {
		return AGREGAR;
	}

	public String getREGRESAR() {
		return REGRESAR;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

}
