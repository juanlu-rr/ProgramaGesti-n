package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;

public class VistaConsultaHotel extends Frame {
	private static final long serialVersionUID = 1L;
	Label lblDialogo = new Label("¿Quieres generar un PDF?");
	Label lblConfirmacion= new Label("PDF generado correctamente");
	Button btnAceptar = new Button("Aceptar");
	Dialog dialog = new Dialog(this, "Estado de la Consulta", true);
	
	public VistaConsultaHotel() {
		setLayout(new GridLayout(2,1));
		setTitle("Consulta Hoteles");
		add(lblDialogo);
		add(lblConfirmacion);
		add(btnAceptar);
		dialog.add(lblConfirmacion);
		dialog.setSize(200,150);
		dialog.setLocationRelativeTo(null);
		setSize(300,200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
