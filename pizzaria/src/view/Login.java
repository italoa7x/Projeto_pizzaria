/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.FuncionarioControl;
import dto.FuncionarioDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private FuncionarioControl funcionarioControl;

    public Login() {
        initComponents();
        funcionarioControl = new FuncionarioControl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campo_login = new javax.swing.JTextField();
        campo_senha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btEntrar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        lb_background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 100, 50, 17);
        getContentPane().add(campo_login);
        campo_login.setBounds(220, 70, 190, 30);
        getContentPane().add(campo_senha);
        campo_senha.setBounds(220, 120, 190, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 50, 50, 17);

        btEntrar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/iconfinder_Login_in_85205.png"))); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btEntrar);
        btEntrar.setBounds(210, 160, 93, 30);

        btSair.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/iconfinder_Login_out_85206.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        getContentPane().add(btSair);
        btSair.setBounds(330, 160, 90, 30);

        lb_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/background.jpg"))); // NOI18N
        getContentPane().add(lb_background);
        lb_background.setBounds(0, 0, 470, 220);

        setSize(new java.awt.Dimension(438, 199));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        String login = campo_login.getText();
        String senha = campo_senha.getText();

        if (login.equalsIgnoreCase("root") && senha.equalsIgnoreCase("root")) {
            new Inicial("Admin").setVisible(true);
            dispose();
        } else {
            try {
                FuncionarioDTO fAchado = funcionarioControl.logarSistema(login, senha);
                if (fAchado != null) {
                    new Inicial(fAchado.getCargo()).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Funccionario não cadastrado.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao logar." + e.getMessage());
            }

        }
    }//GEN-LAST:event_btEntrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Login().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField campo_login;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb_background;
    // End of variables declaration//GEN-END:variables
}
