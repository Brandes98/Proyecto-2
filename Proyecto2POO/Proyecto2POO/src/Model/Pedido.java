package Model;

import java.util.ArrayList;

/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class Pedido {
    private int numeroPedido;
    private ArrayList<Hamburguesa> hamburguesas;


    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.hamburguesas = new ArrayList<>();
    }

    public void agregarHamburguesa(Hamburguesa hamburguesa) {
        hamburguesas.add(hamburguesa);
    }

//    public void enviarACocina(Cocina cocina) {
//        cocina.procesarPedido(this);
//    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public ArrayList<Hamburguesa> getHamburguesas() {
        return hamburguesas;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setHamburguesas(ArrayList<Hamburguesa> hamburguesas) {
        this.hamburguesas = hamburguesas;
    }




    
    
}
