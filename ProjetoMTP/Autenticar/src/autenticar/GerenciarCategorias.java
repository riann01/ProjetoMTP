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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void mudarFonte() {
        Controle ctr = new Controle();
        labelGerenciarCategorias.setFont(ctr.mudaFonte(24));
        listCategorias.setFont(ctr.mudaFonte(14));
        labelInserirCategoria.setFont(ctr.mudaFonte(12));
        labelExcluirCategoria.setFont(ctr.mudaFonte(12));
        labelAtualizarCategoria.setFont(ctr.mudaFonte(12));
        labelInstrucao.setFont(ctr.mudaFonte(14));
        btnFechar.setFont(ctr.mudaFonte(12));
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
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelAtualizar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        labelInstrucao = new javax.swing.JLabel();

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
        getContentPane().add(labelInserirCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        labelAtualizarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtualizarCategoria.setText("Atualizar Categoria");
        labelAtualizarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAtualizarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAtualizarCategoriaMouseClicked(evt);
            }
        });
        getContentPane().add(labelAtualizarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 120, -1));

        labelExcluirCategoria.setText("Excluir Categoria");
        labelExcluirCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelExcluirCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExcluirCategoriaMouseClicked(evt);
            }
        });
        getContentPane().add(labelExcluirCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 440, 10));

        labelGerenciarCategorias.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelGerenciarCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGerenciarCategorias.setText("GERENCIAR CATEGORIAS");
        getContentPane().add(labelGerenciarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 53));

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 87, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/excluir.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        labelAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/atualizar.png"))); // NOI18N
        labelAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAtualizarMouseClicked(evt);
            }
        });
        getContentPane().add(labelAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/adicionar_cat.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listCategorias);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 240, 240));

        labelInstrucao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelInstrucao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInstrucao.setText("Selecione uma categoria para atualizar ou excluir");
        getContentPane().add(labelInstrucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 320, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
        new PainelAdmin(idDoUsuario);
    }//GEN-LAST:event_btnFecharActionPerformed

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
        JOptionPane jp = new JOptionPane();
        String entrada = jp.showInputDialog("Entre com o nome da categoria");
        try {
            if (entrada.equals("") || entrada.equals(" ")) {
                JOptionPane.showMessageDialog(null, "O nome da categoria não pode ficar vazio", "Erro ao inserir a categoria", JOptionPane.ERROR_MESSAGE);
            }
            else {
                controle.insereCatergoria(String.valueOf(entrada));
                inserirModelo();
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Criação de categoria cancelada" , "Criar Categoria" , JOptionPane.INFORMATION_MESSAGE);
        }
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JOptionPane jp = new JOptionPane();
        String entrada;
        try {
            entrada = jp.showInputDialog("Entre com o nome da categoria");
            if (entrada.equals("") || entrada.equals(" ")) {
                JOptionPane.showMessageDialog(null, "O nome da categoria não pode ficar vazio", "Erro ao inserir a categoria", JOptionPane.ERROR_MESSAGE);
            }
            else {
                controle.insereCatergoria(String.valueOf(entrada));
                inserirModelo();
            }
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Criação de categoria cancelada" , "Criar Categoria" , JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void labelAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtualizarMouseClicked
        if (listCategorias.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma categoria para atualizá-la", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane jp = new JOptionPane();
            String nomeCategoria = listCategorias.getSelectedValue();
            try {
                String nomeCategoriaNova = jp.showInputDialog("Entre com o novo nome da categoria");
                if (nomeCategoriaNova.equals("") || nomeCategoriaNova.equals(" ")) {
                    JOptionPane.showMessageDialog(null, "O novo nome da categoria não pode ficar vazio", "Erro ao atualizar a categoria", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    controle.atualizaCategoria(nomeCategoria, nomeCategoriaNova);
                    inserirModelo();
                }
            }
            catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Atualização de categoria cancelada" , "Atualizar Categoria" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_labelAtualizarMouseClicked

    private void labelAtualizarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtualizarCategoriaMouseClicked
        if (listCategorias.getSelectedValue()==null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma categoria para atualizá-la", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane jp = new JOptionPane();
            String nomeCategoria = listCategorias.getSelectedValue();
            try {
                String nomeCategoriaNova = jp.showInputDialog("Entre com o novo nome da categoria");
                if (nomeCategoriaNova.equals("") || nomeCategoriaNova.equals(" ")) {
                    JOptionPane.showMessageDialog(null, "O novo nome da categoria não pode ficar vazio", "Erro ao atualizar a categoria", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    controle.atualizaCategoria(nomeCategoria, nomeCategoriaNova);
                    inserirModelo();
                }
            }
            catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Atualização de categoria cancelada" , "Atualizar Categoria" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_labelAtualizarCategoriaMouseClicked

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
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAtualizar;
    private javax.swing.JLabel labelAtualizarCategoria;
    private javax.swing.JLabel labelExcluirCategoria;
    private javax.swing.JLabel labelGerenciarCategorias;
    private javax.swing.JLabel labelInserirCategoria;
    private javax.swing.JLabel labelInstrucao;
    private javax.swing.JList<String> listCategorias;
    // End of variables declaration//GEN-END:variables
}
