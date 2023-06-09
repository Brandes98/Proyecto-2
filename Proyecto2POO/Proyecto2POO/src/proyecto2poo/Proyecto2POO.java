
package proyecto2poo;
import Model.InterfazCocinaController;
import Model.FabricaHamburguesa;
import Model.Hamburguesa;
import Model.HamburguesaUSA;
import Model.Ingredientes;
import Model.Pedido;
import Model.InterfazCocina;
import Model.ServidorCocina;
import Salon_cliente.InterfazSalon;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class Proyecto2POO {
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        InterfazCocinaController controlador = new InterfazCocinaController();
        
        
       
       /* ArrayList<Pedido> pedidos = new ArrayList<>();
        ArrayList<Hamburguesa> hambur = new ArrayList<>();
        
        hambur.add(FabricaHamburguesa.crearHamburguesa(0));
        hambur.add(FabricaHamburguesa.crearHamburguesa(2));
        
        Pedido pedido = new Pedido(1);
        pedido.setHamburguesas(hambur);
        
        pedidos.add(pedido);
        
        ArrayList<Pedido> pedidos2 = new ArrayList<>();
        ArrayList<Hamburguesa> hambur2 = new ArrayList<>();
        
        hambur2.add(FabricaHamburguesa.crearHamburguesa(0));
        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
//        hambur2.add(FabricaHamburguesa.crearHamburguesa(2));
        
        Pedido pedido2 = new Pedido(2);
        pedido2.setHamburguesas(hambur2);
        
        pedidos2.add(pedido2);
        InterfazCocinaController controlador = new InterfazCocinaController();
        controlador.pintarPedido(pedidos);
        controlador.pintarPedido(pedidos2);
        
        
//        InterfazCocina a = new InterfazCocina();
//        a.setVisible(true);*/
    }
    
}
