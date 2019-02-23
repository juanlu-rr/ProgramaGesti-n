package es.studium.ProgramaGestión;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloAltaHotel {

	public static void AltaHotel(String txtNombreH, String txtEstrellas, String txtCiudad)throws ClassNotFoundException, SQLException, IOException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/agenciaviaje";
		String login = "root";
		String password = "Studium2018;";
		Connection connection = null;
		java.sql.Statement statement = null;

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
			statement.executeUpdate("INSERT INTO hoteles(nombreHotel, numeroEstrellas, ciudadHotel )"
					+ " VALUES('"+txtNombreH+ "','" + txtEstrellas+"','"+txtCiudad+"')");
			
			ModeloLogin.registrar(VistaLogin.txfUsuario.getText(),"INSERT INTO hoteles(nombreHotel, estrellas, ciudad )"
					+ " VALUES('"+txtNombreH+ "','" + txtEstrellas+"','"+txtCiudad+"')");
		}
		catch(SQLException e) {
			System.out.println("Error en la sentencia SQL");
		}
	}
	public static void registrar(String nombreH, String estrellas, String ciudad) throws IOException {
		Date fechaHora = new Date();
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss  dd/MM/yyyy");
		String hourDateFormat= format.format(fechaHora);

		FileWriter fw= new FileWriter("fichero.txt",true);
		BufferedWriter bw= new BufferedWriter(fw);
		PrintWriter salida = new PrintWriter(bw);
		salida.println("["+hourDateFormat+"]" + "["+nombreH+"]" + "["+estrellas+"]" + "["+ciudad+"]");
		salida.close();
		bw.close();
		fw.close();

		System.out.println("["+hourDateFormat+"]" + "["+nombreH+"," + estrellas+","+ciudad+"]");
	}

}
