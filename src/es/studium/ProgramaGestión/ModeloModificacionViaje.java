package es.studium.ProgramaGestión;

import java.awt.Choice;
import java.awt.Dialog;
import java.awt.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ModeloModificacionViaje {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/agenciaviaje";
	String login = "root";
	String password = "Studium2018;";
	String datos = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	ModeloLogin modeloLogin = new ModeloLogin();

	public Choice Mostrarchoice(Choice choice) 
	{
		try {
			String sentencia = "SELECT * FROM viajes";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			while(rs.next()) {
				datos = Integer.toString(rs.getInt("idViaje"));
				datos = datos + "-" + rs.getString("origen");
				datos = datos + "-" + rs.getString("destino");
				datos = datos + "-" + rs.getString("fechaViaje");
				datos = datos + "-" + rs.getString("idClienteFK1");
				choice.add(datos);
			}

		}

		catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle) {
			System.out.println("Error 2-"+sqle.getMessage());
		}
		finally {
			try {
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e) {
				System.out.println("Error 3-"+e.getMessage());
			}
		}
		return choice;

	}
	public void ModificacionViaje(Choice choice, TextField cadena1, TextField cadena2, TextField cadena3, Choice choiceMod, Dialog dialogo, Dialog dialogo1, Dialog dialogo2) throws ClassNotFoundException, SQLException, IOException 
	{

		String cadena = choice.getSelectedItem();
		String[] programs = cadena.split("-");
		String program1 = programs[0];
		
		String cadenaMod = choiceMod.getSelectedItem();
		String[] programsMod = cadenaMod.split("-");
		String program2 = programs[0];
		int idClienteFK = Integer.parseInt(program2);

		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), ("UPDATE viajes SET origen ='" + cadena1.getText() + "' WHERE idViaje=" + program1));
		ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), ("UPDATE viajes SET destino ='" + cadena2.getText() + "' WHERE idViaje=" + program1));
		ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), ("UPDATE viajes SET fechaViaje ='" + cadena3.getText() + "' WHERE idViaje=" + program1));

		int result1 = statement.executeUpdate("UPDATE viajes SET origen ='" + cadena1.getText() + "' WHERE idViaje=" + program1);
		int result2 = statement.executeUpdate("UPDATE viajes SET destino ='" + cadena2.getText() + "' WHERE idViaje=" + program1);
		statement.executeUpdate("UPDATE viajes SET fechaViaje ='" + cadena3.getText() + "' WHERE idViaje=" + program1);

		if (result1 == 1 && result2==1) {
			dialogo.setVisible(true);
			dialogo2.setVisible(false);
		} else {
			dialogo1.setVisible(true);
		}
		choice.removeAll();			
	}


	public void  EscribirTexto(Choice choice, TextField cadena1, TextField cadena2, TextField cadena3, TextField cadena4 ) 
			throws ClassNotFoundException, SQLException {

		String cadena = choice.getSelectedItem();
		String[] programs = cadena.split("-");
		String program1 = programs[0];
		String program2 = programs[1];
		String program3 = programs[2];
		String program4 = programs[3];

		cadena1.setText(program1);
		cadena1.setEditable(false);
		cadena2.setText(program2);
		cadena3.setText(program3);
		cadena4.setText(program4);
	}
	public Choice MostrarChoiceMod(Choice choiceMod) 
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/agenciaviaje";
		String login = "root";
		String password = "Studium2018;";
		String datos="";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			String sentencia = "SELECT * FROM clientes";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			while(rs.next()) {
				datos = Integer.toString(rs.getInt("idCliente"));
				datos = datos + "-" + rs.getString("nombreCliente");
				choiceMod.add(datos);
			}
		}



		catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle) {
			System.out.println("Error 2-"+sqle.getMessage());
		}
		finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}
			catch (SQLException e) {
				System.out.println("Error 3-"+e.getMessage());
			}
		}
		return choiceMod;
	}
}



