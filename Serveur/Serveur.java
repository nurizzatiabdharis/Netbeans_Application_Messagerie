import java.net.*;
import java.io.*;

public class Serveur
{
	
	//On a plusieurs
	public static void main (String arg[])
	{
		try{
			ServerSocket server= new ServerSocket(3000); //Choisir un port pour communiquer avec des clients
			Socket s = server.accept(); 
			
			System.out.println("Connction good"); //Si la connection est bonne, ce message va etre afficher sur le serveur
			
			DataInputStream in= new DataInputStream(s.getInputStream()); //créer une DataStream qui recois une input			
			DataOutputStream out = new DataOutputStream(s.getOutputStream());//créer une DataStream qui contient des messages pour etre envoyés
			
			String msg = in.readUTF(); //mettre un inpur de dataStream dans une variable de type String
			
			System.out.println(msg); // afficher le message
			String nulls=""; 
			
			if(msg != nulls)
			{
				out.writeUTF("{'result' : 'ok'}");//envoie un output au client
				System.out.println("Le message est acceptée");//on affiche ce message la su
				
			}
			
			
			
		}catch(Exception e){
			System.out.println("{'result' : 'data not received'}");//si'il y a des erreurs, ce message va etre affiche. 
			
		}
	}
} 
