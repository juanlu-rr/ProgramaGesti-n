package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorModificacionHotel implements ActionListener, WindowListener {

	VistaModificacionHotel VistaModificacionHotel = null;
	ModeloModificacionHotel ModeloModificacionHotel = null;

	public ControladorModificacionHotel(ModeloModificacionHotel modeloModificacionHotel, VistaModificacionHotel vistaModificacionHotel) 
			throws IOException {
		this.VistaModificacionHotel = vistaModificacionHotel;
		this.ModeloModificacionHotel = modeloModificacionHotel;


		// Añadir los Listeners
		vistaModificacionHotel.btnModificar.addActionListener(this);
		vistaModificacionHotel.btnVolver.addActionListener(this);
		vistaModificacionHotel.btnAplicar.addActionListener(this);
		vistaModificacionHotel.btnCancelar.addActionListener(this);
		vistaModificacionHotel.addWindowListener(this);
		vistaModificacionHotel.dialogo.addWindowListener(this);
		vistaModificacionHotel.dialogo1.addWindowListener(this);
		vistaModificacionHotel.dialogo2.addWindowListener(this);
		modeloModificacionHotel.Mostrarchoice(vistaModificacionHotel.choice);
	}
	
	public void actionPerformed(ActionEvent evento) {
		Object objetoPulsado = evento.getSource();
		if(objetoPulsado.equals(VistaModificacionHotel.btnModificar)) {

			try  {
				ModeloModificacionHotel.EscribirTexto(VistaModificacionHotel.choice, VistaModificacionHotel.txtIdHotel,
						VistaModificacionHotel.txtNombreH, VistaModificacionHotel.txtEstrellas, VistaModificacionHotel.txtCiudad);
				VistaModificacionHotel.dialogo.setVisible(true);
				ModeloModificacionHotel.Mostrarchoice(VistaModificacionHotel.choice);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(objetoPulsado.equals(VistaModificacionHotel.btnVolver)) {
			VistaModificacionHotel.setVisible(false);
		}
		else if(objetoPulsado.equals(VistaModificacionHotel.btnAplicar)) {
			try  {
				ModeloModificacionHotel.ModificacionHotel(VistaModificacionHotel.choice, VistaModificacionHotel.txtNombreH,
						VistaModificacionHotel.txtEstrellas, VistaModificacionHotel.txtCiudad, VistaModificacionHotel.dialogo1,
						VistaModificacionHotel.dialogo2, VistaModificacionHotel.dialogo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else if(objetoPulsado.equals(VistaModificacionHotel.btnCancelar)) {
			VistaModificacionHotel.dialogo.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		if(VistaModificacionHotel.isActive()) {
			VistaModificacionHotel.setVisible(false);
		}
		else if(VistaModificacionHotel.dialogo.isActive()) {
			VistaModificacionHotel.dialogo.setVisible(false);
		}
		else if(VistaModificacionHotel.dialogo1.isActive()) {
			VistaModificacionHotel.dialogo1.setVisible(false);
		} else {
			System.exit(0);
		}	
	}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}
}