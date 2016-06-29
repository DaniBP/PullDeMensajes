package main;

import bd.GestionBD;
import controlador.AccesoController;
import vista.AccesoView;

/**
 * 
 * @author DanielBP
 *
 */
public class PullDeMensajes {

	/**
	 * Met�do para inicializar la aplicaci�n
	 * @param args Metodo main
	 */
	public static void main(String[] args) {
		GestionBD.getGestionBD();
		AccesoView accesoView=new AccesoView();
		AccesoController accesoController=new AccesoController(accesoView);
		accesoView.setVisible(true);
	}
}
