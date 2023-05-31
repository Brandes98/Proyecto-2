package Model;

public class HamburguesaAS extends Hamburguesa {

    
    public HamburguesaAS() {
        this.nombre = "Hamurguesa europea";
        this.ingredientes.remove("Carne de res molida");
        this.agregarIngrediente("Carne de pollo molida");
        this.agregarIngrediente("Sal y pimienta");
        this.agregarIngrediente("Mostaza");
    }
    
}
