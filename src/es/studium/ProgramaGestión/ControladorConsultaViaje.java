package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorConsultaViaje implements ActionListener, WindowListener{
	VistaConsultaViaje vistaConsultaViaje = null;
	ModeloConsultaViaje modeloConsultaViaje = null;
	
	public ControladorConsultaViaje(ModeloConsultaViaje modeloConsultaViaje, VistaConsultaViaje vistaConsultaViaje) {
		this.vistaConsultaViaje = vistaConsultaViaje;
		this.modeloConsultaViaje = modeloConsultaViaje;

		vistaConsultaViaje.btnAceptar.addActionListener(this);
		vistaConsultaViaje.addWindowListener(this);
		vistaConsultaViaje.dialog.addWindowListener(this);
	}
	public void actionPerformed(ActionEvent evento) {
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(vistaConsultaViaje.btnAceptar)) {
			modeloConsultaViaje.consultarViaje(vistaConsultaViaje.dialog, vistaConsultaViaje.lblConfirmacion);
		}
		
	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(vistaConsultaViaje.isActive()) {
			vistaConsultaViaje.setVisible(false);
		}
		else if(vistaConsultaViaje.dialog.isActive()) {
			vistaConsultaViaje.dialog.setVisible(false);
		}
		else {
			System.exit(0);
		}	
	}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}

}
