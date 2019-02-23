package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class VistaBajaHotel extends Frame {

	private static final long serialVersionUID = 1L;
	Button btnAceptar = new Button("Sí");
	Button btnElegir= new Button("Elegir");
	Button btnCancelar = new Button("No");
	Dialog dialogo = new Dialog(this, "Eliminar", true);
	Dialog dialogo2 = new Dialog(this, "Confirmación", true);
	Label lblDeSeleccion = new Label("Seleccionar el hotel a eliminar:");
	Label lblDeConfirmacion = new Label("¿Quieres eliminar este hotel?");
	Label lblDeEliminado = new Label("Hotel eliminado");
	Choice choice = new Choice();
	Panel panel = new Panel(new GridLayout(1,2));
	
	public VistaBajaHotel() {
		setLayout(new GridLayout(3,1));
		setTitle("Baja Hotel");
		
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
		choice.add("Seleccionar Hotel");
		setSize(400,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
}
