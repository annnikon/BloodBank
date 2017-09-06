package ua.nure.nikonova.bloodbank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	public static final int PORT = 8080;
	public static final String HOST = "localhost";
	private Socket socket;
	private DataOutputStream out;	
	private DataInputStream in;
	
	Scanner scanner;
	
	public Client() {
		try {			
			this.socket = new Socket(HOST, PORT);
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.scanner = new Scanner(System.in);
			
		}
	catch(IOException e) {
		System.out.println("Cannot create socket: "+e);
	}
	}
	
	@Override
	public void run() {
		try{
		String message="";		
		while(!message.equals("exit")) {
			System.out.println("Enter message:");			
			message = scanner.nextLine();
			out.writeUTF(message);
			out.flush();
			System.out.printf("Sent command to server: %s",message);
			String answer = in.readUTF();
			System.out.println("Got an answer: ");
			System.out.println(answer);
			
		}
		if (message.equals("exit")) {
			
				try {
				socket.close();
				if (in!=null) {
					in.close();
					}
				if (out!=null) {
					out.close();
				}
				}
				catch(IOException exClose) {
					exClose.printStackTrace();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	public static void main(String[]args) {
		Client clientThread = new Client();
	
		clientThread.start();
		
	
	}	
}