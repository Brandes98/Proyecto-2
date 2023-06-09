/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Salon_cliente;

/**
 *
 * @author brand
 */
import java.net.*;
import java.io.*;
import Model.Pedido;
import java.util.ArrayList;
public class ServidorSalon implements Runnable
{
   
    Socket client;
    ServerSocket server;
    ObjectInputStream input;
    
    int mesaE=5;
    public ServidorSalon()
    {
      
    }
  
    public void abrirConexion()
    {
        try{
            server = new ServerSocket(5555);
            client = server.accept();
            input = new ObjectInputStream(client.getInputStream());
            mesaE = (int)input.readObject();
            input.close();
            client.close();
            server.close();
            System.out.println("Mensaje recibido ");
            
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            abrirConexion();
        }
    }
}
