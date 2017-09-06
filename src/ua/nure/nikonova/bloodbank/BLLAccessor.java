package ua.nure.nikonova.bloodbank;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BLLAccessor {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(8080);
		System.out.println("BLL is online");
		while (true) {
			Socket s = ss.accept();
			System.out.println("Accepted client: "+s.getLocalPort());
			AccessorThread user = new AccessorThread(s);
			new Thread(user).start();
		}
	}
}