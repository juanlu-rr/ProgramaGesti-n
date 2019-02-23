package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorModificacionViaje implements ActionListener, WindowListener {

	VistaModificacionViaje VistaModificacionViaje = null;
	ModeloModificacionViaje ModeloModificacionViaje = null;

	public ControladorModificacionViaje(ModeloModificacionViaje modeloModificarViaje, VistaModificacionViaje vistaModificarViaje) 
			throws IOException {
		this.VistaModificacionViaje = vistaModificarViaje;
		this.ModeloModificacionViaje = modeloModificarViaje;


		// Añadir los Listeners
		vistaModificarViaje.btnModificar.addActionListener(this);
		vistaModificarViaje.btnVolver.addActionListener(this);
		vistaModificarViaje.btnAplicar.addActionListener(this);
		vistaModificarViaje.btnCancelar.addActionListener(this);
		vistaModificarViaje.addWindowListener(this);
		vistaModificarViaje.dialogo.addWindowListener(this);
		vistaModificarViaje.dialogo1.addWindowListener(this);
		vistaModificarViaje.dialogo2.addWindowListener(this);
		modeloModificarViaje.Mostrarchoice(vistaModificarViaje.choice);
	}
	
	public void actionPerformed(ActionEvent evento) {
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(VistaModificacionViaje.btnModificar)) {

			try  {
				ModeloModificacionViaje.EscribirTexto(VistaModificacionViaje.choice, VistaModificacionViaje.txtIdViaje,
						VistaModificacionViaje.txtOrigen, VistaModificacionViaje.txtDestino, VistaModificacionViaje.txtFecha);
				VistaModificacionViaje.dialogo.setVisible(true);
				ModeloModificacionViaje.Mostrarchoice(VistaModificacionViaje.choice);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(objetoPulsado.equals(VistaModificacionViaje.btnVolver)) {
			VistaModificacionViaje.setVisible(false);
		}
		else if(objetoPulsado.equals(VistaModificacionViaje.btnAplicar)) {
			try  {
				ModeloModificacionViaje.ModificacionViaje(VistaModificacionViaje.choice, VistaModificacionViaje.txtOrigen,
						VistaModificacionViaje.txtDestino, VistaModificacionViaje.txtFecha, VistaModificacionViaje.dialogo1,
						VistaModificacionViaje.dialogo2, VistaModificacionViaje.dialogo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else if(objetoPulsado.equals(VistaModificacionViaje.btnCancelar)) {
			VistaModificacionViaje.dialogo.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(VistaModificacionViaje.isActive()) {
			VistaModificacionViaje.setVisible(false);
		}
		else if(VistaModificacionViaje.dialogo.isActive()) {
			VistaModificacionViaje.dialogo.setVisible(false);
		}
		else if(VistaModificacionViaje.dialogo1.isActive()) {
			VistaModificacionViaje.dialogo1.setVisible(false);
		} else {
			System.exit(0);
		}	
	}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}
}