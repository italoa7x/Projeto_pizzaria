/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.PedidoControl;
import control.PizzaioloControl;
import dto.PedidoDTO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.iterator.IteratorPe;
import view.iterator.IteratorPedidoDTO;

/**
 *
 * @author Italo
 */
public class Tela_pizzaiolo extends javax.swing.JFrame {

    /**
     * Creates new form Tela_pizzaiolo
     */
    private PedidoControl pedidoControl;
    private PizzaioloControl pizzaioloControl;
    private IteratorPe iteratorP;

    public Tela_pizzaiolo(String cargo) {
        initComponents();
        pedidoControl = new PedidoControl();
        pizzaioloControl = new PizzaioloControl();
        preencherTabela();

        if (cargo.equalsIgnoreCase("atendente")) {
            btFazerPizza.setEnabled(false);
        }

    }

    private void preencherTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        try {
            PedidoDTO pedidosDTO = pedidoControl.listarPedidos();
            iteratorP = new IteratorPedidoDTO(pedidosDTO.getPedidosCadastrados());

            while (iteratorP.hasNext()) {
                PedidoDTO obj = iteratorP.next();
                String[] dados = new String[5];
                dados[0] = obj.getPizza().getNome();
                dados[1] = obj.getPizza().getTamanho();
                dados[2] = obj.getPizza().getValor() + "";
                dados[3] = obj.getId() + "";
                dados[4] = obj.getStatus();
                model.addRow(dados);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        try {
            PedidoDTO pedidosDTO = pedidoControl.listarPedidos();
            iteratorP = new IteratorPedidoDTO(pedidosDTO.getPedidosCadastrados());

            while (iteratorP.hasNext()) {
                PedidoDTO obj = iteratorP.next();
                String[] dados = new String[5];
                dados[0] = obj.getPizza().getNome();
                dados[1] = obj.getPizza().getTamanho();
                dados[2] = obj.getPizza().getValor() + "";
                dados[3] = obj.getId() + "";
                dados[4] = obj.getStatus();
                model.addRow(dados);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btFazerPizza = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pizza", "Tamanho", "Valor", "ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        btFazerPizza.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btFazerPizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/iconfinder_f-check_256_282474.png"))); // NOI18N
        btFazerPizza.setText("Fazer pizza");
        btFazerPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFazerPizzaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(btFazerPizza)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btFazerPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(562, 418));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFazerPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFazerPizzaActionPerformed
        // TODO add your handling code here:
        if (tabela.getSelectedRow() != -1) {
            int id = Integer.parseInt((String) tabela.getValueAt(tabela.getSelectedRow(), 3));
            String status_pedido = (String) tabela.getValueAt(tabela.getSelectedRow(), 4);
            try {
                int resposta = JOptionPane.showConfirmDialog(null, "Finalizar pizza?");
                if (resposta == JOptionPane.YES_OPTION && status_pedido.equalsIgnoreCase("pedido aberto")) {
                    if (pizzaioloControl.prepararPizza(id)) {
                        JOptionPane.showMessageDialog(null, "Pizza feita.");
                        atualizarTabela();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btFazerPizzaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFazerPizza;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
