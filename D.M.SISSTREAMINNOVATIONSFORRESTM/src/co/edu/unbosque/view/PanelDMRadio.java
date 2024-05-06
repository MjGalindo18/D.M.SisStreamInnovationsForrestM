package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class PanelDMRadio extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelGeneral panelGeneral;
	private PanelEjecucion panelEjecucion;
	private PanelPlay panelPlay;

	public PanelDMRadio() {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		panelGeneral = new PanelGeneral();
		panelEjecucion = new PanelEjecucion();
		panelPlay = new PanelPlay();

		add(panelEjecucion, BorderLayout.CENTER);
		add(panelGeneral, BorderLayout.EAST);
		add(panelPlay, BorderLayout.PAGE_END);
	}

	public PanelGeneral getPanelGeneral() {
		return panelGeneral;
	}

	public void setPanelGeneral(PanelGeneral panelGeneral) {
		this.panelGeneral = panelGeneral;
	}

	public PanelEjecucion getPanelEjecucion() {
		return panelEjecucion;
	}

	public void setPanelEjecucion(PanelEjecucion panelEjecucion) {
		this.panelEjecucion = panelEjecucion;
	}

	public PanelPlay getPanelPlay() {
		return panelPlay;
	}

	public void setPanelPlay(PanelPlay panelPlay) {
		this.panelPlay = panelPlay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
