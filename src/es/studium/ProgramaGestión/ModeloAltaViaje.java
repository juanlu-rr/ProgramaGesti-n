package es.studium.ProgramaGestión;

import java.awt.Choice;
import java.awt.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloAltaViaje {
	
	public static void AltaViaje(String txtOrigen, String txtDestino, String txtFecha, Choice choice)throws ClassNotFoundException, SQLException, IOException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/agenciaviaje";
		String login = "root";
		String password = "Studium2018;";
		Connection connection = null;
		java.sql.Statement statement = null;
		
		String cadena = choice.getSelectedItem();
		String[] programs = cadena.split("-");
		String id = programs[0];
		
		int idClienteFK = Integer.parseInt(id);

		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error 1. No se ha cargado el Driver");
		}
		try {
			connection = DriverManager.getConnection(url, login, password);
		}
		catch (SQLException e) {
			System.out.println("Error 2. No se ha conectado la Base de datos");
		}
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.executeUpdate("INSERT INTO viajes(origen, destino, fechaViaje, idClienteFK1)"
					+ " VALUES('"+txtOrigen+ "','" + txtDestino+"','"+txtFecha+"','"+idClienteFK+"')");
			ModeloLogin.registrar(VistaLogin.txfUsuario.getText(),"INSERT INTO viajes(origen, destino, fechaViaje, idClienteFK1)"
					+ " VALUES('"+txtOrigen+ "','" + txtDestino+"','"+txtFecha+"','"+idClienteFK+"')");
		}
		catch(SQLException e) {
			System.out.println("Error en la sentencia SQL");
		}
	}
//	public static void registrar(String origen, String destino, String fechaViaje, int idClienteFK1 ) throws IOException {
//		Date fechaHora = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss  dd/MM/yyyy");
//		String hourDateFormat= format.format(fechaHora);
//
//		FileWriter fw= new FileWriter("fichero.txt",true);
//		BufferedWriter bw= new BufferedWriter(fw);
//		PrintWriter salida = new PrintWriter(bw);
//		salida.println("["+hourDateFormat+"]" + "["+origen+"]" + "["+destino+"]" + "["+fechaViaje+"]" + "["+idClienteFK1+"]");
//		salida.close();
//		bw.close();
//		fw.close();
//
//		System.out.println("["+hourDateFormat+"]" + "["+origen+"," + destino+","+fechaViaje+","+idClienteFK1+"]");
//	}
	
	public Choice Mostrarchoice(Choice choice) {
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
				if(connection!=null) {
					connection.close();
				}
			}
			catch (SQLException e) {
				System.out.println("Error 3-"+e.getMessage());
			}
		}
		return choice;
	}
//	public void  SepararChoice(Choice choice) 
//			throws ClassNotFoundException, SQLException {
//		
//			String cadena = choice.getSelectedItem();
//			String[] programs = cadena.split("-");
//			String id = programs[0];
//			
//			int idClienteFK = Integer.parseInt(id);
//			
//				
//	}

}
