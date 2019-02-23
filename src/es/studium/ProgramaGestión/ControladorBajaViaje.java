package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorBajaViaje implements ActionListener,WindowListener
{
	VistaBajaViaje vistaBajaViaje = null;
	ModeloBajaViaje modeloBajaViaje = null;
	// Construtores
	public ControladorBajaViaje(ModeloBajaViaje modeloBajaViaje, VistaBajaViaje vistaBajaViaje) throws ClassNotFoundException, SQLException
	{
		this.modeloBajaViaje = modeloBajaViaje;
		this.vistaBajaViaje = vistaBajaViaje;

		// Añadir los Listeners
		vistaBajaViaje.btnAceptar.addActionListener(this);
		vistaBajaViaje.dialogo.addWindowListener(this);
		vistaBajaViaje.dialogo2.addWindowListener(this);
		vistaBajaViaje.addWindowListener(this);
		modeloBajaViaje.Mostrarchoice(vistaBajaViaje.choice);
		vistaBajaViaje.btnElegir.addActionListener(this);
		vistaBajaViaje.btnCancelar.addActionListener(this);

	}

	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(vistaBajaViaje.isActive()) {
			vistaBajaViaje.setVisible(false);
		}
		else if(vistaBajaViaje.dialogo.isActive()) {
			vistaBajaViaje.dialogo.setVisible(false);
		}
		else if(vistaBajaViaje.dialogo2.isActive()) {
			vistaBajaViaje.dialogo2.setVisible(false);

		}
		else if(vistaBajaViaje.dialogo2.isActive()) {
			vistaBajaViaje.dialogo.setVisible(false);

		} else {
			System.exit(0);
		}
	}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}
	public void actionPerformed(ActionEvent evento) {
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(vistaBajaViaje.btnElegir)) {
			vistaBajaViaje.dialogo.setVisible(true);
		}
		else if(objetoPulsado.equals(vistaBajaViaje.btnCancelar)) {
			vistaBajaViaje.dialogo.setVisible(false);
		}
		else if(objetoPulsado.equals(vistaBajaViaje.btnAceptar)) {
			try {
				modeloBajaViaje.BajaViaje(vistaBajaViaje.choice);

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vistaBajaViaje.dialogo.setVisible(false);
			vistaBajaViaje.dialogo2.setVisible(true);

		}
	}
}