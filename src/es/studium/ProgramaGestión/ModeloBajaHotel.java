package es.studium.ProgramaGestión;

import java.awt.Choice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloBajaHotel {
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
			String sentencia = "SELECT * FROM hoteles";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			while(rs.next()) {
				datos= Integer.toString(rs.getInt("idHotel"));
				datos= datos + "-" + rs.getString("nombreHotel");
				datos= datos + "-" + rs.getString("numeroEstrellas");
				datos= datos + "-" + rs.getString("ciudadHotel");
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
	public void  BajaHotel(Choice choice) throws ClassNotFoundException, SQLException, IOException {
		String cadena = choice.getSelectedItem();
		String[] programa1 = cadena.split("-");
		String programa2 = programa1[0];
		String sentencia = "Delete FROM hoteles where idHotel=" + programa2;
		ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), sentencia);
		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		statement.executeUpdate(sentencia);
	}
}
