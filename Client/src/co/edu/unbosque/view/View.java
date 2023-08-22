package co.edu.unbosque.view;

import java.util.Scanner;

public class View {
	
private Scanner sc;
	
	public View() {
		sc = new Scanner(System.in);
	}
	
	public int leerEntero(){
		return sc.nextInt();
	}
	
	public long leerLargo() {
		return sc.nextLong();
	}
	
	public float leerFlotante() {
		return sc.nextFloat();
	}
	
	public double leerDoble() {
		return sc.nextDouble();
	}
	
	public char leerCaracter() {
		return sc.next().charAt(0);
	}
	
	public String leerCadena() {
		return sc.next();
	}
	
	public String leerLineaCompleta() {
		return sc.nextLine();
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
	
	public void imprimirConSalto(String string) {
		System.out.println(string);
	}
	
	public void imprimirSinSalto(String mensaje) {
		System.out.print(mensaje);
	}


}
