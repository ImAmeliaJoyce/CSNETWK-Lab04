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

public class ChatServer
{
	public static void main(String[] args)
	{
		int nPort = Integer.parseInt(args[0]);
		System.out.println("Server: Listening on port " + args[0] + "...");
		ServerSocket serverSocket;
		Socket serverEndpointClientA;
		Socket serverEndpointClientB;

		try 
		{
			serverSocket = new ServerSocket(nPort);

			// Connection of Client A
			System.out.println("");
			serverEndpointClientA = serverSocket.accept();
			System.out.println("Server: New client connected: " + serverEndpointClientA.getRemoteSocketAddress());
			System.out.println("");
			
			// Listening Port
			System.out.println("Server: Listening on port " + args[0] + "...");
			System.out.println("");
			
			// Connection of Client B
			serverEndpointClientB = serverSocket.accept();
			System.out.println("Server: New client connected: " + serverEndpointClientB.getRemoteSocketAddress());
			System.out.println("");

			// Saves messages from both clients
			DataInputStream disReaderClientA = new DataInputStream(serverEndpointClientA.getInputStream());
			DataInputStream disReaderClientB = new DataInputStream(serverEndpointClientB.getInputStream());

			// Get output streams of both clients
			DataOutputStream dosWriterClientA = new DataOutputStream(serverEndpointClientA.getOutputStream());
			DataOutputStream dosWriterClientB = new DataOutputStream(serverEndpointClientB.getOutputStream());

			// Send messages to respective clients
			dosWriterClientA.writeUTF("Message from " + disReaderClientB.readUTF());
			dosWriterClientB.writeUTF("Message from " + disReaderClientA.readUTF());

			serverEndpointClientA.close();
			serverEndpointClientB.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Server: Connection is terminated.");
		}
	}
}