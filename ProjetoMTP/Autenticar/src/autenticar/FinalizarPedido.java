package autenticar;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;

public class FinalizarPedido extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public FinalizarPedido(int idUsuario) {
        initComponents();
        mudaFonte();
        idUsuario2 = idUsuario;
        getContentPane().setBackground(Color.WHITE);
        PreparedStatement st;
        Controle controle = new Controle();
        String nome = controle.mostraNome(idUsuario);
        String[] teste = nome.split(" ");
        nome1 = teste[0];
        iniciarTela();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
       
    public void iniciarTela () {
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT id_pedido FROM pedido WHERE id_pessoa = ?");
            st.setInt(1, idUsuario2);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                numeroPedido = rs.getInt(1);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String texto = "<html><body><center>"+nome1+", seu pedido foi finalizado com sucesso.\n";
        texto = texto+"A encomenda chegará no endereço especificado, dentro do prazo especificado pela transportadora.</center></body></html>";
        labelTexto.setText(texto);
        labelPedido.setText("Pedido "+new Controle().tratarNumeroPedido(numeroPedido));
    }
    
    public void mudaFonte () {
        Controle ctr = new Controle();
        labelTitulo.setFont(ctr.mudaFonte(30));
        labelTexto.setFont(ctr.mudaFonte(14));
        labelRetornar.setFont(ctr.mudaFonte(15));
        labelComprovante.setFont(ctr.mudaFonte(15));
        labelPedido.setFont(ctr.mudaFonte(27));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelComprovante = new javax.swing.JLabel();
        labelRetornar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        labelPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 30)); // NOI18N
        labelTitulo.setText("COMPRA FINALIZADA");

        labelComprovante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelComprovante.setText("Vizualizar Comprovante");
        labelComprovante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelComprovante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelComprovanteMouseClicked(evt);
            }
        });

        labelRetornar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRetornar.setText("Retornar à Tela Inicial");
        labelRetornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRetornar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRetornarMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/icone_confirma.png"))); // NOI18N

        labelTexto.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTexto.setText("<html><body><center>[USUÁRIO], seu pedido foi finalizado com sucesso. A encomenda chegará no endereço especificado, dentro do prazo especificado pela transportadora.</center></body></html>");

        labelPedido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPedido.setText("PEDIDO #99999");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(labelRetornar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelComprovante)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(labelPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(labelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComprovante)
                    .addComponent(labelRetornar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelRetornarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRetornarMouseClicked
        this.dispose();
    }//GEN-LAST:event_labelRetornarMouseClicked

    private void labelComprovanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelComprovanteMouseClicked
        new Comprovante(idUsuario2, numeroPedido, 1);
        this.dispose();
    }//GEN-LAST:event_labelComprovanteMouseClicked

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
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    private int numeroPedido;
    private String nome1;
    private int idUsuario2;
    Conexao conexao = new Conexao();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelComprovante;
    private javax.swing.JLabel labelPedido;
    private javax.swing.JLabel labelRetornar;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
