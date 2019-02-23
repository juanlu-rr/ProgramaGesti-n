package es.studium.ProgramaGestión;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloLogin {
	public boolean comprobarCredenciales(String usuario,String clave) {
		boolean accesoPermitido = false;
		// Conectar a la base de datos para comprobar credenciales
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/agenciaviaje";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "SELECT * FROM usuarios WHERE nombreUsuario = '"+usuario+"' AND claveUsuario='"+convertirSHA256(clave)+"'";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
			rs = statement.executeQuery(sentencia);
			rs.next();
			if(rs.getRow()==1) {
				accesoPermitido = true;
			} else {
				accesoPermitido = false;
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
		return (accesoPermitido);
	}

	public String convertirSHA256(String password) 
	{
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}

		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();

		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}
	public static void registrar(String usuario, String mensaje) throws IOException {

		Date fechaHora = new Date();
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss  dd/MM/yyyy");
		String hourDateFormat= format.format(fechaHora);
		
		FileWriter fw= new FileWriter("fichero.txt",true);
		BufferedWriter bw= new BufferedWriter(fw);
		PrintWriter salida = new PrintWriter(bw);
		salida.println("["+hourDateFormat+"]" + "["+usuario+"]" + "["+mensaje+"]");
		salida.close();
		bw.close();
		fw.close();
	}

}
