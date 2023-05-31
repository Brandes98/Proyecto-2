package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class Hamburguesa {
    String nombre = "Basica";
    HashMap<String, Integer> ingredientes = new HashMap<>();
    int precioBase = 0;
    int precioAdicionales = 0;
    int precioFinal = 0;
    
    public Hamburguesa(){
        agregarIngrediente("Pan de hamburguesa");
        agregarIngrediente("Queso");
        agregarIngrediente("Lechuga");
        agregarIngrediente("Tomate");
        agregarIngrediente("Salsa de tomate");
        agregarIngrediente("Carne de res molida");
    }
    


    public boolean agregarIngrediente(String ingrediente){
        if (Ingredientes.existeIngrediente(ingrediente)){
            int precioIngrediente = Ingredientes.getPrecioBase(ingrediente);
            this.ingredientes.put(ingrediente, precioIngrediente);
            precioBase += precioIngrediente;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean quitarIngrediente(String ingrediente){
        if (Ingredientes.existeIngrediente(ingrediente)){
            if(this.ingredientes.containsKey(ingrediente)){
                int precioIngrediente = Ingredientes.getPrecioBase(ingrediente);
                this.ingredientes.remove(ingrediente);
                precioBase -= precioIngrediente;
                return true;
            }
        }else{
            return false;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Integer> getIngredientes() {
        return ingredientes;
    }

    public int getPrecioBase() {
        return precioBase;
    }


    public int getPrecioAdicionales() {
        return precioAdicionales;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }
    
    
    
}
 