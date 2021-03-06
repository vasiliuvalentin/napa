/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Vali
 */
public class ShipAdd extends javax.swing.JFrame {
    Methods methods = new Methods();
    /**
     * Creates new form ShipAdd
     */
    public ShipAdd() {
        initComponents();
        logo.setIcon(new ImageIcon("images/logo.png"));
        bg.setIcon(new ImageIcon("images/bg.jpg"));
        Statement stmt;
        boolean ok = false;
        try {
            Connection con = Methods.DBConector();
            stmt = (Statement) con.createStatement();
            String query = "Select * from captains where idc not in ( select idc from ships);";

            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                captainCombo.addItem(rs.getString("firstName") + " " + rs.getString("lastName"));
                ok = true;

            }
            if (!rs.next() && ok == false) {
                JOptionPane.showMessageDialog(null, "No captain available. Please add a new captain for add a new ship!");
                captainCombo.addItem("No captain availabel!");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
        }
        if (ok == true) {

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
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        descText = new javax.swing.JTextField();
        objCombo = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        captainCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD SHIP");
        setResizable(false);

        jPanel1.setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon("D:\\Facultate\\NAPA\\images\\logo.png")); // NOI18N
        jPanel1.add(logo);
        logo.setBounds(0, 0, 86, 86);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD NEW SHIP");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 90, 150, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 160, 45, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 200, 82, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Objective:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 280, 80, 17);
        jPanel1.add(nameText);
        nameText.setBounds(140, 160, 130, 22);
        jPanel1.add(descText);
        descText.setBounds(140, 200, 130, 60);

        objCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "River", "Sea", "Lake", "Station" }));
        jPanel1.add(objCombo);
        objCombo.setBounds(140, 280, 130, 22);

        okButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okButton.setText("ADD");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton);
        okButton.setBounds(210, 370, 73, 31);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Captain:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 330, 60, 17);

        jPanel1.add(captainCombo);
        captainCombo.setBounds(140, 320, 130, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ship ID:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 120, 56, 17);

        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });
        idText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idTextKeyTyped(evt);
            }
        });
        jPanel1.add(idText);
        idText.setBounds(140, 120, 130, 22);

        bg.setIcon(new javax.swing.ImageIcon("D:\\Facultate\\NAPA\\images\\bg.jpg")); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 300, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        boolean ok2;
        int idc = 0;
        if (captainCombo.getSelectedItem().toString().equals("No captain availabel!")) {
            JOptionPane.showMessageDialog(null, "No captain available. Please add a new captain for add a new ship!!", "Error", 1);
            ok2 = false;
        } else {
            ok2 = true;
        }
        if (ok2 == true) {
            Statement stmt = null;
            boolean ok;

            try {
                Connection con = Methods.DBConector();
                stmt = (Statement) con.createStatement();
                if (nameText.getText().length() == 0 || descText.getText().length() == 0 || idText.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "All fields are required!", "Error", 1);
                    ok = false;
                } else {
                    ok = true;
                }

                if (ok == true) {
                    String selectedName = captainCombo.getSelectedItem().toString();
                    String name[] = selectedName.split(" ");
                    String query = "Select idc from captains where firstName=? and lastName=?";

                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, name[0]);
                    st.setString(2, name[1]);
                    ResultSet rs = st.executeQuery();

                    while (rs.next()) {
                        idc = Integer.parseInt(rs.getString(1));

                    }
                    PreparedStatement ps = con.prepareStatement("insert into  ships(ids,idc,name,description,objective) values (?,?,?,?,?)");
                    ps.setInt(1, Integer.parseInt(idText.getText()));
                    ps.setInt(2,idc);
                    ps.setString(3, nameText.getText());
                    ps.setString(4, descText.getText());
                    ps.setString(5, objCombo.getSelectedItem().toString());

                    int i = ps.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "The ship was entered into the database!", "Succes", 1);
                        ShipAdd ship = new ShipAdd();
                        this.dispose();
                        ship.setVisible(true);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void idTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextActionPerformed
        // TODO add your handling code here:4
        
    }//GEN-LAST:event_idTextActionPerformed

    private void idTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextKeyTyped
        // TODO add your handling code here:
        methods.check(evt);
        if (idText.getText().length() > 4) {
            evt.consume();
        }
    }//GEN-LAST:event_idTextKeyTyped

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
            java.util.logging.Logger.getLogger(ShipAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShipAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShipAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShipAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShipAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> captainCombo;
    private javax.swing.JTextField descText;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nameText;
    private javax.swing.JComboBox<String> objCombo;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
