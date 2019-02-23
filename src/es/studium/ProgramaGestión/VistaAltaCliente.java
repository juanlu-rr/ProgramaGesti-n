package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class VistaAltaCliente extends Frame{

	private static final long serialVersionUID = 1L;
	
	Font fuente = new Font("Calibri", 0, 15);
	
	Label nombreC = new Label(" Nombre");
	Label apellidosC = new Label(" Apellidos");
	Label dniC = new Label(" DNI");
	TextField txfNombre = new TextField();
	TextField txfApellidos = new TextField(20);
	TextField txfDNI = new TextField(20);
	Button btnAceptar = new Button(" Aceptar");
	Button btnLimpiar = new Button(" Limpiar");
	
	
	VistaAltaCliente() {		
		setLayout(new GridLayout(4,2));
		setTitle("Alta Cliente");
		
		add(nombreC);
		add(txfNombre);
		add(apellidosC);
		add(txfApellidos);
		add(dniC);
		add(txfDNI);
		add(btnAceptar);
		add(btnLimpiar);
		nombreC.setFont(fuente);
		txfNombre.setFont(fuente);
		apellidosC.setFont(fuente);
		txfApellidos.setFont(fuente);
		dniC.setFont(fuente);
		txfDNI.setFont(fuente);
		
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
