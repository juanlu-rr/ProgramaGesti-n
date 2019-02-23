package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorConsultaHotel implements ActionListener, WindowListener{
	VistaConsultaHotel vistaConsultaHotel = null;
	ModeloConsultaHotel modeloConsultaHotel = null;
	
	public ControladorConsultaHotel(ModeloConsultaHotel modeloConsultaHotel, VistaConsultaHotel vistaConsultaHotel) {
		this.vistaConsultaHotel = vistaConsultaHotel;
		this.modeloConsultaHotel = modeloConsultaHotel;

		vistaConsultaHotel.btnAceptar.addActionListener(this);
		vistaConsultaHotel.addWindowListener(this);
		vistaConsultaHotel.dialog.addWindowListener(this);
	}
	public void actionPerformed(ActionEvent evento) {
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(vistaConsultaHotel.btnAceptar)) {
			modeloConsultaHotel.consultarHotel(vistaConsultaHotel.dialog, vistaConsultaHotel.lblConfirmacion);
		}
		
	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(vistaConsultaHotel.isActive()) {
			vistaConsultaHotel.setVisible(false);
		}
		else if(vistaConsultaHotel.dialog.isActive()) {
			vistaConsultaHotel.dialog.setVisible(false);
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
