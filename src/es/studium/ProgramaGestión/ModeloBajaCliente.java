package es.studium.ProgramaGestión;

import java.awt.Choice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloBajaCliente {
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
			String sentencia = "SELECT * FROM clientes";
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			//executeQuery para los select
			rs = statement.executeQuery(sentencia);
			while(rs.next()) {
				datos= Integer.toString(rs.getInt("idCliente"));
				datos= datos + "-" + rs.getString("nombreCliente");
				datos= datos + "-" + rs.getString("apellidosCliente");
				datos= datos + "-" + rs.getString("dniCliente");
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
	public void  BajaCliente(Choice choice) throws ClassNotFoundException, SQLException, IOException {
		String cadena = choice.getSelectedItem();
		String[] programa1 = cadena.split("-");
		String programa2 = programa1[0];
		String sentencia = "Delete FROM clientes where idCliente=" + programa2;
		ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), sentencia);
		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		statement.executeUpdate(sentencia);
	}
}
