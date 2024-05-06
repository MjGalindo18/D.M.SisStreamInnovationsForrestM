package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnParametrizarEmisora;
	private JButton btnProgramacion;
	private JButton btnGestionarCanciones;

	public final String PARAMETRIZAR = "PARAMETRIZAR EMISORA";
	public final String PROGRAMACION_EMISORA = "PROGRAMACION EMISORA";
	public final String GESTIONAR = "GESTIONAR CANCIONES";

	public PanelPrincipal() {
		setLayout(null);

		btnParametrizarEmisora = new JButton(PARAMETRIZAR);
		btnParametrizarEmisora.setBounds(100, 550, 300, 100);
		btnParametrizarEmisora.setActionCommand(PARAMETRIZAR);
		btnParametrizarEmisora.setBackground(Color.BLACK);
		btnParametrizarEmisora.setForeground(Color.WHITE);
		btnParametrizarEmisora.setFont(new Font("Horizon", Font.BOLD, 17));
		add(btnParametrizarEmisora);

		btnGestionarCanciones = new JButton(GESTIONAR);
		btnGestionarCanciones.setBounds(820, 550, 300, 100);
		btnGestionarCanciones.setActionCommand(GESTIONAR);
		btnGestionarCanciones.setBackground(Color.BLACK);
		btnGestionarCanciones.setForeground(Color.WHITE);
		btnGestionarCanciones.setFont(new Font("Horizon", Font.BOLD, 17));
		add(btnGestionarCanciones);

		btnProgramacion = new JButton(PROGRAMACION_EMISORA);
		btnProgramacion.setBounds(460, 550, 300, 100);
		btnProgramacion.setActionCommand(PROGRAMACION_EMISORA);
		btnProgramacion.setFont(new Font("Horizon", Font.BOLD, 17));
		btnProgramacion.setBackground(Color.BLACK);
	    btnProgramacion.setForeground(Color.WHITE);
		add(btnProgramacion);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//llama al método paintComponent de la superclase para asegurar que se dibuje 
		g.drawImage(new ImageIcon("Imagenes/logo.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);
		//dibuja una imagen en el componente utilizando el objeto Graphics para renderizar la imagen en las coordenadas (0, 0) 
		//el método paintComponent(Graphics g) se utiliza para personalizar la representación visual de un componente al dibujar gráficos
	}

	public JButton getBtnParametrizarEmisora() {
		return btnParametrizarEmisora;
	}

	public void setBtnParametrizarEmisora(JButton btnParametrizarEmisora) {
		this.btnParametrizarEmisora = btnParametrizarEmisora;
	}

	public JButton getBtnProgramacion() {
		return btnProgramacion;
	}

	public void setBtnProgramacion(JButton btnProgramacion) {
		this.btnProgramacion = btnProgramacion;
	}

	public JButton getBtnGestionarCanciones() {
		return btnGestionarCanciones;
	}

	public void setBtnGestionarCanciones(JButton btnGestionarCanciones) {
		this.btnGestionarCanciones = btnGestionarCanciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPARAMETRIZAR() {
		return PARAMETRIZAR;
	}

	public String getPROGRAMACION_EMISORA() {
		return PROGRAMACION_EMISORA;
	}

	public String getGESTIONAR() {
		return GESTIONAR;
	}

}
