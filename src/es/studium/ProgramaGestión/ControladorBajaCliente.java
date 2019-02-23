package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorBajaCliente implements ActionListener,WindowListener
{
	VistaBajaCliente vistaBajaCliente = null;
	ModeloBajaCliente modeloBajaCliente = null;
	// Construtores
	public ControladorBajaCliente(ModeloBajaCliente modeloBajaCliente, VistaBajaCliente vistaBajaCliente) throws ClassNotFoundException, SQLException
	{
		this.modeloBajaCliente = modeloBajaCliente;
		this.vistaBajaCliente = vistaBajaCliente;

		// Añadir los Listeners
		vistaBajaCliente.btnAceptar.addActionListener(this);
		vistaBajaCliente.dialogo.addWindowListener(this);
		vistaBajaCliente.dialogo2.addWindowListener(this);
		vistaBajaCliente.addWindowListener(this);
		modeloBajaCliente.Mostrarchoice(vistaBajaCliente.choice);
		vistaBajaCliente.btnElegir.addActionListener(this);
		vistaBajaCliente.btnCancelar.addActionListener(this);

	}

	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(vistaBajaCliente.isActive()) {
			vistaBajaCliente.setVisible(false);
		}
		else if(vistaBajaCliente.dialogo.isActive()) {
			vistaBajaCliente.dialogo.setVisible(false);
		}
		else if(vistaBajaCliente.dialogo2.isActive()) {
			vistaBajaCliente.dialogo2.setVisible(false);

		}
		else if(vistaBajaCliente.dialogo2.isActive()) {
			vistaBajaCliente.dialogo.setVisible(false);

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
		if(objetoPulsado.equals(vistaBajaCliente.btnElegir)) {
			vistaBajaCliente.dialogo.setVisible(true);
		}
		else if(objetoPulsado.equals(vistaBajaCliente.btnCancelar)) {
			vistaBajaCliente.dialogo.setVisible(false);
		}
		else if(objetoPulsado.equals(vistaBajaCliente.btnAceptar)) {
			try {
				modeloBajaCliente.BajaCliente(vistaBajaCliente.choice);

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vistaBajaCliente.dialogo.setVisible(false);
			vistaBajaCliente.dialogo2.setVisible(true);

		}
	}
}