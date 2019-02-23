package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorBajaHotel implements ActionListener,WindowListener
{
	VistaBajaHotel vistaBajaHotel = null;
	ModeloBajaHotel modeloBajaHotel = null;
	// Construtores
	public ControladorBajaHotel(ModeloBajaHotel modeloBajaHotel, VistaBajaHotel vistaBajaHotel) throws ClassNotFoundException, SQLException
	{
		this.modeloBajaHotel = modeloBajaHotel;
		this.vistaBajaHotel = vistaBajaHotel;

		// Añadir los Listeners
		vistaBajaHotel.btnAceptar.addActionListener(this);
		vistaBajaHotel.dialogo.addWindowListener(this);
		vistaBajaHotel.dialogo2.addWindowListener(this);
		vistaBajaHotel.addWindowListener(this);
		modeloBajaHotel.Mostrarchoice(vistaBajaHotel.choice);
		vistaBajaHotel.btnElegir.addActionListener(this);
		vistaBajaHotel.btnCancelar.addActionListener(this);

	}

	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(vistaBajaHotel.isActive()) {
			vistaBajaHotel.setVisible(false);
		}
		else if(vistaBajaHotel.dialogo.isActive()) {
			vistaBajaHotel.dialogo.setVisible(false);
		}
		else if(vistaBajaHotel.dialogo2.isActive()) {
			vistaBajaHotel.dialogo2.setVisible(false);

		}
		else if(vistaBajaHotel.dialogo2.isActive()) {
			vistaBajaHotel.dialogo.setVisible(false);

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
		if(objetoPulsado.equals(vistaBajaHotel.btnElegir)) {
			vistaBajaHotel.dialogo.setVisible(true);
		}
		else if(objetoPulsado.equals(vistaBajaHotel.btnCancelar)) {
			vistaBajaHotel.dialogo.setVisible(false);
		}
		else if(objetoPulsado.equals(vistaBajaHotel.btnAceptar)) {
			try {
				modeloBajaHotel.BajaHotel(vistaBajaHotel.choice);

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vistaBajaHotel.dialogo.setVisible(false);
			vistaBajaHotel.dialogo2.setVisible(true);

		}
	}
}