package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class VistaModificacionHotel extends Frame{
	private static final long serialVersionUID = 1L;
	Label lblIdHotel = new Label(" ID del Hotel ");
	Label nombreH = new Label(" Nombre del Hotel ");
	Label estrellas = new Label(" Estrellas del Hotel ");
	Label ciudad = new Label(" Ciudad del Hotel ");
	Label lblConfirmacion = new Label(" Hotel modificado");
	Label lblError = new Label(" Error al modificar Hotel");
	
	TextField txtIdHotel = new TextField(20);
	TextField txtNombreH = new TextField(20);
	TextField txtEstrellas = new TextField(20);
	TextField txtCiudad = new TextField(20);
	
	Dialog dialogo = new Dialog(this, "Actualizar", true);
	Dialog dialogo1 = new Dialog(this, "Actualizado", true);
	Dialog dialogo2 = new Dialog(this, "Error", true);
	
	Button btnModificar = new Button("Modificar");
	Button btnVolver = new Button("Volver");
	Button btnCancelar= new Button("Cancelar");
	Button btnAplicar = new Button("Aplicar");
	
	Choice choice = new Choice();
	String datos = "";
	
	public VistaModificacionHotel() {
		setLayout(new FlowLayout());
		setTitle("Modificación Hotel");
		
		dialogo.setLayout(new GridLayout(5,2));
		dialogo.setTitle("Modificando Hotel");
		dialogo.setSize(400, 400);
		dialogo.add(lblIdHotel);
		dialogo.add(txtIdHotel);
		dialogo.add(nombreH);
		dialogo.add(txtNombreH);
		dialogo.add(estrellas);
		dialogo.add(txtEstrellas);
		dialogo.add(ciudad);
		dialogo.add(txtCiudad);
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
		choice.add("Seleccionar Hotel");
		add(btnModificar);
		add(btnVolver);
		
		setSize(400,200);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
}
