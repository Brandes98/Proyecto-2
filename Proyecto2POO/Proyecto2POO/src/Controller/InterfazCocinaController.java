/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cocina;
import Model.Hamburguesa;
import Model.Pedido;
import View.InterfazCocina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class InterfazCocinaController implements ActionListener, KeyListener {

    private InterfazCocina cocina = new InterfazCocina();
    
    //private Cocina logicaCocina = new Cocina();
    
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    public InterfazCocinaController(){
        _init_();
        showScreen();
    }

    
    public void showScreen(){
        cocina.setVisible(true);
    }
    
    private void _init_(){
        //obtenemos los elementos de la interfaz
        cocina.getBtnAceptar().addActionListener(this);
        
    }
    
    public boolean checkNumbers(String cadena){
        int largo = cadena.length();
        if (largo==0)
            return false;
        
        for (int i=0 ; i<largo;i++){
            if (!Character.isDigit(cadena.charAt(i))){
                return false;
            }
        }
        return true;
    }
    private void refreshTable(Pedido pedido){
        DefaultTableModel model = (DefaultTableModel) this.cocina.getTblOrdenes().getModel();
        Object[] obj = new Object[4];

        ArrayList<Hamburguesa> hamburguesas = pedido.getHamburguesas();
        for (Hamburguesa hamburguesa : hamburguesas) {
            obj[0] =pedido.getNumeroPedido();obj[1] = hamburguesa.getNombre(); obj[2] = hamburguesa.getPrecioFinal();obj[3] = "No";
            model.addRow(obj);
        }
        
            
        
    }
    
    public boolean pintarPedido(ArrayList<Pedido> pedidos){
        for (Pedido pedido : pedidos) {
            this.pedidos.add(pedido);
            refreshTable(pedido);
        }
        
        return false;
    }
    
    
    
    private void updateNumbers(){
        int rows = this.cocina.getTblOrdenes().getRowCount();
        for (int i = 0; i < rows; i++) {
            this.cocina.getTblOrdenes().setValueAt(i+1, i, 0);
        }
    }
    
    private void eliminarPedido(int num){
        for (int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).getNumeroPedido()==num){
                this.pedidos.remove(i);
                break;
            }
        }
    }

    private void eliminarFilas(int num){
        DefaultTableModel model = (DefaultTableModel) cocina.getTblOrdenes().getModel();
        int pedidoNum;
        Object valor; 
        int limite = model.getRowCount();
        int contador = 0;
        while (contador<limite){
            valor = model.getValueAt(contador, 0); 
            pedidoNum = Integer.parseInt(valor+"");
            if(pedidoNum==num){
               model.removeRow(contador);
               contador = 0;
               limite = model.getRowCount();
            }else{
                contador+=1;
            }

           // updateNumbers();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkNumbers(cocina.getTxfNumeroOrden().getText())){
            int num = Integer.parseInt(cocina.getTxfNumeroOrden().getText());
            if (num >= 1 && num <= cocina.getTblOrdenes().getRowCount()){
                //ArrayList<Integer> toDelete = new ArrayList<>();
                eliminarPedido(num);
                eliminarFilas(num);
            }else{
                JOptionPane.showMessageDialog(cocina, "El numero de orden no existe", "Error", 0);
            }
        }else{
            JOptionPane.showMessageDialog(cocina, "Solo se deben ingresar números", "Error", 0);
        }
        this.cocina.getTxfNumeroOrden().setText("");
        
    }                               
    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
