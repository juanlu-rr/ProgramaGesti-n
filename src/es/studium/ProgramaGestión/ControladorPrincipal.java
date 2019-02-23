package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorPrincipal implements ActionListener, WindowListener {
	VistaPrincipal vPrincipal = null;
	ModeloPrincipal mPrincipal = null;

	// Construtores
	public ControladorPrincipal(ModeloPrincipal modelo, VistaPrincipal vista) {
		this.mPrincipal = modelo;
		this.vPrincipal = vista;

		// Añadir los Listeners
		vista.addWindowListener(this);
		vista.menuAltaCliente.addActionListener(this);
		vista.menuBajaCliente.addActionListener(this);
		vista.menuModificacionCliente.addActionListener(this);
		vista.menuConsultaCliente.addActionListener(this);

		vista.menuAltaViaje.addActionListener(this);
		vista.menuBajaViaje.addActionListener(this);
		vista.menuModificacionViaje.addActionListener(this);
		vista.menuConsultaViaje.addActionListener(this);

		vista.menuAltaHotel.addActionListener(this);
		vista.menuBajaHotel.addActionListener(this);
		vista.menuModificacionHotel.addActionListener(this);
		vista.menuConsultaHotel.addActionListener(this);

		vista.abrirAyuda.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ae) {
		Object a;
		a = ae.getSource();
		if(a.equals(vPrincipal.menuAltaCliente))
		{
			ModeloAltaCliente ModeloAltaCliente = new ModeloAltaCliente();
			VistaAltaCliente vistaAltaC = new VistaAltaCliente();
			new ControladorAltaCliente(ModeloAltaCliente, vistaAltaC);
		}
		else if(a.equals(vPrincipal.menuBajaCliente))
		{
			ModeloBajaCliente ModeloBajaCliente = new ModeloBajaCliente();
			VistaBajaCliente VistaBajaCliente = new VistaBajaCliente();
			try {
				new ControladorBajaCliente(ModeloBajaCliente, VistaBajaCliente);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(a.equals(vPrincipal.menuModificacionCliente))
		{
			ModeloModificacionCliente modeloModificarCliente = new ModeloModificacionCliente();
			VistaModificacionCliente vistaModificarCliente = new VistaModificacionCliente();
			try {
				new ControladorModificacionCliente(modeloModificarCliente, vistaModificarCliente);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else if(a.equals(vPrincipal.menuConsultaCliente)) {
			VistaConsultaCliente vistaConsultaCliente = new VistaConsultaCliente();
			ModeloConsultaCliente modeloConsultaCliente = new ModeloConsultaCliente();
			new ControladorConsultaCliente(modeloConsultaCliente, vistaConsultaCliente);
			vistaConsultaCliente.setVisible(true);
		}

		else if(a.equals(vPrincipal.menuAltaViaje))
		{
			ModeloAltaViaje ModeloAltaViaje = new ModeloAltaViaje();
			VistaAltaViaje vistaAltaV = new VistaAltaViaje();
			new ControladorAltaViaje(ModeloAltaViaje, vistaAltaV);
		}
		else if(a.equals(vPrincipal.menuBajaViaje))
		{
			ModeloBajaViaje ModeloBajaViaje = new ModeloBajaViaje();
			VistaBajaViaje VistaBajaViaje = new VistaBajaViaje();
			try {
				new ControladorBajaViaje(ModeloBajaViaje, VistaBajaViaje);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(a.equals(vPrincipal.menuModificacionViaje))
		{
			ModeloModificacionViaje modeloModificarViaje = new ModeloModificacionViaje();
			VistaModificacionViaje vistaModificarViaje = new VistaModificacionViaje();
			try {
				new ControladorModificacionViaje(modeloModificarViaje, vistaModificarViaje);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else if(a.equals(vPrincipal.menuConsultaViaje)) {
			VistaConsultaViaje vistaConsultaViaje = new VistaConsultaViaje();
			ModeloConsultaViaje modeloConsultaViaje = new ModeloConsultaViaje();
			new ControladorConsultaViaje(modeloConsultaViaje, vistaConsultaViaje);
			vistaConsultaViaje.setVisible(true);
		}


		else if(a.equals(vPrincipal.menuAltaHotel))
		{
			ModeloAltaHotel ModeloAltaHotel = new ModeloAltaHotel();
			VistaAltaHotel vistaAltaH = new VistaAltaHotel();
			new ControladorAltaHotel(ModeloAltaHotel, vistaAltaH);
		}
		else if(a.equals(vPrincipal.menuBajaHotel))
		{
			ModeloBajaHotel ModeloBajaHotel = new ModeloBajaHotel();
			VistaBajaHotel VistaBajaHotel = new VistaBajaHotel();
			try {
				new ControladorBajaHotel(ModeloBajaHotel, VistaBajaHotel);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(a.equals(vPrincipal.menuModificacionHotel))
		{
			ModeloModificacionHotel modeloModificarHotel = new ModeloModificacionHotel();
			VistaModificacionHotel vistaModificarHotel = new VistaModificacionHotel();
			try {
				new ControladorModificacionHotel(modeloModificarHotel, vistaModificarHotel);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else if(a.equals(vPrincipal.menuConsultaHotel)) {
			VistaConsultaHotel vistaConsultaHotel = new VistaConsultaHotel();
			ModeloConsultaHotel modeloConsultaHotel = new ModeloConsultaHotel();
			new ControladorConsultaHotel(modeloConsultaHotel, vistaConsultaHotel);
			vistaConsultaHotel.setVisible(true);
		}


		else if (a.equals(vPrincipal.abrirAyuda)){
			ModeloPrincipal.botonAyuda();
		}
	}
	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}

}
