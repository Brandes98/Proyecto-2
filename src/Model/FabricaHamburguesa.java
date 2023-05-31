
package Model;
    // Clase FabricaHamburguesa que hereda de la clase Hamburguesa
public class FabricaHamburguesa{

	// 1 ==> "Americana"
	// 2 ==> "Europea"
        //

    public static Hamburguesa crearHamburguesa(int tipoHamburguesa) {
	 switch (tipoHamburguesa){
		case 0: return new Hamburguesa();
		case 1: return new HamburguesaUSA();
		case 2: return new HamburguesaEU();
		case 3: return new HamburguesaAS();
		default:  throw new IllegalArgumentException("Tipo de hamburguesa no válido.");
	 }
        
    }
}

