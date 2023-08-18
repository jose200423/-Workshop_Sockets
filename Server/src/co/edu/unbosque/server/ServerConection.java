package co.edu.unbosque.server;


	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */

	import java.io.BufferedInputStream;
	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;

	/**
	 *
	 * @author englinx
	 */
	public class ServerConection extends Thread{
	    //initialize socket and input stream 
	    private Socket socket; //This socket is for read client message
	    private Socket socketR;//This socket is for send a message to client
	    private ServerSocket server; 
	    private DataInputStream in;
	    private DataOutputStream out;
	    private int	port;
	    private String addressClient;
	  
	    // constructor with port 
	    public ServerConection(int port){ 
	    	//initialize socket and input stream 
	    	this.socket=null;
	    	this.socketR=null;
	    	this.server=null; 
	    	this.in=null;
	    	this.out=null;
	    	this.port=port;
	    	this.addressClient=addressClient;
	     
	       
	    }
	    @Override
	    public void run(){
//	    	try {    	
//				
	//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	    	
	        String line = ""; 
	        // reads message from client until "Over" is sent 
	        while (!line.equals("Over")) 
	        { 
	            try
	            { 
	            	this.server = new ServerSocket(this.port);
	    			System.out.println("Server started"); 
	    	        System.out.println("Waiting for a client ..."); 
	    	        this.socket = server.accept(); 
	    	        System.out.println("Client accepted"); 
	    	        // takes input from the client socket 
	    	        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
	            	
	            	line = in.readUTF(); 
	                //Print in server the client message
	                System.out.println(line);
	                
	                //Send message to the client
	                //Create a socket to send message to client
	            	this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
	            	//sends output to the socket to client
	                this.out = new DataOutputStream(socketR.getOutputStream()); 
	                this.out.writeUTF("You send this: "+line+" :D");
	                this.out.close();
	                this.socketR.close();
	                
	                this.in.close();
	                this.server.close();
	            } 
	            catch(IOException i) 
	            { 
	                System.out.println(i); 
	            } 
	        } 
	        System.out.println("Closing connection"); 

	        // close connection 
	        try {
				socket.close();
				in.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	    } 
	    
	    public static void main(String args[]) 
	    { 
	        
	    	ServerConection server = new ServerConection(9500);
	    	server.start();
	    } 
	    
	    }
	    	
	    
	    

	    



