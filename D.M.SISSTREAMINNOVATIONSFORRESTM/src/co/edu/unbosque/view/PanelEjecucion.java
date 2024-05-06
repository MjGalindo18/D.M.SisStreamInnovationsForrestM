package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelEjecucion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonAgregar;
	private JButton botonBorrar;
	private JButton botonRegresar; 
	private String COMMAND_AGREGAR_PARRILLA = "AgregarParrilla";
	private String COMMAND_BORRAR_PARRILLA = "BorrarParrilla";
	private String COMMAND_REGRESAR = "REGRESAR";
	private JTable tablaParrilla;
	private JComboBox<String> comboNombreCancion; // es un componente gráfico en Java Swing que permite al usuario seleccionar un elemento de una lista desplegable.
	private JScrollPane sp; //  proporciona una vista desplazable de su contenido.
	private JPanel contenedor;
	private DefaultTableModel modeloTablaParrilla;

	public PanelEjecucion() {

		setLayout(new BorderLayout());
		Border borde4 = BorderFactory.createLineBorder(Color.BLACK);
		contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(1, 3)); 
		contenedor.setBackground(new Color(255, 160, 122));
		contenedor.setBorder(borde4);
		botonAgregar = new JButton();
		botonAgregar.setActionCommand(COMMAND_AGREGAR_PARRILLA);
		botonAgregar.setEnabled(false);
		botonAgregar.setBackground(new Color(255, 160, 122));
		botonAgregar.setBorder(borde4);
		botonBorrar = new JButton();
		botonBorrar.setEnabled(false);
		botonBorrar.setActionCommand(COMMAND_BORRAR_PARRILLA);
		// El método setActionCommand se utiliza para establecer el comando de acción del botón botonBorrar.
		//El valor COMMAND_BORRAR_PARRILLA es una constante que representa el comando de acción específico para el botón
		botonBorrar.setBackground(new Color(255, 160, 122));
		botonBorrar.setBorder(borde4);
		botonRegresar = new JButton("Regresar");
		botonRegresar.setActionCommand(COMMAND_REGRESAR);
		botonRegresar.setEnabled(true);
		botonRegresar.setBackground(new Color(255, 160, 122));
		botonRegresar.setBorder(borde4);
		comboNombreCancion = new JComboBox<String>();

		modeloTablaParrilla = new DefaultTableModel();
		tablaParrilla = new JTable(modeloTablaParrilla);
		tablaParrilla.setEnabled(false);
		sp = new JScrollPane(tablaParrilla);
		modeloTablaParrilla.addColumn("");
		modeloTablaParrilla.addColumn("");
		modeloTablaParrilla.addColumn("");
		modeloTablaParrilla.addColumn("");

		contenedor.add(comboNombreCancion);
		contenedor.add(botonAgregar);
		contenedor.add(botonRegresar);
		add(sp);
		add(botonBorrar, BorderLayout.PAGE_END);
		add(contenedor, BorderLayout.PAGE_START);
	}

	public void crearTabla(String[][] datos) {    // este ciclo for se encarga de agregar filas al modelo de una tabla 
		                                           //utilizando los datos proporcionados en el arreglo bidimensional datos.
		for (int i = 0; i < datos.length; i++) {
			modeloTablaParrilla.addRow(datos[i]);
		}
	}

	public void actualizarTabla(int contador, String cancion, String autor, String genero) {
		modeloTablaParrilla.addRow(new String[] { Integer.toString(contador), cancion, autor, genero });
	   // La función addRow se utiliza para agregar una nueva fila a la tabla modeloTablaParrilla
	}

	public void borrarContenidoTabla() {
		modeloTablaParrilla.setRowCount(0);
		// El método setRowCount se utiliza para establecer el número de filas en el modelo de una tabla
	}

	public void actualizarPanelParrilla(String[] titulos) {
		setBorder(new TitledBorder(titulos[0]));
		botonAgregar.setText(titulos[1]);
		botonBorrar.setText(titulos[2]);
		comboNombreCancion.removeAllItems();
		comboNombreCancion.addItem(titulos[3]);
		modeloTablaParrilla.fireTableStructureChanged();
		tablaParrilla.getColumn(tablaParrilla.getColumnName(0)).setHeaderValue(titulos[7]);
		tablaParrilla.getColumn(tablaParrilla.getColumnName(1)).setHeaderValue(titulos[4]);
		tablaParrilla.getColumn(tablaParrilla.getColumnName(2)).setHeaderValue(titulos[5]);
		tablaParrilla.getColumn(tablaParrilla.getColumnName(3)).setHeaderValue(titulos[6]);
		tablaParrilla.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaParrilla.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaParrilla.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablaParrilla.getColumnModel().getColumn(3).setPreferredWidth(100);
		// el método actualizarPanelParrilla actualiza el aspecto y el contenido de un panel de parrilla, 
		//incluyendo el borde, los textos de los botones, los elementos del combo box,
		//los encabezados de las columnas y el ancho de las columnas de una tabla.
	}

	public void agregarCancionesComboBox(String[] canciones) {
		for (int i = 0; i < canciones.length; i++) {
			comboNombreCancion.addItem(canciones[i]);
			//Este ciclo se utiliza para recorrer un arreglo de canciones (canciones) y agregar cada
			//canción al combo box comboNombreCancion.
		}

	}
                           // getters and setters
	public String getCOMMAND_AGREGAR_PARRILLA() {
		return COMMAND_AGREGAR_PARRILLA;
	}

	public void setCOMMAND_AGREGAR_PARRILLA(String cOMMAND_AGREGAR_PARRILLA) {
		COMMAND_AGREGAR_PARRILLA = cOMMAND_AGREGAR_PARRILLA;
	}

	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	public void setBotonBorrar(JButton botonBorrar) {
		this.botonBorrar = botonBorrar;
	}

	public String getCOMMAND_BORRAR_PARRILLA() {
		return COMMAND_BORRAR_PARRILLA;
	}

	public void setCOMMAND_BORRAR_PARRILLA(String cOMMAND_BORRAR_PARRILLA) {
		COMMAND_BORRAR_PARRILLA = cOMMAND_BORRAR_PARRILLA;
	}

	public DefaultTableModel getModeloTablaParrilla() {
		return modeloTablaParrilla;
	}

	public void setModeloTablaParrilla(DefaultTableModel modeloTablaParrilla) {
		this.modeloTablaParrilla = modeloTablaParrilla;
	}

	public JPanel getContenedor() {
		return contenedor;
	}

	public void setContenedor(JPanel contenedor) {
		this.contenedor = contenedor;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public void setBotonAgregar(JButton botonAgregar) {
		this.botonAgregar = botonAgregar;
	}

	public JTable getTablaParrilla() {
		return tablaParrilla;
	}

	public void setTablaParrilla(JTable tablaParrilla) {
		this.tablaParrilla = tablaParrilla;
	}

	public JComboBox<String> getComboNombreCancion() {
		return comboNombreCancion;
	}

	public void setComboNombreCancion(JComboBox<String> comboNombreCancion) {
		this.comboNombreCancion = comboNombreCancion;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	public String getCOMMAND_REGRESAR() {
		return COMMAND_REGRESAR;
	}

	public void setCOMMAND_REGRESAR(String cOMMAND_REGRESAR) {
		COMMAND_REGRESAR = cOMMAND_REGRESAR;
	}

}
