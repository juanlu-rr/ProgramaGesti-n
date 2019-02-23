package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorModificacionCliente implements ActionListener, WindowListener {

	VistaModificacionCliente VistaModificacionCliente = null;
	ModeloModificacionCliente ModeloModificacionCliente = null;

	public ControladorModificacionCliente(ModeloModificacionCliente modeloModificacionCliente, VistaModificacionCliente vistaModificacionCliente) 
			throws IOException {
		this.VistaModificacionCliente = vistaModificacionCliente;
		this.ModeloModificacionCliente = modeloModificacionCliente;


		// Añadir los Listeners
		vistaModificacionCliente.btnModificar.addActionListener(this);
		vistaModificacionCliente.btnVolver.addActionListener(this);
		vistaModificacionCliente.btnAplicar.addActionListener(this);
		vistaModificacionCliente.btnCancelar.addActionListener(this);
		vistaModificacionCliente.addWindowListener(this);
		vistaModificacionCliente.dialogo.addWindowListener(this);
		vistaModificacionCliente.dialogo1.addWindowListener(this);
		vistaModificacionCliente.dialogo2.addWindowListener(this);
		modeloModificacionCliente.Mostrarchoice(vistaModificacionCliente.choice);
	}
	public void actionPerformed(ActionEvent evento)
	{
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(VistaModificacionCliente.btnModificar)) {

			try  {
				ModeloModificacionCliente.EscribirTexto(VistaModificacionCliente.choice, VistaModificacionCliente.txfIdCliente,
						VistaModificacionCliente.txfNombre, VistaModificacionCliente.txfApellidos, VistaModificacionCliente.txfDNI);
				VistaModificacionCliente.dialogo.setVisible(true);
				ModeloModificacionCliente.Mostrarchoice(VistaModificacionCliente.choice);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(objetoPulsado.equals(VistaModificacionCliente.btnVolver)) {
			VistaModificacionCliente.setVisible(false);
		}
		else if(objetoPulsado.equals(VistaModificacionCliente.btnAplicar)) {
			try  {
				ModeloModificacionCliente.ModificacionCliente(VistaModificacionCliente.choice, VistaModificacionCliente.txfNombre,
						VistaModificacionCliente.txfApellidos, VistaModificacionCliente.txfDNI, VistaModificacionCliente.dialogo1,
						VistaModificacionCliente.dialogo2, VistaModificacionCliente.dialogo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else if(objetoPulsado.equals(VistaModificacionCliente.btnCancelar)) {
			VistaModificacionCliente.dialogo.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(VistaModificacionCliente.isActive()) {
			// Ocultamos la ventana
			VistaModificacionCliente.setVisible(false);
		}
		else if(VistaModificacionCliente.dialogo.isActive()) {
			// Ocultamos la ventana
			VistaModificacionCliente.dialogo.setVisible(false);
		}
		else if(VistaModificacionCliente.dialogo1.isActive()) {
			// Ocultamos la ventana
			VistaModificacionCliente.dialogo1.setVisible(false);
		} else {
			System.exit(0);
		}	
	}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}
}