package es.studium.ProgramaGestión;

import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ModeloConsultaViaje extends Frame{
	
	private static final long serialVersionUID = 1L;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/agenciaviaje";
	String login = "root";
	String password = "Studium2018;";
	String datos="";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	ModeloLogin modeloLogin = new ModeloLogin();


	public  void consultarViaje(Dialog dialogo, Label label) {
		Document documento = new Document();
		String sentencia = "Select * FROM viajes";
		try {

			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ModeloLogin.registrar(VistaLogin.txfUsuario.getText(), sentencia);
			FileOutputStream ficheroPdf = new
			FileOutputStream("ficheroPrograma.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			rs = statement.executeQuery(sentencia);
			documento.open();
			PdfPTable tabla = new PdfPTable(5);
			tabla.addCell(" ID del Viaje");
			tabla.addCell(" Origen del Viaje");
			tabla.addCell(" Destino del Viaje");
			tabla.addCell(" Fecha del Viaje");
			tabla.addCell(" Id del Cliente");
			while (rs.next()) {
				datos = Integer.toString(rs.getInt("idViaje"));
				datos = datos + "-" + rs.getString("origen");
				datos = datos + "-" + rs.getString("destino");
				datos = datos + "-" + rs.getString("fechaViaje");
				datos = datos + "-" + rs.getString("idClienteFK1");

				String[] programa = datos.split("-");
				String programa1 = programa[0];
				String programa2 = programa[1];
				String programa3 = programa[2];
				String programa4 = programa[3];
				String programa5 = programa[4];

				tabla.addCell("" + programa1);
				tabla.addCell("" + programa2);
				tabla.addCell("" + programa3);
				tabla.addCell("" + programa4);
				tabla.addCell("" + programa5);
			}
			documento.add(tabla);
			documento.close();

			try {
				File path = new File ("ficheroPrograma.pdf");
				Desktop.getDesktop().open(path);
				dialogo.setVisible(true);
			}
			catch (IOException ex) {
				dialogo.setVisible(true);
				label.setText("Error al Generar PDF");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
