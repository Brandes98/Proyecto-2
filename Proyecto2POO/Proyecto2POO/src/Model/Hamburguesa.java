package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.io.Serializable;
/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class Hamburguesa implements Serializable {
    private String nombre = "Basica";
    private HashMap<String, Integer> ingredientes = new HashMap<>();
    private int precioBase = 0;
    private int precioAdicionales = 0;
    private int precioFinal = 0;


   
    
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
            precioFinal += precioIngrediente;
            if(this.nombre.contains("Adicional")){
                this.precioAdicionales += precioIngrediente;
            }
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
                precioFinal -= precioIngrediente;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngredientes(HashMap<String, Integer> ingredientes) {
        this.ingredientes = ingredientes;
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
 