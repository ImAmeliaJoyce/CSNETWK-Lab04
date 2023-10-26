import java.net.*;
import java.io.*;

/*
 * CSNETWK - S16
 * GROUP 4
 * 
 * ABENOJA, Amelia Joyce L.
 * SANG, Nathan Immanuel C.
 * 
 */

public class ChatClient
{
	public static void main(String[] args)
	{
		String sServerAddress = args[0];
		int nPort = Integer.parseInt(args[1]);

		String user = args[2];
		String userMessage = args[3];
		
		try
		{
			Socket clientEndpoint = new Socket(sServerAddress, nPort);

			System.out.println(user + ": Connecting to server at " + clientEndpoint.getRemoteSocketAddress());
			System.out.println("");

			System.out.println(user + ": Connected to server at " + clientEndpoint.getRemoteSocketAddress());
			System.out.println("");

			DataOutputStream dosWriter = new DataOutputStream(clientEndpoint.getOutputStream());
			dosWriter.writeUTF(user + ": " + userMessage);
			
			DataInputStream disReader = new DataInputStream(clientEndpoint.getInputStream());
			System.out.println(disReader.readUTF());
			System.out.println("");
			
			clientEndpoint.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Client: Connection is terminated.");
		}
	}
}