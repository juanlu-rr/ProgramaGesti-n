package es.studium.ProgramaGestión;

import java.awt.Choice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloBajaViaje {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/agenciaviaje";
	String login = "root";
	String password = "Studium2018;";
	String datos="";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	boolean accesoPermitido = false;

	public Choice Mostrarchoice(Choice choice) {
		try {
			String sentencia = "SELECT * FROM viajes";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			while(rs.next()) {
				datos= Integer.toString(rs.getInt("idViaje"));
				datos= datos + "-" + rs.getString("origen");
				datos= datos + "-" + rs.getString("destino");
				datos= datos + "-" + rs.getString("fechaViaje");

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
	public void  BajaViaje(Choice choice) throws ClassNotFoundException, SQLException, IOException {
		String cadena = choice.getSelectedItem();
		String[] programa1 = cadena.split("-");
		String programa2 = programa1[0];
		String sentencia = "Delete FROM viajes where idViaje=" + programa2;
		ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), sentencia);
		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		statement.executeUpdate(sentencia);
	}
}
