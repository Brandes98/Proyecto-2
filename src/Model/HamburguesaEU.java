
package Model;

public class HamburguesaEU extends Hamburguesa {

    
    public HamburguesaEU() {
        this.nombre = "Hamurguesa europea";
        this.quitarIngrediente("Carne de res molida");
        this.agregarIngrediente("Carne de pavo molida");
        this.agregarIngrediente("Sal y pimienta");
        this.agregarIngrediente("Mayonesa");
    }
    
}
