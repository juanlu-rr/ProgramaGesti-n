package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class VistaAltaHotel extends Frame{

	private static final long serialVersionUID = 1L;
	
	Font fuente = new Font("Calibri", 0, 15);
	
	Label nombreH = new Label(" Nombre del Hotel");
	Label estrellas = new Label(" Número de Estrellas");
	Label ciudad = new Label(" Ciudad");
	TextField txtNombre = new TextField(20);
	TextField txtEstrellas = new TextField(20);
	TextField txtCiudad = new TextField(20);
	Button btnAceptar = new Button(" Aceptar");
	Button btnLimpiar = new Button(" Limpiar");
	
	
	VistaAltaHotel() {
		@SuppressWarnings("unused")
		Panel panel = new Panel(new GridLayout(1,2));
		setLayout(new GridLayout(4,2));
		setTitle("Alta Hotel");
		
		add(nombreH);
		add(txtNombre);
		add(estrellas);
		add(txtEstrellas);
		add(ciudad);
		add(txtCiudad);
		add(btnAceptar);
		add(btnLimpiar);
		nombreH.setFont(fuente);
		txtNombre.setFont(fuente);
		estrellas.setFont(fuente);
		txtEstrellas.setFont(fuente);
		ciudad.setFont(fuente);
		txtCiudad.setFont(fuente);
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
