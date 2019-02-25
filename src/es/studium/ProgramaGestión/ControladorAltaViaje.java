package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorAltaViaje implements ActionListener, WindowListener  {
	ModeloAltaViaje modeloAV = null;
	VistaAltaViaje vistaAV = null;
	
	public ControladorAltaViaje(ModeloAltaViaje modeloAltaViaje, VistaAltaViaje vistaAltaViaje) {
		this.modeloAV = modeloAltaViaje;
		this.vistaAV = vistaAltaViaje;
		
		vistaAV.addWindowListener(this);
		vistaAV.btnAceptar.addActionListener(this);
		vistaAV.btnLimpiar.addActionListener(this);
		modeloAltaViaje.Mostrarchoice(vistaAltaViaje.choice);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(vistaAV.btnLimpiar)) {
			vistaAV.txtOrigen.selectAll();
			vistaAV.txtOrigen.setText("");
			vistaAV.txtDestino.selectAll();
			vistaAV.txtDestino.setText("");
			vistaAV.txtFecha.selectAll();
			vistaAV.txtFecha.setText("");
			vistaAV.txtOrigen.requestFocus();
		}

		else if(o.equals(vistaAV.btnAceptar)) {
			try {
				ModeloAltaViaje.AltaViaje(vistaAV.txtOrigen.getText(),vistaAV.txtDestino.getText(),
						vistaAV.txtFecha.getText(), vistaAV.choice);
			} catch (ClassNotFoundException | SQLException | IOException e2) {
				e2.printStackTrace();
			}
			try {
				ModeloAltaViaje.registrar("INSERT INTO VIAJES VALUES" + " ("+vistaAV.txtOrigen.getText(),vistaAV.txtDestino.getText(),
						vistaAV.txtFecha.getText(), vistaAV.choice.getSelectedItem()+")");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		vistaAV.setVisible(false);
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
}
