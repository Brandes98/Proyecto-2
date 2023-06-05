package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Cocina {
    private ServerSocket serverSocket;
    private Socket cliente;
    private ArrayList<FacturacionListener> listeners;

    public Cocina() {
        listeners = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(8080); // Puerto para recibir conexiones
            System.out.println("Cocina: Esperando conexión del Salón...");
            cliente = serverSocket.accept();
            System.out.println("Cocina: Conexión establecida con el Salón.");
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

    void procesarPedido(ArrayList<Pedido> pedidos) {
        
        
        
    }
}

interface FacturacionListener {
    void onFacturaGenerada();
}