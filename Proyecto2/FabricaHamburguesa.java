// Clase FabricaHamburguesa que hereda de la clase Hamburguesa
class FabricaHamburguesa extends Hamburguesa {
    public Hamburguesa crearHamburguesa(String tipoHamburguesa) {
        Hamburguesa hamburguesa;

        // Crea la hamburguesa según el tipo
        if (tipoHamburguesa.equals("USA")) {
            hamburguesa = new HamburguesaUSA();
        } else if (tipoHamburguesa.equals("EU")) {
            hamburguesa = new HamburguesaEU();
        } else if (tipoHamburguesa.equals("AS")) {
            hamburguesa = new HamburguesaAS();
        } else {
            throw new IllegalArgumentException("Tipo de hamburguesa no válido.");
        }

        hamburguesa.setNombre(tipoHamburguesa); // Pone el nombre de la hamburguesa según el tipo
        return hamburguesa;
    }
}
