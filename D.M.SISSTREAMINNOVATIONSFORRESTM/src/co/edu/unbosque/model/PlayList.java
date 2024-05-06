package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import jaco.mp3.player.MP3Player;

public class PlayList {

	private ArrayList<Cancion> pistasMusicales;
	private MP3Player reproductorParrilla;
	private int contadorParrilla;

	public PlayList() {
		pistasMusicales = new ArrayList<>();
		reproductorParrilla = new MP3Player();
		reproductorParrilla.setRepeat(true);
	}

	public void generarPlayList() {
		for (int i = 0; i < pistasMusicales.size(); i++) {
			reproductorParrilla
					.addToPlayList(new File("./Canciones/" + pistasMusicales.get(i).getNombreArchivo().trim()));
		}
	}

	public void agregarCancionPlayList() {
		reproductorParrilla.addToPlayList(new File(
				"./Canciones/" + pistasMusicales.get(pistasMusicales.size() - 1).getNombreArchivo().trim()));
	}

	public void cargarParrilla(ArrayList<Cancion> pistas) {
		pistasMusicales = pistas;
	}

	public void agregarPistaMusical(Cancion pistaMusical) {
		pistasMusicales.add(pistaMusical);
	}

	public void borrarParrilla() {
		pistasMusicales.clear();
	}

	public void reproducir() {
		reproductorParrilla.play();
	}

	public void pausar() {
		reproductorParrilla.pause();
	}

	public void parar() {
		reproductorParrilla.stop();
	}

	public void reproducirSiguiente() {
		reproductorParrilla.skipForward();
	}

	public void reproducirAnterior() {
		reproductorParrilla.skipBackward();
	}

	public ArrayList<Cancion> getPistasMusicales() {
		return pistasMusicales;
	}

	public void setPistasMusicales(ArrayList<Cancion> pistasMusicales) {
		this.pistasMusicales = pistasMusicales;
	}

	public MP3Player getReproductorParrilla() {
		return reproductorParrilla;
	}

	public void setReproductorParrilla(MP3Player reproductorParrilla) {
		this.reproductorParrilla = reproductorParrilla;
	}

	public int getContadorParrilla() {
		return contadorParrilla;
	}

	public void setContadorParrilla(int contadorParrilla) {
		this.contadorParrilla = contadorParrilla;
	}

}
