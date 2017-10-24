package serveurweb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurWeb {

	private static int PORT = 1337;	
	private static String ID_EXPECTED 	= "ASSOC/1/1\r";
	private static String VALID_ID		= "VALID/TRUE\r";
	private static String UNVALID_ID	= "VALID/FALSE\r";
	
	private static ServerSocket soc;
	
	public static void main(String[] args) {
		try {
			soc = new ServerSocket(PORT);
			System.out.println("Web Server is running on " + PORT + "...");

			while(true){
				
				int i = 0;
				char c = 0;
				String message = "";
				
				Socket client = soc.accept();
				System.out.println("Connection with Android client established");
				InputStream input = client.getInputStream();
				
				while(c != '\r') {
					i = input.read();
			        c = (char)i;
			        message+=c;
		        }
				System.out.println("Message received : " + message);
				
				if (message.compareTo(ID_EXPECTED) == 0) {
					OutputStream output = client.getOutputStream();
					output.write(VALID_ID.getBytes());
					client.close();
				} else {
					OutputStream output = client.getOutputStream();
					output.write(UNVALID_ID.getBytes());
					client.close();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
