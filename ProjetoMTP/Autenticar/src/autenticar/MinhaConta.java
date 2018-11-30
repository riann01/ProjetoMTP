package autenticar;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
public class MinhaConta extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public MinhaConta(int idUsuario) {
        initComponents();
        mudarFonte();
        idDoUsuario = idUsuario;
        this.setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        String separador [] = (new Controle().mostraNome(idUsuario)).split(" ");
        if (new Controle().pegaSexo(idUsuario).equals("M")) {
            labelTitulo.setText("Configurações da Conta do "+separador[0]);
        }
        else {
            labelTitulo.setText("Configurações da Conta da "+separador[0]);
        }
        
    }
    
    public void mudarFonte() {
        Controle ctr = new Controle();
        labelTitulo.setFont(ctr.mudaFonte(20));
        labelDados.setFont(ctr.mudaFonte(14));
        labelPedidos.setFont(ctr.mudaFonte(14));
        labelSair.setFont(ctr.mudaFonte(14));
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelTitulo = new javax.swing.JLabel();
        labelDados = new javax.swing.JLabel();
        labelPedidos = new javax.swing.JLabel();
        labelSair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelTitulo.setFont(new java.awt.Font("Google Sans", 0, 20)); // NOI18N
        labelTitulo.setText("Configurações da Conta do [Usuário]");

        labelDados.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        labelDados.setText("Alterar meus dados cadastrais");
        labelDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDadosMouseClicked(evt);
            }
        });

        labelPedidos.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        labelPedidos.setText("Meus pedidos");
        labelPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPedidosMouseClicked(evt);
            }
        });

        labelSair.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        labelSair.setText("Sair");
        labelSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSair)
                    .addComponent(labelPedidos)
                    .addComponent(labelDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDados)
                .addGap(18, 18, 18)
                .addComponent(labelPedidos)
                .addGap(18, 18, 18)
                .addComponent(labelSair)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDadosMouseClicked
        this.dispose();
        new AlterarDados(idDoUsuario);
    }//GEN-LAST:event_labelDadosMouseClicked

    private void labelSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSairMouseClicked
        this.dispose();
        new TelaInicial(idDoUsuario,pegaBoolean(idDoUsuario));
    }//GEN-LAST:event_labelSairMouseClicked

    private void labelPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPedidosMouseClicked
        this.dispose();
        new MeusPedidos(idDoUsuario);
    }//GEN-LAST:event_labelPedidosMouseClicked

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
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    private Conexao conn = new Conexao();
    private int idDoUsuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDados;
    private javax.swing.JLabel labelPedidos;
    private javax.swing.JLabel labelSair;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
