
package Model;

import java.net.Socket;

public class SalonLogic {
    private int[] mesas;
    private Hamburguesa[] pedidos;
    private Socket cliente;
    private Hamburguesa[] hamburguesas;

    public Salon(int numMesas, int numHamburguesas) {
        if (numMesas <= 0 || numHamburguesas <= 0) {
            throw new IllegalArgumentException("El número de mesas y hamburguesas debe ser mayor que cero.");
        }

        mesas = new int[numMesas];
        pedidos = new Hamburguesa[numMesas];
        hamburguesas = new Hamburguesa[numHamburguesas];
    }

    public void ingresarOrden(int numeroMesa, Hamburguesa pedido) {
        if (numeroMesa < 0 || numeroMesa >= mesas.length) {
            throw new IllegalArgumentException("Número de mesa inválido.");
        }

        if (mesas[numeroMesa] == 1) {
            throw new IllegalStateException("La mesa " + numeroMesa + " ya está ocupada.");
        }

        mesas[numeroMesa] = 1; // Marca la mesa como ocupada
        pedidos[numeroMesa] = pedido;
    }

    public void notificarPedidoListo(int numeroMesa) {
        if (numeroMesa < 0 || numeroMesa >= mesas.length) {
            throw new IllegalArgumentException("Número de mesa inválido.");
        }

        if (mesas[numeroMesa] == 0) {
            throw new IllegalStateException("La mesa " + numeroMesa + " no está ocupada.");
        }

        Hamburguesa pedido = pedidos[numeroMesa];
        if (pedido == null) {
            throw new IllegalStateException("No se encontró ningún pedido para la mesa " + numeroMesa);
        }

        System.out.println("El pedido de la mesa " + numeroMesa + " está listo.");
    }

    public void generarCuenta(int numeroMesa) {
        if (numeroMesa < 0 || numeroMesa >= mesas.length) {
            throw new IllegalArgumentException("Número de mesa inválido.");
        }

        if (mesas[numeroMesa] == 0) {
            throw new IllegalStateException("La mesa " + numeroMesa + " no está ocupada.");
        }

        System.out.println("La cuenta para la mesa " + numeroMesa + " es: $XX.XX");
    }
}
