
package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Ingredientes {
    private static  HashMap<String, Integer> ingredientes = new HashMap<>();

    static{
        ingredientes.put("Pan de hamburguesa", 500);
        ingredientes.put("Carne de res molida", 1000);
        ingredientes.put("Carne de pollo molida", 3000);
        ingredientes.put("Carne de pavo molida", 4000);
        ingredientes.put("Sal y pimienta", 250);
        ingredientes.put("Queso", 500);
        ingredientes.put("Lechuga", 250);
        ingredientes.put("Tomate", 250);
        ingredientes.put("Cebolla", 250);
        ingredientes.put("Pepinillos", 250);
        ingredientes.put("Salsa de tomate", 250);
        ingredientes.put("Mostaza", 250);
        ingredientes.put("Mayonesa", 250);

        // Ingredientes adicionales con el prefijo "Adicional_"
        ingredientes.put("Adicional_Queso adicional", 500);
        ingredientes.put("Adicional_Aguacate o guacamole", 750);
        ingredientes.put("Adicional_Salsa barbacoa", 250);
        ingredientes.put("Adicional_Salsa ranch", 250);
        ingredientes.put("Adicional_Salsa picante", 250);
        ingredientes.put("Adicional_Chiles jalapeños", 250);
        ingredientes.put("Adicional_Cebolla caramelizada", 250);
        ingredientes.put("Adicional_Chile con carne", 250);
        ingredientes.put("Adicional_Salsa de queso", 250);
        ingredientes.put("Adicional_Hongos", 250);
        ingredientes.put("Adicional_Aros de cebolla", 250);
        ingredientes.put("Adicional_Salsa de chipotle", 250);
        ingredientes.put("Adicional_Salsa de pesto", 250);
        ingredientes.put("Adicional_Salsa tártara", 250);
    }
    /**
     * Constructor de la clase Ingredientes.
     * 
     * precioBase El precio base de la hamburguesa en colones.
     */

    protected Ingredientes() {
//        inicializarIngredientes();
    }
    

    /**
     * Obtiene la lista de nombres de ingredientes disponibles.
     * ArrayList con los nombres de los ingredientes.
     */
    public static ArrayList<String> getNombresIngredientes() {
        return new ArrayList<>(ingredientes.keySet());
    }
    
    public static boolean existeIngrediente(String ingrediente){
        return ingredientes.containsKey(ingrediente);
    }

    /**
     * Obtiene el precio base de la hamburguesa en colones.
     * El precio base en colones.
     */
    public static int getPrecioBase(String ingrediente) {
        return ingredientes.get(ingrediente);
    }

    /**
     * Calcula el precio total de la hamburguesa con los ingredientes seleccionados.
     * ingredientesSeleccionados Lista de ingredientes seleccionados.
     * El precio total en colones.
     */
    public static int calcularPrecioTotal(ArrayList<String> ingredientesSeleccionados) {
        int precioTotal = 0;
        for (String ingrediente : ingredientesSeleccionados) {  //Sin validacion porque los datos introducidos en el
            precioTotal += ingredientes.get(ingrediente);       //Arraylist entrante ya tienen que haber sido validados en la                                                                 
        }                                                       //Capa de vista
        return precioTotal;
    }

}
