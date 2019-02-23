package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorConsultaCliente implements ActionListener, WindowListener{
	VistaConsultaCliente vistaConsultaCliente = null;
	ModeloConsultaCliente modeloConsultaCliente = null;

	public ControladorConsultaCliente(ModeloConsultaCliente modeloConsultaCliente, VistaConsultaCliente vistaConsultaCliente) {
		this.vistaConsultaCliente = vistaConsultaCliente;
		this.modeloConsultaCliente = modeloConsultaCliente;

		vistaConsultaCliente.btnAceptar.addActionListener(this);
		vistaConsultaCliente.addWindowListener(this);
		vistaConsultaCliente.dialog.addWindowListener(this);
	}
	public void actionPerformed(ActionEvent evento) {
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(vistaConsultaCliente.btnAceptar)) {
			modeloConsultaCliente.consultarCliente(vistaConsultaCliente.dialog, vistaConsultaCliente.lblConfirmacion);
		}

	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(vistaConsultaCliente.isActive()) {
			vistaConsultaCliente.setVisible(false);
		}
		else if(vistaConsultaCliente.dialog.isActive()) {
			vistaConsultaCliente.dialog.setVisible(false);
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
