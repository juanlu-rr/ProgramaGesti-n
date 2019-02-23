package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorAltaHotel implements ActionListener, WindowListener  {
	ModeloAltaHotel mah = null;
	VistaAltaHotel vah = null;
	
	public ControladorAltaHotel(ModeloAltaHotel modeloAltaHotel, VistaAltaHotel vistaAltaHotel) {
		this.mah = modeloAltaHotel;
		this.vah = vistaAltaHotel;
		
		vah.addWindowListener(this);
		vah.btnAceptar.addActionListener(this);
		vah.btnLimpiar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(vah.btnLimpiar)) {
			vah.txtNombre.selectAll();
			vah.txtNombre.setText("");
			vah.txtEstrellas.selectAll();
			vah.txtEstrellas.setText("");
			vah.txtCiudad.selectAll();
			vah.txtCiudad.setText("");
			vah.txtNombre.requestFocus();
		}

		else if(o.equals(vah.btnAceptar)) {
			try {
				ModeloAltaHotel.AltaHotel(vah.txtNombre.getText(),vah.txtEstrellas.getText(),vah.txtCiudad.getText());
			} catch (ClassNotFoundException | SQLException | IOException e2) {
				e2.printStackTrace();
			}
			try {
				ModeloAltaHotel.registrar("INSERT INTO HOTELES VALUES" + " ("+vah.txtNombre.getText(),vah.txtEstrellas.getText(),
						vah.txtCiudad.getText()+")");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		vah.setVisible(false);
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
}
