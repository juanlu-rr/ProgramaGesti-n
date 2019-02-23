package es.studium.ProgramaGestión;

import java.io.IOException;

public class ModeloPrincipal {
	public static void botonAyuda(){
		try {
		Runtime.getRuntime().exec("hh.exe Ayuda.chm");
		}
		catch (IOException e) {
		e.printStackTrace();
		}
	}
}
