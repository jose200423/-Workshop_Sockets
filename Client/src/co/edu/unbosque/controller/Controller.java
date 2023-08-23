package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.view.View;

public class Controller {

	
	private View v ;
	static int PORT = 8000;
	static String IP = "127.0.0.1";

	public Controller() {
		
		v = new View();

		funcionar();

	}

	public void funcionar() {

		v.imprimirConSalto("Bienvenido al Resaturante");
		v.imprimirConSalto("1) Local a Local" + "\n" + "2) Remoto " + "\n" +"salir");

		int seleccion = v.leerEntero();

		switch (seleccion) {
		case 1:
			v.imprimirConSalto("Ingresaste de local a local el servidor debe estar encendido");
			ClientU c = new ClientU(IP, PORT);
			c.start();

			break;

		case 2:
			v.imprimirConSalto("Ingresaste remotamente el servidor debe estar encendido");
			String ip1 = "";
			v.imprimirConSalto("Ingresa direccion ip");
			ip1 = v.leerCadena();
			ClientU c1 = new ClientU(ip1, PORT);
			c1.start();

			break;
			
		default:
			System.out.println("Saliste del menu");

		}
	}

}
