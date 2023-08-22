package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class ClientU extends Thread {

	private Socket socket;
	private ServerSocket server;
	private Scanner sn;
	private DataOutputStream out;
	private DataInputStream in;
	private String address;
	private int port;

	public ClientU(String address, int port) {

		this.socket = null;
		this.server = null;
		this.sn = new Scanner(System.in);
		this.out = null;
		this.address = address;
		this.port = port;

	}

	public void run() {
		
		String line = "";
		
		try {
			 
			
            while (sn.hasNext()) {
            	this.socket = new Socket(this.address, this.port); 
                System.out.println("Connected"); 
				this.out = new DataOutputStream(socket.getOutputStream()); 
                line=sn.nextLine();
                this.out.writeUTF(line);
                 
			}
		} catch (IOException i) {
			System.out.println(i);
		}
        }
	
	
	 public static void main(String args[]) 
	    { 
	    	//Servidor server = new Servidor(5001); 
	    	ClientU client = new ClientU("127.0.0.1", 8000); 
	    	client.start();
	    	
	    } 

}
