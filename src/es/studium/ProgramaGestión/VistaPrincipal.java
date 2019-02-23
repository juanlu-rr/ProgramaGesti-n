package es.studium.ProgramaGestión;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class VistaPrincipal extends Frame {

	private static final long serialVersionUID = 1L;
	MenuBar barraMenu = new MenuBar();
	Menu menuCliente = new Menu("Clientes");
	Menu menuViajes = new Menu("Viajes");
	Menu menuHoteles = new Menu("Hoteles");
	Menu menuAyuda = new Menu ("Ayuda");
	
	MenuItem menuAltaCliente = new MenuItem("Alta Cliente");
	MenuItem menuBajaCliente = new MenuItem("Baja Cliente");
	MenuItem menuModificacionCliente = new MenuItem("Modificación Cliente");
	MenuItem menuConsultaCliente = new MenuItem("Consulta Cliente");
	
	MenuItem menuAltaViaje = new MenuItem("Alta Viaje");
	MenuItem menuBajaViaje = new MenuItem("Baja Viaje");
	MenuItem menuModificacionViaje = new MenuItem("Modificación Viaje");
	MenuItem menuConsultaViaje = new MenuItem("Consulta Viaje");
	
	MenuItem menuAltaHotel = new MenuItem("Alta Hotel");
	MenuItem menuBajaHotel = new MenuItem("Baja Hotel");
	MenuItem menuModificacionHotel = new MenuItem("Modificación Hotel");
	MenuItem menuConsultaHotel = new MenuItem("Consulta Hotel");
	
	MenuItem abrirAyuda = new MenuItem("Abrir Ayuda");
	
	public VistaPrincipal() {
		
		setLayout (new FlowLayout());
		setTitle ("Menú Principal" );
		setMenuBar(barraMenu);
		
		menuCliente.add(menuAltaCliente);
		menuCliente.add(menuBajaCliente);
		menuCliente.add(menuModificacionCliente);
		menuCliente.add(menuConsultaCliente);
		
		menuViajes.add(menuAltaViaje);
		menuViajes.add(menuBajaViaje);
		menuViajes.add(menuModificacionViaje);
		menuViajes.add(menuConsultaViaje);
		
		menuHoteles.add(menuAltaHotel);
		menuHoteles.add(menuBajaHotel);
		menuHoteles.add(menuModificacionHotel);
		menuHoteles.add(menuConsultaHotel);
		
		menuAyuda.add(abrirAyuda);
		
		barraMenu.add(menuCliente);
		barraMenu.add(menuViajes);
		barraMenu.add(menuHoteles);
		barraMenu.add(menuAyuda);

		setLocationRelativeTo(null);
		setSize(350,350);
		setVisible(true);
	}

}
