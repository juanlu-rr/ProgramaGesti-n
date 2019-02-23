package es.studium.ProgramaGestión;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

public class ControladorAltaCliente implements ActionListener, WindowListener  {
	ModeloAltaCliente modelAC = null;
	VistaAltaCliente vAltaC = null;
	
	public ControladorAltaCliente(ModeloAltaCliente modeloAltaClientes, VistaAltaCliente vistaAltaCliente) {
		this.modelAC = modeloAltaClientes;
		this.vAltaC = vistaAltaCliente;
		
		vAltaC.addWindowListener(this);
		vAltaC.btnAceptar.addActionListener(this);
		vAltaC.btnLimpiar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(vAltaC.btnLimpiar)) {
			vAltaC.txfNombre.selectAll();
			vAltaC.txfNombre.setText("");
			vAltaC.txfApellidos.selectAll();
			vAltaC.txfApellidos.setText("");
			vAltaC.txfDNI.selectAll();
			vAltaC.txfDNI.setText("");
			vAltaC.txfNombre.requestFocus();
		}

		else if(o.equals(vAltaC.btnAceptar)) {
			try {
				ModeloAltaCliente.AltaCliente(vAltaC.txfNombre.getText(),vAltaC.txfApellidos.getText(),vAltaC.txfDNI.getText());
			} catch (ClassNotFoundException | SQLException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				ModeloAltaCliente.registrar("INSERT INTO CLIENTES VALUES" + " ("+vAltaC.txfNombre.getText(),vAltaC.txfApellidos.getText(),
						vAltaC.txfDNI.getText()+")");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		vAltaC.setVisible(false);
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
}
