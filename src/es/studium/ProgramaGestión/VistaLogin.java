package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class VistaLogin extends Frame{
 
	private static final long serialVersionUID = 1L;
 
	Label lblUsuario = new Label("Usuario:");
	Label lblClave = new Label("Clave:");
	static TextField txfUsuario = new TextField(20);
	TextField txfClave = new TextField(20);
	Button btnAceptar = new Button("Aceptar");
	Button btnLimpiar = new Button("Limpiar");
 
	Dialog dlgError = new Dialog(this,"Error", true);
	Label lblError = new Label("El usuario y/o la clave son incorrectos!");
	Button btnAceptarError = new Button("Aceptar");
 
	VistaLogin() {
 
		dlgError.setLayout(new FlowLayout());
		dlgError.add(lblError);
		dlgError.add(btnAceptarError);
		dlgError.setSize(230, 100);
		dlgError.setResizable(false);
		dlgError.setLocationRelativeTo(null);
 
		setLayout(new FlowLayout());
		add(lblUsuario);
		add(txfUsuario);
		add(lblClave);
 
		txfClave.setEchoChar('*');
		add(txfClave);
		add(btnAceptar);
		add(btnLimpiar);
		setSize(200, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
