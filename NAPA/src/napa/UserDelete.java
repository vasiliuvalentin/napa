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
public class UserDelete extends javax.swing.JFrame {

    /**
     * Creates new form UserDelete
     */
    public UserDelete() {
        initComponents();
        Statement stmt;
        logo.setIcon(new ImageIcon("images/logo.png"));
        bg.setIcon(new ImageIcon("images/bg.jpg"));
        boolean ok = false;
        try {
            Connection con = Methods.DBConector();
            stmt = (Statement) con.createStatement();
            String query = "Select * from users";

            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                comboName.addItem(rs.getString("firstName") + " " + rs.getString("lastName"));
                ok = true;

            }
            if (!rs.next() && ok == false) {
                comboName.addItem("No users!");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboName = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" User Delete");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delete User");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 90, 140, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 130, 45, 30);

        jPanel1.add(comboName);
        comboName.setBounds(180, 130, 140, 22);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton);
        okButton.setBounds(270, 200, 49, 25);

        logo.setIcon(new javax.swing.ImageIcon("D:\\Facultate\\NAPA\\images\\logo.png")); // NOI18N
        jPanel1.add(logo);
        logo.setBounds(0, 0, 90, 90);

        bg.setIcon(new javax.swing.ImageIcon("D:\\Facultate\\NAPA\\images\\bg.jpg")); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, 0, 380, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        Statement stmt;
        int idu = 0;
        try {
            Connection con = Methods.DBConector();
            stmt = (Statement) con.createStatement();
            String query = "DELETE FROM users WHERE firstName=? and lastName=?";
            String query2 = "Select idu from users where firstName=? and lastName=?";

            String nameSelected = comboName.getSelectedItem().toString();
            String name[];
            name = nameSelected.split(" ");

            PreparedStatement st = con.prepareStatement(query);
            PreparedStatement st2 = con.prepareStatement(query2);
            st2.setString(1, name[0]);
            st2.setString(2, name[1]);
            ResultSet rs = st2.executeQuery();
            while (rs.next()) {
                idu = Integer.parseInt(rs.getString(1));
            }
            String query3 = "DELETE FROM team where idu=?";
            PreparedStatement st3 = con.prepareStatement(query3);
            st3.setInt(1, idu);
            st.setString(1, name[0]);
            st.setString(2, name[1]);
            st.executeUpdate();
            st3.executeUpdate();
            UserDelete user = new UserDelete();
            this.dispose();
            user.setVisible(true);

            JOptionPane.showMessageDialog(null, "USER DELETED!", "Succes", 1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
        }

    }//GEN-LAST:event_okButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
