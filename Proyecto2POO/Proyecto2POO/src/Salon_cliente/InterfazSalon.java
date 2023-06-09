/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Salon_cliente;

/**
 *
 * @author brand
 */
import Model.Adapter;
import Model.FabricaHamburguesa;
import Model.Pedido;
import Model.Hamburguesa;
import Model.ServidorCocina;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfazSalon extends javax.swing.JFrame {
     private ArrayList<Pedido> pedidos = new ArrayList<>();
    Pedido pedido1 = new Pedido(1);
    Pedido pedido2 = new Pedido(2);
    Pedido pedido3 = new Pedido(3);
    Pedido pedido4 = new Pedido(4);
    Socket client;
     ObjectOutputStream output;
     FabricaHamburguesa crear=new FabricaHamburguesa();
     boolean[] mesaEstado={true,true,true,true};
     ServidorSalon servidor;
     Thread hilo;
     Adapter adaptador= new Adapter();
    /**
     * Creates new form InterfazSalon
     */
    public InterfazSalon() {
         
        initComponents();
       // while(true){
           
           
       // }
    }
    public void agregarAlPedido()
 {
     System.out.println("Si agrego en el pedido");
    if(MesaCombo.getSelectedIndex()==0 && mesaEstado[0]==true)
    {
      
          pedido1.agregarHamburguesa(crear.crearHamburguesa(HamburguesasCombo.getSelectedIndex()));
           if(ExtrasCombo.getSelectedIndex()!=0)
           {
             pedido1.getHamburguesas().get(pedido1.tamano()-1).agregarIngrediente(ExtrasCombo.getSelectedItem().toString());
           }
           pedidos.add(pedido1);
    }
    else if(MesaCombo.getSelectedIndex()==1&& mesaEstado[1]==true)
    {
      
          pedido2.agregarHamburguesa(crear.crearHamburguesa(HamburguesasCombo.getSelectedIndex()));
           if(ExtrasCombo.getSelectedIndex()!=0)
           {
             pedido2.getHamburguesas().get(pedido2.tamano()-1).agregarIngrediente(ExtrasCombo.getSelectedItem().toString());
           }
            pedidos.add(pedido2);
    }
    else if(MesaCombo.getSelectedIndex()==2 && mesaEstado[2]==true)
    {
      
          pedido3.agregarHamburguesa(crear.crearHamburguesa(HamburguesasCombo.getSelectedIndex()));
           if(ExtrasCombo.getSelectedIndex()!=0)
           {
             pedido3.getHamburguesas().get(pedido3.tamano()-1).agregarIngrediente(ExtrasCombo.getSelectedItem().toString());
           }
            pedidos.add(pedido3);
    }
    else if(MesaCombo.getSelectedIndex()==3 && mesaEstado[3]==true)
    {
      
          pedido4.agregarHamburguesa(crear.crearHamburguesa(HamburguesasCombo.getSelectedIndex()));
           if(ExtrasCombo.getSelectedIndex()!=0)
           {
             pedido4.getHamburguesas().get(pedido4.tamano()-1).agregarIngrediente(ExtrasCombo.getSelectedItem().toString());
           }
            pedidos.add(pedido4);
    }
 }
    public void imprimirPedidos()
    {
     for (int i =0 ; i < pedidos.size();i++)
     {
         System.out.println("este pedido es: "+pedidos.get(i).getNumeroPedido());
     }
    }
    public void conectar() {
        try{
           client = new Socket("127.0.0.1", 5555);
           output = new ObjectOutputStream(client.getOutputStream());

            //while (true) {
                output.writeObject(pedidos);
                output.flush();
                System.out.println("Se ha enviado con exito los pedidos");
                imprimirPedidos();
                output.close();
                client.close();
                //Thread.sleep(1000);
            //}
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    void activar()
    {
       for(int i=0;i<pedidos.size();i++)
        {
           mesaEstado[ pedidos.get(i).getNumeroPedido()-1]=true;
        }
    }
    void limpiar()
    {
        pedido1.getHamburguesas().clear();
        pedido2.getHamburguesas().clear();
        pedido3.getHamburguesas().clear();
        pedido4.getHamburguesas().clear();
        pedidos.clear();
    }
    void inhabilitaMesas()
    {
        for(int i=0;i<pedidos.size();i++)
        {
           mesaEstado[ pedidos.get(i).getNumeroPedido()-1]=false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MesaCombo = new javax.swing.JComboBox<>();
        HamburguesasCombo = new javax.swing.JComboBox<>();
        ExtrasCombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MesaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "стол 1( Mesa 1)", "стол 2(Mesa 2)", "стол 3(Mesa 3)", "стол 4(Mesa 4)" }));
        MesaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesaComboActionPerformed(evt);
            }
        });
        jPanel1.add(MesaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 120, 20));

        HamburguesasCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "классический  (Clasica)", "Американский бургер (Hamburguesa Americana)", "европейский бургер (Hamburguesa Europea)", "азиатский бургер (Hamburguesa asiatica)", " " }));
        HamburguesasCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HamburguesasComboActionPerformed(evt);
            }
        });
        jPanel1.add(HamburguesasCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, -1));

        ExtrasCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "не выбрано(no seleccionado)", "Adicional_Queso adicional", "Adicional_Aguacate o guacamole", "Adicional_Salsa barbacoa", "Adicional_Salsa ranch", "Adicional_Salsa picante", "Adicional_Chiles jalapeños", "Adicional_Cebolla caramelizada", "Adicional_Chile con carne", "Adicional_Salsa de queso", "Adicional_Hongos", "Adicional_Aros de cebolla", "Adicional_Salsa de chipotle", "Adicional_Salsa de pesto", "Adicional_Salsa tártara" }));
        ExtrasCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtrasComboActionPerformed(evt);
            }
        });
        jPanel1.add(ExtrasCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        jLabel1.setText("Elija una mesa disponible");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setText("Elija una hamburguesa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel3.setText("Elija si quiere un extra");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jLabel4.setText("Agregue la orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        jLabel5.setText("Enviar la orden a cocina");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        agregarAlPedido();
        activar();
        System.out.println("si llama a la funcion");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        adaptador.imprimirloTodo(pedidos);
         inhabilitaMesas();
       
        conectar();
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ExtrasComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtrasComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExtrasComboActionPerformed

    private void MesaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesaComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MesaComboActionPerformed

    private void HamburguesasComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HamburguesasComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HamburguesasComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazSalon().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ExtrasCombo;
    private javax.swing.JComboBox<String> HamburguesasCombo;
    private javax.swing.JComboBox<String> MesaCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
public JButton getBoton1()
{
    return jButton1;
}
public JButton getBoton2()
{
    return jButton2;
}
 public void setBtnAgregar(JButton btnAgregar) {
        this.jButton1 = btnAgregar;
    }
  public void setBtnEnviar(JButton btnEnviar) {
        this.jButton2 = btnEnviar;
    }
  public JComboBox getComboMesas()
  {
      return MesaCombo;
  }
  public JComboBox getComboHamburguesas()
  {
      return HamburguesasCombo;
  }
  public JComboBox getComboExtras()
  {
      return ExtrasCombo;
  }
}

