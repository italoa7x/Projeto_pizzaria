/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MotoboyControl;
import control.PedidoControl;
import dto.PedidoDTO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.iterator.IteratorPe;
import view.iterator.IteratorPedidoDTO;

/**
 *
 * @author Italo
 */
public class Tela_motoboy extends javax.swing.JFrame {

    /**
     * Creates new form Tela_motoboy
     */
    private PedidoControl pedidoC;
    private MotoboyControl motob;
    private IteratorPe iteratorP;

    public Tela_motoboy() {
        initComponents();
        motob = new MotoboyControl();
        pedidoC = new PedidoControl();
        preencheTabela();
    }
    
    private void preencheTabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            PedidoDTO pedidosDTO = pedidoC.listarPedidos();
            iteratorP = new IteratorPedidoDTO(pedidosDTO.getPedidosCadastrados());
            
            while (iteratorP.hasNext()) {
                String[] dados = new String[7];
                PedidoDTO obj = iteratorP.next();
                
                if (obj.getStatus().equalsIgnoreCase("preparado") || obj.getStatus().equalsIgnoreCase("a caminho")) {
                    dados[0] = obj.getCliente().getNome();
                    dados[1] = obj.getCliente().getId() + "";
                    dados[2] = obj.getPizza().getNome();
                    dados[3] = obj.getPizza().getTamanho();
                    dados[4] = obj.getPizza().getValor() + "";
                    dados[5] = obj.getStatus();
                    dados[6] = obj.getId() + "";
                    model.addRow(dados);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void atualizarTabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            PedidoDTO pedidosDTO = pedidoC.listarPedidos();
            iteratorP = new IteratorPedidoDTO(pedidosDTO.getPedidosCadastrados());
            model.setNumRows(0);
            while (iteratorP.hasNext()) {
                String[] dados = new String[7];
                PedidoDTO obj = iteratorP.next();
                
                if (obj.getStatus().equalsIgnoreCase("preparado") || obj.getStatus().equalsIgnoreCase("a caminho")) {
                    dados[0] = obj.getCliente().getNome();
                    dados[1] = obj.getCliente().getId() + "";
                    dados[2] = obj.getPizza().getNome();
                    dados[3] = obj.getPizza().getTamanho();
                    dados[4] = obj.getPizza().getValor() + "";
                    dados[5] = obj.getStatus();
                    dados[6] = obj.getId() + "";
                    model.addRow(dados);
                }
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
        btEntregue = new javax.swing.JButton();
        btAcaminho = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Cód. do cliente", "Pizza", "Tamanho", "Valor", "Status", "Cód. do pedido"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        btEntregue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEntregue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/iconfinder_f-check_256_282474.png"))); // NOI18N
        btEntregue.setText("Entregue");
        btEntregue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntregueActionPerformed(evt);
            }
        });

        btAcaminho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAcaminho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icones/iconfinder_truck_115775.png"))); // NOI18N
        btAcaminho.setText("A caminho");
        btAcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAcaminhoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Pedidos para entregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btEntregue)
                        .addGap(114, 114, 114)
                        .addComponent(btAcaminho))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(113, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAcaminho)
                    .addComponent(btEntregue))
                .addGap(17, 17, 17))
        );

        setSize(new java.awt.Dimension(656, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEntregueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntregueActionPerformed
        // TODO add your handling code here:
        try {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                int idPedido = Integer.parseInt((String) tabela.getValueAt(linha, 6));
                String statusPedido = (String) tabela.getValueAt(linha, 5);
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja entregar o pedido n° " + idPedido + " ?");
                if (resposta == JOptionPane.YES_OPTION && statusPedido.equalsIgnoreCase("a caminho")) {
                    if (motob.entregarPizza(idPedido, "Entregue")) {
                        JOptionPane.showMessageDialog(null, "Pedido entregue ao cliente.");
                        atualizarTabela();
                    }
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btEntregueActionPerformed

    private void btAcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcaminhoActionPerformed
        // TODO add your handling code here:
        try {
            int linha = tabela.getSelectedRow();
            int idPedido = Integer.parseInt((String) tabela.getValueAt(linha, 6));
            String statusPedido = (String) tabela.getValueAt(linha, 5);
            if (linha != -1) {
                // NESSA PARTE É EXIBIDA UMA MENSAGEM PERGUNTANDO SE O MOTOBOY DESEJA ATUALIZAR O STATUS DO PEDIDOS.
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja atualizar o status do pedido n° " + idPedido + " ?");
                // ÁREA QUE VERIFICA SE O CLIENTE TEM MAIS DE UM PEDIDO.

                int id_cli = Integer.parseInt((String) tabela.getValueAt(linha, 1));
                int quantPedidosCli = pedidoC.quant_pedidosCli(id_cli);
                
                if (quantPedidosCli > 0) {
                    String nomeCli = (String) tabela.getValueAt(linha, 0);
                    JOptionPane.showMessageDialog(null, "O cliente " + nomeCli + " contêm mais pedidos a serem preparados. Aguarde!");
                } else {
                    if (resposta == JOptionPane.YES_OPTION && statusPedido.equalsIgnoreCase("preparado")) {
                        if (motob.entregarPizza(idPedido, "A caminho") && statusPedido.equalsIgnoreCase("preparado")) {
                            JOptionPane.showMessageDialog(null, "Status atualizado.");
                            atualizarTabela();
                        }
                    }
                }
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btAcaminhoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcaminho;
    private javax.swing.JButton btEntregue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
