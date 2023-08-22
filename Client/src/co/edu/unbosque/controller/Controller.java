package co.edu.unbosque.controller;

import java.util.Scanner;

public class Controller {

	private Scanner sc = new Scanner(System.in);
	
	static int PORT = 8000;
	static String IP = "127.0.0.1";

	public Controller() {

		funcionar();

	}

	public void funcionar() {

		System.out.println("Bienvenido al Resaturante");
		System.out.println("1) Local a Local" + "\n" + "2) Remoto " + "\n" +"salir");

		int seleccion = sc.nextInt();

		switch (seleccion) {
		case 1:
			System.out.println("Ingresaste de local a local el servidor debe estar encendido");
			ClientU c = new ClientU(IP, PORT);
			c.start();

			break;

		case 2:
			System.out.println("Ingresaste remotamente el servidor debe estar encendido");
			String ip1 = "";
			System.out.println("Ingresa direccion ip");
			ip1 = sc.next();
			ClientU c1 = new ClientU(ip1, PORT);
			c1.start();

			break;
			
		default:
			System.out.println("Saliste del menu");

		}
	}

}
