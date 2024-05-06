package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPlay extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_REPRODUCIR = "REPRODUCIR";
	private final String COMMAND_PARAR = "PARAR";
	private final String COMMAND_PAUSAR = "PAUSAR";
	private final String COMMAND_RETROCEDER = "RETROCEDER";
	private final String COMMAND_AVANZAR = "AVANZAR";
	private JButton botonPlay;
	private JButton botonPausa;
	private JButton botonRetrocede;
	private JButton botonAvanza;
	private ImageIcon img_sound;
	private Icon icon_sound;

	public PanelPlay() {

		setLayout(new GridLayout(1, 2));
		setVisible(true);
		
		Color colorBotones = Color.black;
		
		botonPausa = new JButton();
		botonPausa.setBorder(null);
		botonPausa.setOpaque(true);
		botonPausa.setBackground(colorBotones);
		botonPausa.setActionCommand(COMMAND_PAUSAR);

		botonPlay = new JButton();
		botonPlay.setBorder(null);
		botonPlay.setOpaque(true);
		botonPlay.setBackground(colorBotones);
		botonPlay.setActionCommand(COMMAND_REPRODUCIR);

		botonRetrocede = new JButton();
		botonRetrocede.setBorder(null);
		botonRetrocede.setOpaque(true);
		botonRetrocede.setBackground(colorBotones);
		botonRetrocede.setActionCommand(COMMAND_RETROCEDER);

		botonAvanza = new JButton();
		botonAvanza.setBorder(null);
		botonAvanza.setOpaque(true);
		botonAvanza.setBackground(colorBotones);
		botonAvanza.setActionCommand(COMMAND_AVANZAR);
		
		img_sound = new ImageIcon("./Imagenes/Retrocede.png");
		icon_sound = new ImageIcon(img_sound.getImage().getScaledInstance(46, 46, Image.SCALE_DEFAULT));
		botonRetrocede.setIcon(icon_sound);
		add(botonRetrocede);

		img_sound = new ImageIcon("./Imagenes/Pause.png");
		icon_sound = new ImageIcon(img_sound.getImage().getScaledInstance(46, 46, Image.SCALE_DEFAULT));
		botonPausa.setIcon(icon_sound);
		add(botonPausa);

		img_sound = new ImageIcon("./Imagenes/Play.png");
		icon_sound = new ImageIcon(img_sound.getImage().getScaledInstance(46, 46, Image.SCALE_DEFAULT));
		botonPlay.setIcon(icon_sound);
		add(botonPlay);

		img_sound = new ImageIcon("./Imagenes/Avanzar.png");
		icon_sound = new ImageIcon(img_sound.getImage().getScaledInstance(46, 46, Image.SCALE_DEFAULT));
		botonAvanza.setIcon(icon_sound);
		add(botonAvanza);
	}

	public void manejarBotones(boolean valor) {

		botonAvanza.setEnabled(valor);
		botonPausa.setEnabled(valor);
		botonPlay.setEnabled(valor);
		botonRetrocede.setEnabled(valor);
	}

	public JButton getBotonRetrocede() {
		return botonRetrocede;
	}

	public void setBotonRetrocede(JButton botonRetrocede) {
		this.botonRetrocede = botonRetrocede;
	}

	public JButton getBotonAvanza() {
		return botonAvanza;
	}

	public void setBotonAvanza(JButton botonAvanza) {
		this.botonAvanza = botonAvanza;
	}

	public String getCOMMAND_PARAR() {
		return COMMAND_PARAR;
	}

	public String getCOMMAND_RETROCEDER() {
		return COMMAND_RETROCEDER;
	}

	public String getCOMMAND_AVANZAR() {
		return COMMAND_AVANZAR;
	}

	public JButton getBotonPlay() {
		return botonPlay;
	}

	public void setBotonPlay(JButton botonPlay) {
		this.botonPlay = botonPlay;
	}

	public JButton getBotonPausa() {
		return botonPausa;
	}

	public void setBotonPausa(JButton botonPausa) {
		this.botonPausa = botonPausa;
	}

	public ImageIcon getImg_sound() {
		return img_sound;
	}

	public void setImg_sound(ImageIcon img_sound) {
		this.img_sound = img_sound;
	}

	public Icon getIcon_sound() {
		return icon_sound;
	}

	public void setIcon_sound(Icon icon_sound) {
		this.icon_sound = icon_sound;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCOMMAND_REPRODUCIR() {
		return COMMAND_REPRODUCIR;
	}

	public String getCOMMAND_PAUSAR() {
		return COMMAND_PAUSAR;
	}

}
