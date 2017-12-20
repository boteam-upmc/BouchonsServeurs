package clientandroid;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientAndroid {

	private static int PORT = 60372;	
	private static String ID_EXPECTED 	= "ASSOC/1/1\r";
	
	private static Socket soc;
	
	public static void main(String[] args) {
		OutputStream output = null;
		try {
			soc = new Socket((String)null, PORT);
			System.out.println("Connection with Web Server established");
			output = soc.getOutputStream();
			output.write(ID_EXPECTED.getBytes());
			System.out.println("Message sent : " + ID_EXPECTED);
			
			char c = 0;
			int i;
			String message = "";
			InputStream input = soc.getInputStream();
			while(c != '\r') {
				i = input.read();
		        c = (char)i;
		        message+=c;
	        }
			System.out.println("Server response : " + message);
			
		} 
		catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println("IOException 1");
            e.printStackTrace();
        }
		finally{
            try{
            	output.close();
                soc.close();
                System.out.println("Connection completed");
            }
            catch (IOException e){
            	System.out.println("IOException 2");
                e.printStackTrace();
            }
        }
	}
}
