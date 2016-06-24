package main;

import controlador.AccesoController;
import vista.AccesoView;

/**
 * 
 * @author DanielBP
 *
 */
public class PullDeMensajes {

	/**
	 * Metódo para inicializar la aplicación
	 * @param args Metodo main
	 */
	public static void main(String[] args) {
		AccesoView accesoView=new AccesoView();
		AccesoController accesoController=new AccesoController(accesoView);
		accesoView.setVisible(true);
	}
}
