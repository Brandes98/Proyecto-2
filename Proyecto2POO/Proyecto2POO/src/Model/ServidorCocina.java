/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author brand
 */

import java.net.*;
import java.io.*;
import Model.Pedido;
import java.util.ArrayList;
public class ServidorCocina implements Runnable
{
   
    Socket client;
    ServerSocket server;
    ObjectInputStream input;
    
    public ArrayList<Pedido> pedidos = new ArrayList<>();
    public ServidorCocina()
    {
      
    }
   public void imprimirPedidos()
    {
     for (int i =0 ; i < pedidos.size();i++)
     {
         System.out.println("este pedido es: "+pedidos.get(i).getNumeroPedido());
     }
    }
    public void abrirConexion()
    {
        try{
            server = new ServerSocket(5555);
            client = server.accept();
            input = new ObjectInputStream(client.getInputStream());
            pedidos = (ArrayList<Pedido>)input.readObject();
            input.close();
            client.close();
            server.close();
            System.out.println("Mensaje enviado ");
            imprimirPedidos();
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

