package Model;

import java.util.ArrayList;

/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class Hamburguesa {
    String nombre;
    ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
    int precioBase;
    ArrayList<Ingredientes> adicionales = new ArrayList<Ingredientes>();
    int precioAdicionales;
    int precioFinal;
    
    public void agregarIngrediente(String ingrediente){
        if ()
        
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public <Ingredientes> getAdicionales() {
        return adicionales;
    }

    public int getPrecioAdicionales() {
        return precioAdicionales;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }
    
    
    
}
 