package es.studium.ProgramaGestión;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class VistaModificacionViaje extends Frame{
	private static final long serialVersionUID = 1L;
	Label lblIdViaje = new Label(" ID del Viaje ");
	Label origen = new Label(" Origen del Viaje ");
	Label destino = new Label(" Destino del Viaje ");
	Label fecha = new Label(" Fecha del Viaje ");
	Label idCliente = new Label(" Id Cliente ");
	Label lblConfirmacion = new Label(" Viaje modificado");
	Label lblError = new Label(" Error al modificar Viaje");
	
	TextField txtIdViaje = new TextField(20);
	TextField txtOrigen = new TextField(20);
	TextField txtDestino = new TextField(20);
	TextField txtFecha = new TextField(20);
	
	Dialog dialogo = new Dialog(this, "Actualizar", true);
	Dialog dialogo1 = new Dialog(this, "Actualizado", true);
	Dialog dialogo2 = new Dialog(this, "Error", true);
	
	Button btnModificar = new Button("Modificar");
	Button btnVolver = new Button("Volver");
	Button btnCancelar= new Button("Cancelar");
	Button btnAplicar = new Button("Aplicar");
	
	Choice choice = new Choice();
	Choice choiceMod = new Choice();
	String datos = "";
	
	public VistaModificacionViaje() {
		setLayout(new FlowLayout());
		setTitle("Modificación Viaje");
		
		dialogo.setLayout(new GridLayout(6,2));
		dialogo.setTitle("Modificando Viaje");
		dialogo.setSize(400, 400);
		dialogo.add(lblIdViaje);
		dialogo.add(txtIdViaje);
		dialogo.add(origen);
		dialogo.add(txtOrigen);
		dialogo.add(destino);
		dialogo.add(txtDestino);
		dialogo.add(fecha);
		dialogo.add(txtFecha);
		dialogo.add(idCliente);
		dialogo.add(choiceMod);
		choiceMod.add("Seleccionar ID Cliente");
		
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
		choice.add("Seleccionar Viaje");
		add(btnModificar);
		add(btnVolver);
		
		setSize(400,200);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
}
