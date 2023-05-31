/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cocina;
import View.InterfazCocina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JOCTAN ESQUIVEL
 */
public class InterfazCocinaController implements ActionListener, KeyListener {

    private InterfazCocina cocina = new InterfazCocina();
    private Cocina logicaCocina = new Cocina();

    
    
    
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
    
    
    
    private void updateNumbers(){
        int rows = this.cocina.getTblOrdenes().getRowCount();
        for (int i = 0; i < rows; i++) {
            this.cocina.getTblOrdenes().setValueAt(i+1, i, 0);
        }
    }
    

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.cocina.getBtnAceptar())){
            if(checkNumbers(this.cocina.getTxfNumeroOrden().getText())){
           
                int num = Integer.parseInt(this.cocina.getTxfNumeroOrden().getText());
               
            
        }else{
            JOptionPane.showMessageDialog(cocina, "Solo se deben ingresar números", "Error", 0);
        }
            this.cocina.getBtnAceptar().setText("");
        }
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
