package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class VistaModificacionCliente extends Frame{
	private static final long serialVersionUID = 1L;
	Label lblId = new Label("ID del Cliente ");
	Label nombreC = new Label("Nombre del Cliente ");
	Label apellidosC = new Label("Apellidos del Cliente ");
	Label dniC = new Label("DNI del Cliente");
	Label lblConfirmacion = new Label("Cliente modificado");
	Label lblError = new Label("Error al modificar Cliente");
	
	TextField txfIdCliente = new TextField(20);
	TextField txfNombre = new TextField(20);
	TextField txfApellidos = new TextField(20);
	TextField txfDNI = new TextField(20);
	
	Dialog dialogo = new Dialog(this, "Actualizar", true);
	Dialog dialogo1 = new Dialog(this, "Actualizado", true);
	Dialog dialogo2 = new Dialog(this, "Error", true);
	
	Button btnModificar = new Button("Modificar");
	Button btnVolver = new Button("Volver");
	Button btnCancelar= new Button("Cancelar");
	Button btnAplicar = new Button("Aplicar");
	
	Choice choice = new Choice();
	String datos = "";
	
	public VistaModificacionCliente() {
		setLayout(new FlowLayout());
		setTitle("Modificación Clientes");
		
		dialogo.setLayout(new GridLayout(5,2));
		dialogo.setTitle("Modificando Cliente");
		dialogo.setSize(400, 400);
		dialogo.add(lblId);
		dialogo.add(txfIdCliente);
		dialogo.add(nombreC);
		dialogo.add(txfNombre);
		dialogo.add(apellidosC);
		dialogo.add(txfApellidos);
		dialogo.add(dniC);
		dialogo.add(txfDNI);
		dialogo.add(btnAplicar);
		dialogo.add(btnCancelar);
		dialogo.setLocationRelativeTo(null);
		
		dialogo1.add(lblConfirmacion);
		dialogo1.setSize(300, 300);
		dialogo1.setLocationRelativeTo(null);
		
		dialogo2.add(lblError);
		dialogo2.setSize(300, 300);
		dialogo2.setLocationRelativeTo(null);
		
		add(choice);
		choice.add("Seleccionar cliente");
		add(btnModificar);
		add(btnVolver);
		
		setSize(400,200);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
}
