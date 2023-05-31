
package Model;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Cocina {
    private Hamburguesa[] ordenes;
    private ServerSocket serverSocket;
    private Socket cliente;
    private List<FacturacionListener> listeners;

    public Cocina() {
        ordenes = new Hamburguesa[10]; // Tamaño máximo de las órdenes
        listeners = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(8080); // Puerto para recibir conexiones
            System.out.println("Cocina: Esperando conexión del Salon...");
            cliente = serverSocket.accept();
            System.out.println("Cocina: Conexión establecida con el Salon.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarFacturacionListener(FacturacionListener listener) {
        listeners.add(listener);
    }

    public void removerFacturacionListener(FacturacionListener listener) {
        listeners.remove(listener);
    }

    public int[] marcarOrdenComoLista(Hamburguesa[] ordenes) {
        int[] indicesLista = new int[ordenes.length];
        for (int i = 0; i < ordenes.length; i++) {
            if (ordenes[i] != null) {
                ordenes[i].setLista(true);
                indicesLista[i] = i;
            }
        }
        return indicesLista;
    }

    public String mostrarOrdenesPendientes() {
        StringBuilder pendientes = new StringBuilder();
        for (Hamburguesa orden : ordenes) {
            if (orden != null && !orden.isLista()) {
                pendientes.append(orden.toString()).append("\n");
            }
        }
        return pendientes.toString();
    }

    private void facturar() {
        // Generar y enviar la factura al cliente
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
            outputStream.writeObject("Factura generada.");
            outputStream.flush();

            // Notificar a los clientes sobre la factura generada
            for (FacturacionListener listener : listeners) {
                listener.onFacturaGenerada();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

interface FacturacionListener {
    void onFacturaGenerada();
}
