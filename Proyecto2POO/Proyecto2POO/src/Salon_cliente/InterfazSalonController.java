/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Salon_cliente;
import Model.Cocina;
import Model.Hamburguesa;
import Model.Pedido;
import Model.InterfazCocina;
import Salon_cliente.InterfazSalon;
import Model.FabricaHamburguesa;
import Model.Hamburguesa;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brand
 */
public class InterfazSalonController implements ActionListener,KeyListener {
    private SalonLogic mesaSalon =new SalonLogic(4,50);
    private InterfazSalon elSalon = new InterfazSalon();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    Pedido pedido1 = new Pedido(1);
    Pedido pedido2= new Pedido(2);
    Pedido pedido3= new Pedido(3);
    Pedido pedido4= new Pedido(4);
    JComboBox mesa= elSalon.getComboMesas();
    JComboBox hamburguesas = elSalon.getComboHamburguesas();
    JComboBox extras= elSalon.getComboExtras();
    FabricaHamburguesa crear=new FabricaHamburguesa();
    public InterfazSalonController()
    {
        showScreen();
        _init_();
    }
 public void showScreen()
 {
 elSalon.setVisible(true);
 }
 public void _init_()
 {
     elSalon.getBoton1().addActionListener(this);
     elSalon.getBoton2().addActionListener(this);
 }
 public void agregarAlPedido()
 {
     System.out.println("Si agrego en el pedido");
    if(mesa.getSelectedIndex()==0)
    {
      
          pedido1.agregarHamburguesa(crear.crearHamburguesa(hamburguesas.getSelectedIndex()));
           if(extras.getSelectedIndex()!=0)
           {
             pedido1.getHamburguesas().get(-1).agregarIngrediente(extras.getSelectedItem().toString());
           }
    }
    else if(mesa.getSelectedIndex()==1)
    {
      
          pedido2.agregarHamburguesa(crear.crearHamburguesa(hamburguesas.getSelectedIndex()));
           if(extras.getSelectedIndex()!=0)
           {
             pedido2.getHamburguesas().get(-1).agregarIngrediente(extras.getSelectedItem().toString());
           }
    }
    else if(mesa.getSelectedIndex()==2)
    {
      
          pedido3.agregarHamburguesa(crear.crearHamburguesa(hamburguesas.getSelectedIndex()));
           if(extras.getSelectedIndex()!=0)
           {
             pedido3.getHamburguesas().get(-1).agregarIngrediente(extras.getSelectedItem().toString());
           }
    }
    else if(mesa.getSelectedIndex()==3)
    {
      
          pedido4.agregarHamburguesa(crear.crearHamburguesa(hamburguesas.getSelectedIndex()));
           if(extras.getSelectedIndex()!=0)
           {
             pedido4.getHamburguesas().get(-1).agregarIngrediente(extras.getSelectedItem().toString());
           }
    }
 }
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         agregarAlPedido();
     System.out.println("Si agrego");
    }                                        

 @Override
 public void actionPerformed(ActionEvent e)
 {
      System.out.println("Si agrego");
     jButton1ActionPerformed(e);
    
     
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
