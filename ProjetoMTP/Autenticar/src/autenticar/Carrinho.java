package autenticar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Carrinho extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public Carrinho(int id) {
        super("Carrinho de Compras");
        Controle controle = new Controle ();
        initComponents();
        String nome1 = controle.mostraNome(id);
        String[] nome2 = nome1.split(" ");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        labelCarrinhoDeCompras.setText("Carrinho de Compras do " + nome2[0]);
        setVisible(true);
        int controle1 = 0;
        int i = 0;
        Conexao conexao = new Conexao();
        PreparedStatement st;
        
        try {
            st = conexao.getConnection().prepareStatement("SELECT id_produto FROM carrinho WHERE id_pessoa = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {  
                i++;
                ProdutoCarrinho p = new ProdutoCarrinho(rs.getInt(1));
                controle1 += 170;
                painelCarrinho2.add(p);
                painelCarrinho2.setPreferredSize(new Dimension(700,controle1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i==1) {
            labelQtdItens.setText(String.valueOf(i)+" ITEM");
        }
        else {
            labelQtdItens.setText(String.valueOf(i)+" ITENS");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCarrinhoDeCompras = new javax.swing.JLabel();
        labelIconeCarrinho = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelCarrinho = new javax.swing.JPanel();
        labelResumo = new javax.swing.JLabel();
        labelFinalizarCompra = new javax.swing.JLabel();
        labelQtdItens = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        painelCarrinho2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        labelCarrinhoDeCompras.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelCarrinhoDeCompras.setText("Carrinho de Compras do [USUÁRIO]");

        labelIconeCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/shoppingcart_compras_3767.png"))); // NOI18N

        panelCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        panelCarrinho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelResumo.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        labelResumo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResumo.setText("RESUMO");

        labelFinalizarCompra.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labelFinalizarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFinalizarCompra.setText("FINALIZAR COMPRA");
        labelFinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelQtdItens.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labelQtdItens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQtdItens.setText("[QTD] ITENS");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUBTOTAL");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("R$[TOTAL]");

        javax.swing.GroupLayout panelCarrinhoLayout = new javax.swing.GroupLayout(panelCarrinho);
        panelCarrinho.setLayout(panelCarrinhoLayout);
        panelCarrinhoLayout.setHorizontalGroup(
            panelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFinalizarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(labelResumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelQtdItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCarrinhoLayout.setVerticalGroup(
            panelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelResumo)
                .addGap(18, 18, 18)
                .addComponent(labelQtdItens)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(labelFinalizarCompra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelCarrinho2.setBackground(new java.awt.Color(255, 255, 255));
        painelCarrinho2.setAutoscrolls(true);
        painelCarrinho2.setMaximumSize(new java.awt.Dimension(32000, 32000));
        painelCarrinho2.setMinimumSize(new java.awt.Dimension(700, 413));
        painelCarrinho2.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane1.setViewportView(painelCarrinho2);
        painelCarrinho2.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(labelIconeCarrinho)
                        .addGap(27, 27, 27)
                        .addComponent(labelCarrinhoDeCompras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIconeCarrinho)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labelCarrinhoDeCompras)))
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCarrinhoDeCompras;
    private javax.swing.JLabel labelFinalizarCompra;
    private javax.swing.JLabel labelIconeCarrinho;
    private javax.swing.JLabel labelQtdItens;
    private javax.swing.JLabel labelResumo;
    private javax.swing.JPanel painelCarrinho2;
    private javax.swing.JPanel panelCarrinho;
    // End of variables declaration//GEN-END:variables
}
