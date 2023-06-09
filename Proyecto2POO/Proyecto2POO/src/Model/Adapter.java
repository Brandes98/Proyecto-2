/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Pedido;
import Model.Hamburguesa;
import java.util.ArrayList;
/**
 *
 * @author brand
 */
public class Adapter {
    
    public Adapter(){
    }
   public void imprimirIngredientesPedido(Pedido pedido)
    {
        for(int i=0;i<pedido.getHamburguesas().size();i++)
        {
            for(int j=0;j<pedido.getHamburguesas().get(i).getIngredientes().size();j++)
            {
                System.out.println(pedido.getHamburguesas().get(i).getIngredientes().get(j));
            }
        }
    }
   public void imprimirHamburguesas(Pedido pedido)
    {
         for(int i=0;i<pedido.getHamburguesas().size();i++)
        {
   
                System.out.println("El tipo es: "+pedido.getHamburguesas().get(i).getNombre());
            
        }
    }
   public void total(Pedido pedido)
   {
        for(int i=0;i<pedido.getHamburguesas().size();i++)
        {
   
                System.out.println("El precio base es: "+pedido.getHamburguesas().get(i).getPrecioBase());
            System.out.println("El adicional es: "+pedido.getHamburguesas().get(i).getPrecioAdicionales());
            System.out.println("El total es: "+pedido.getHamburguesas().get(i).getPrecioFinal());
        }
   }
   public void imprimirloTodo(ArrayList<Pedido> pedidos)
    {
        for(int n =0;n<pedidos.size();n++)
        {
            imprimirHamburguesas(pedidos.get(n));
            total(pedidos.get(n));
        }
    }
    }

