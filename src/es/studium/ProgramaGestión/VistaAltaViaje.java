package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class VistaAltaViaje extends Frame{

	private static final long serialVersionUID = 1L;
	
	Font fuente = new Font("Calibri", 0, 15);
	
	Label origen = new Label(" Origen del Viaje");
	Label destino = new Label(" Destino del Viaje");
	Label fechaViaje = new Label(" Fecha del Viaje");
	Label labelVacio = new Label(" ");
	Choice choice = new Choice();
	TextField txtOrigen = new TextField(20);
	TextField txtDestino = new TextField(20);
	TextField txtFecha = new TextField(20);
	Button btnAceptar = new Button(" Aceptar");
	Button btnLimpiar = new Button(" Limpiar");
	
	
	VistaAltaViaje() {
		setLayout(new GridLayout(5,2));
		setTitle("Alta Viaje");
		
		add(origen);
		add(txtOrigen);
		add(destino);
		add(txtDestino);
		add(fechaViaje);
		add(txtFecha);
		add(choice);
		add(labelVacio);
		add(btnAceptar);
		add(btnLimpiar);
		
		txtOrigen.setFont(fuente);
		txtDestino.setFont(fuente);
		txtFecha.setFont(fuente);
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
