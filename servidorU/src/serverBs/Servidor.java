package serverBs;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author englinx
 */
public class Servidor extends Thread {
	// initialize socket and input stream
	private Socket socket; // This socket is for read client message
	private Socket socketR;// This socket is for send a message to client
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	private String addressClient;
	private GeneradorRespuestas gr;

	// constructor with port
	public Servidor(int port) {
		// initialize socket and input stream
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.addressClient = addressClient;
		gr = new GeneradorRespuestas();

	}

	@Override
	public void run() {

		try {
			this.server = new ServerSocket(this.port);
			System.out.println("Servidor iniciado");
			System.out.println("Esperando al cliente...");
			while (true) {
				this.socket = server.accept();
				System.out.println("Cliente aceptao");

				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				String respuestaDelCliente = in.readUTF();
				System.out.println("El cliente dijo: "+ respuestaDelCliente);
				String respuestaServidor = gr.darRespuesta(respuestaDelCliente);
				enviarRespuesta(socket, respuestaServidor);
				in.close();
				socket.close();
				if (respuestaDelCliente.equals("Salir")) {
					System.out.println("La sesion con el agente ha finalizado asjjkas");
					break;
				}
			}
		} catch (IOException i) {
			System.out.println(i);
		}

	}
	public void enviarRespuesta(Socket sk, String respuesta) {
		try {
			DataOutputStream salida = new DataOutputStream(sk.getOutputStream());
			salida.writeUTF("El servidor bot dice: "+respuesta);
			salida.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {

		Servidor server = new Servidor(5000);
		server.start();
	}

}
