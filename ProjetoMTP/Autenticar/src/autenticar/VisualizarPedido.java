package autenticar;

import java.awt.Color;

public class VisualizarPedido extends javax.swing.JFrame {

    public VisualizarPedido(int idPessoa, int idPedido) {
        this.getContentPane().setBackground(Color.WHITE);
        idDaPessoa = idPessoa;
        idDoPedido = idPedido;
        initComponents();
        labelTitulo.setText("Pedido "+ctr.tratarNumeroPedido(idPedido));
        mudarFonte();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void mudarFonte () {
        labelTitulo.setFont(ctr.mudaFonte(24));
        labelFechar.setFont(ctr.mudaFonte(14));
        labelVisualizarComprovante.setFont(ctr.mudaFonte(14));
        labelMensagem.setFont(ctr.mudaFonte(18));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIconeEntrega = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelVisualizarComprovante = new javax.swing.JLabel();
        labelFechar = new javax.swing.JLabel();
        labelMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        labelIconeEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/entrega.png"))); // NOI18N

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Pedido #9999");

        labelVisualizarComprovante.setText("Visualizar Comprovante");
        labelVisualizarComprovante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelVisualizarComprovante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVisualizarComprovanteMouseClicked(evt);
            }
        });

        labelFechar.setText("Fechar");
        labelFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFecharMouseClicked(evt);
            }
        });

        labelMensagem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensagem.setText("Pedido enviado à transportadora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(labelFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(labelVisualizarComprovante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(labelIconeEntrega)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(labelMensagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelIconeEntrega)
                .addGap(18, 18, 18)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFechar)
                    .addComponent(labelVisualizarComprovante))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFecharMouseClicked
        this.dispose();
        new MeusPedidos(idDaPessoa);
    }//GEN-LAST:event_labelFecharMouseClicked

    private void labelVisualizarComprovanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVisualizarComprovanteMouseClicked
        new Comprovante(idDaPessoa, idDoPedido, 2);
    }//GEN-LAST:event_labelVisualizarComprovanteMouseClicked
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
            java.util.logging.Logger.getLogger(VisualizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    
    Controle ctr = new Controle();
    private int idDoPedido;
    private int idDaPessoa;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFechar;
    private javax.swing.JLabel labelIconeEntrega;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVisualizarComprovante;
    // End of variables declaration//GEN-END:variables
}
