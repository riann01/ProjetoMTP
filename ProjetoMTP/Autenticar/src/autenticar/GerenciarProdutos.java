package autenticar;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GerenciarProdutos extends javax.swing.JFrame {

    public GerenciarProdutos(int idPessoa) {
        idDaPessoa = idPessoa;
        this.getContentPane().setBackground(Color.WHITE);
        initComponents();
        mudarFonte();
        inserirModelo();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void mudarFonte () {
        Controle ctr = new Controle();
        labelGerenciarProdutos.setFont(ctr.mudaFonte(24));
        listProdutos.setFont(ctr.mudaFonte(14));
        labelAdicionarProduto.setFont(ctr.mudaFonte(12));
        labelExcluirProduto.setFont(ctr.mudaFonte(12));
        labelAtualizarProduto.setFont(ctr.mudaFonte(12));
        btnFechar.setFont(ctr.mudaFonte(12));
    }
    
    public void inserirModelo () {
        listProdutos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = new Controle().pegaModeloProduto();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAdicionarProduto = new javax.swing.JLabel();
        labelAtualizarProduto = new javax.swing.JLabel();
        labelExcluirProduto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelGerenciarProdutos = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelAtualizar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProdutos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAdicionarProduto.setText("Adicionar Produto");
        labelAdicionarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAdicionarProdutoMouseClicked(evt);
            }
        });
        getContentPane().add(labelAdicionarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        labelAtualizarProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtualizarProduto.setText("Atualizar Produto");
        labelAtualizarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAtualizarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAtualizarProdutoMouseClicked(evt);
            }
        });
        getContentPane().add(labelAtualizarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, -1));

        labelExcluirProduto.setText("Excluir Produto");
        labelExcluirProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelExcluirProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExcluirProdutoMouseClicked(evt);
            }
        });
        getContentPane().add(labelExcluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 440, 10));

        labelGerenciarProdutos.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelGerenciarProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGerenciarProdutos.setText("GERENCIAR PRODUTOS");
        getContentPane().add(labelGerenciarProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 53));

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 87, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/excluir.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        labelAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/atualizar.png"))); // NOI18N
        labelAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAtualizarMouseClicked(evt);
            }
        });
        getContentPane().add(labelAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/adicionar_cat.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listProdutos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listProdutosMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(listProdutos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 240, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAdicionarProdutoMouseClicked

    }//GEN-LAST:event_labelAdicionarProdutoMouseClicked

    private void labelAtualizarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtualizarProdutoMouseClicked

    }//GEN-LAST:event_labelAtualizarProdutoMouseClicked

    private void labelExcluirProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExcluirProdutoMouseClicked

    }//GEN-LAST:event_labelExcluirProdutoMouseClicked

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        new PainelAdmin(idDaPessoa);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (listProdutos.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto da lista para excluí-lo.", "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
        }
        else {
            
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void labelAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtualizarMouseClicked
        if (listProdutos.getSelectedValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto da lista para atualizá-lo.", "Erro ao atualizar", JOptionPane.ERROR_MESSAGE);
        }
        else {
            
        }
    }//GEN-LAST:event_labelAtualizarMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        new CadastrarProdutos(idDaPessoa);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void listProdutosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProdutosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_listProdutosMouseExited

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
            java.util.logging.Logger.getLogger(GerenciarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    private int idDaPessoa;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAdicionarProduto;
    private javax.swing.JLabel labelAtualizar;
    private javax.swing.JLabel labelAtualizarProduto;
    private javax.swing.JLabel labelExcluirProduto;
    private javax.swing.JLabel labelGerenciarProdutos;
    private javax.swing.JList<String> listProdutos;
    // End of variables declaration//GEN-END:variables
}
