package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class VistaBajaCliente extends Frame {

	private static final long serialVersionUID = 1L;
	Button btnAceptar = new Button("Sí");
	Button btnElegir= new Button("Elegir");
	Button btnCancelar = new Button("No");
	Dialog dialogo = new Dialog(this, "Eliminar", true);
	Dialog dialogo2 = new Dialog(this, "Confirmación", true);
	Label lblDeSeleccion = new Label("Seleccionar el cliente a eliminar:");
	Label lblDeConfirmacion = new Label("¿Quieres eliminar a este cliente?");
	Label lblDeEliminado = new Label("Cliente eliminado");
	Choice choice = new Choice();
	Panel panel = new Panel(new GridLayout(1,2));
	
	public VistaBajaCliente() {
		setLayout(new GridLayout(3,1));
		setTitle("Baja Cliente");
		
		add(lblDeSeleccion);
		add(choice);
		add(btnElegir);
		panel.add(btnAceptar);
		panel.add(btnCancelar);
		dialogo.setLayout(new GridLayout(2,1));
		dialogo.setSize(480, 120);
		dialogo.add(lblDeConfirmacion);
		dialogo.add(panel);
		dialogo.setLocationRelativeTo(null);
		dialogo2.add(lblDeEliminado);
		dialogo2.setSize(250,200);
		dialogo2.setLocationRelativeTo(null);
		choice.add("Seleccionar Cliente");
		setSize(400,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
}
