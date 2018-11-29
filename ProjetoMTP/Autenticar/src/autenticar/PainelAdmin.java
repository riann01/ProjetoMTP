package autenticar;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;

public class PainelAdmin extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public PainelAdmin(int idUsuario) {
        setLocationRelativeTo(null);
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        mudarFonte();
        idDoUsuario = idUsuario;
        this.setVisible(true);
    }

    public void mudarFonte () {
        Controle ctr = new Controle();
        labelAdmPainel.setFont(ctr.mudaFonte(18));
        labelCadastrar.setFont(ctr.mudaFonte(16));
        labelGerenciarCatergorias.setFont(ctr.mudaFonte(16));
        botaoFechar.setFont(ctr.mudaFonte(14));
    }
    public boolean pegaBoolean (int idUsuario) {
        boolean T = false;
        try {
            PreparedStatement ps = this.conn.getConnection().prepareStatement("SELECT administrador FROM pessoa WHERE id_pessoa = ?");
            ps.setInt(1 , idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                T = rs.getBoolean(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return T;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelGerenciarCatergorias = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelAdmPainel = new javax.swing.JLabel();
        botaoFechar = new javax.swing.JButton();
        labelCadastrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        labelGerenciarCatergorias.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        labelGerenciarCatergorias.setText("Gerenciar Categorias");
        labelGerenciarCatergorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelGerenciarCatergorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGerenciarCatergoriasMouseClicked(evt);
            }
        });

        labelAdmPainel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelAdmPainel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdmPainel.setText("Painel do Administrador");

        botaoFechar.setText("Fechar");
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        labelCadastrar.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        labelCadastrar.setText("Cadastrar Produtos");
        labelCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(labelAdmPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelGerenciarCatergorias, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(138, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelAdmPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(labelGerenciarCatergorias, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(botaoFechar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(269, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        this.dispose();
        new TelaInicial(idDoUsuario,pegaBoolean(idDoUsuario));
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void labelGerenciarCatergoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGerenciarCatergoriasMouseClicked
        new GerenciarCategorias(idDoUsuario);
        this.dispose();
    }//GEN-LAST:event_labelGerenciarCatergoriasMouseClicked

    private void labelCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMouseClicked
        this.dispose();
        new CadastrarProdutos(idDoUsuario);
    }//GEN-LAST:event_labelCadastrarMouseClicked

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
            java.util.logging.Logger.getLogger(PainelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    private Conexao conn = new Conexao();
    private int idDoUsuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAdmPainel;
    private javax.swing.JLabel labelCadastrar;
    private javax.swing.JLabel labelGerenciarCatergorias;
    // End of variables declaration//GEN-END:variables
}
