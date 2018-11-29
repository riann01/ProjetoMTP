package autenticar;
import java.awt.Color;
import javax.swing.JOptionPane;
public class GerenciarCategorias extends javax.swing.JFrame {

    public GerenciarCategorias(int idPessoa) {
        idDoUsuario = idPessoa;
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        inserirModelo();
        mudarFonte();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void mudarFonte() {
        Controle ctr = new Controle();
        labelGerenciarCategorias.setFont(ctr.mudaFonte(24));
        labelInserirCategoria.setFont(ctr.mudaFonte(15));
        labelAtualizarCategoria.setFont(ctr.mudaFonte(15));
        labelExcluirCategoria.setFont(ctr.mudaFonte(15));
        listCategorias.setFont(ctr.mudaFonte(14));
        labelInserirCategoria.setFont(ctr.mudaFonte(12));
        labelExcluirCategoria.setFont(ctr.mudaFonte(12));
        labelAtualizarCategoria.setFont(ctr.mudaFonte(12));
    }
    
    public void inserirModelo () {
        listCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = new Controle().pegaModeloCatGerenciador();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInserirCategoria = new javax.swing.JLabel();
        labelAtualizarCategoria = new javax.swing.JLabel();
        labelExcluirCategoria = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelGerenciarCategorias = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelAtualizar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(308, 486));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelInserirCategoria.setText("Inserir Categoria");
        labelInserirCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelInserirCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelInserirCategoriaMouseClicked(evt);
            }
        });
        getContentPane().add(labelInserirCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        labelAtualizarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtualizarCategoria.setText("Atualizar Categoria");
        labelAtualizarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(labelAtualizarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 120, -1));

        labelExcluirCategoria.setText("Excluir Categoria");
        labelExcluirCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelExcluirCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExcluirCategoriaMouseClicked(evt);
            }
        });
        getContentPane().add(labelExcluirCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 440, 10));

        labelGerenciarCategorias.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelGerenciarCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGerenciarCategorias.setText("GERENCIAR CATEGORIAS");
        getContentPane().add(labelGerenciarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 53));

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 87, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/excluir.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        labelAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/atualizar.png"))); // NOI18N
        labelAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(labelAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/adicionar_cat.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        listCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listCategoriasMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(listCategorias);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new PainelAdmin(idDoUsuario);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void labelExcluirCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExcluirCategoriaMouseClicked
        if (listCategorias.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma categoria para excluí-la", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            controle.excluirCategoria(listCategorias.getSelectedValue());
            inserirModelo();
        }
    }//GEN-LAST:event_labelExcluirCategoriaMouseClicked

    private void labelInserirCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelInserirCategoriaMouseClicked

    }//GEN-LAST:event_labelInserirCategoriaMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (listCategorias.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma categoria para excluí-la", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            controle.excluirCategoria(listCategorias.getSelectedValue());
            inserirModelo();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void listCategoriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCategoriasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_listCategoriasMouseExited

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    Controle controle = new Controle();
    private int selectedIndex;
    private int idDoUsuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAtualizar;
    private javax.swing.JLabel labelAtualizarCategoria;
    private javax.swing.JLabel labelExcluirCategoria;
    private javax.swing.JLabel labelGerenciarCategorias;
    private javax.swing.JLabel labelInserirCategoria;
    private javax.swing.JList<String> listCategorias;
    // End of variables declaration//GEN-END:variables
}
