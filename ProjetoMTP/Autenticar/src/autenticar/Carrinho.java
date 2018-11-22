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
        idUsuario = id;
        mostraEndereco(idUsuario);
        labelSemItens.setVisible(false);
        mostrarItens();
        atualizaItens();
    }
    
    public void mostrarItens () {
        int controle1 = 0;
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT id_produto FROM carrinho WHERE id_pessoa = ?");
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {  
                ProdutoCarrinho p = new ProdutoCarrinho(rs.getInt(1));
                controle1 += 170;
                painelCarrinho2.add(p);
                painelCarrinho2.setPreferredSize(new Dimension(700,controle1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizaItens () {
        int cont = 0;
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT * FROM carrinho");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ++cont;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (cont==0) {
            panelCarrinho.setVisible(false);
            labelSemItens.setVisible(true);
            panelEndereco.setVisible(false);
        }
        else {
            if (cont==1) {
                labelQtdItens.setText(String.valueOf(cont)+" ITEM");
                panelCarrinho.setVisible(true);
            }
            else {
                labelQtdItens.setText(String.valueOf(cont)+" ITENS");
            }
        }
    }
        
    public void mostraEndereco (int idUsuario) {
        Conexao conn = new Conexao ();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement("SELECT endereco, cidade_estado FROM pessoa WHERE id_pessoa = ?");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                labelEndereco.setText("<html><body><center>"+rs.getString(1)+"\n"+rs.getString(2)+"</center></body></html>");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
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
        precoTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        painelCarrinho2 = new javax.swing.JPanel();
        labelSemItens = new javax.swing.JLabel();
        panelEndereco = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();

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

        precoTotal.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        precoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        precoTotal.setText("R$[TOTAL]");

        javax.swing.GroupLayout panelCarrinhoLayout = new javax.swing.GroupLayout(panelCarrinho);
        panelCarrinho.setLayout(panelCarrinhoLayout);
        panelCarrinhoLayout.setHorizontalGroup(
            panelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFinalizarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelResumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelQtdItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(precoTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(precoTotal)
                .addGap(18, 18, 18)
                .addComponent(labelFinalizarCompra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusLost(evt);
            }
        });

        painelCarrinho2.setBackground(new java.awt.Color(255, 255, 255));
        painelCarrinho2.setAutoscrolls(true);
        painelCarrinho2.setMaximumSize(new java.awt.Dimension(32000, 32000));
        painelCarrinho2.setMinimumSize(new java.awt.Dimension(700, 413));
        painelCarrinho2.setPreferredSize(new java.awt.Dimension(0, 0));
        painelCarrinho2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                painelCarrinho2MouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(painelCarrinho2);
        painelCarrinho2.getAccessibleContext().setAccessibleName("");

        labelSemItens.setText("Hmm... parece meio vazio por aqui, tente adiciocar alguns itens!");

        panelEndereco.setBackground(new java.awt.Color(254, 254, 254));
        panelEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Entregar em:");

        labelEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEndereco.setText("[ENDEREÇO]");

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelSemItens)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelIconeCarrinho)
                                .addGap(27, 27, 27)
                                .addComponent(labelCarrinhoDeCompras)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIconeCarrinho)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labelCarrinhoDeCompras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSemItens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained
        this.revalidate();
    }//GEN-LAST:event_jScrollPane1FocusGained

    private void jScrollPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusLost
        this.revalidate();
    }//GEN-LAST:event_jScrollPane1FocusLost

    private void painelCarrinho2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCarrinho2MouseMoved
        atualizaItens();
    }//GEN-LAST:event_painelCarrinho2MouseMoved

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
    Conexao conexao = new Conexao();
    private final int idUsuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCarrinhoDeCompras;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelFinalizarCompra;
    private javax.swing.JLabel labelIconeCarrinho;
    private javax.swing.JLabel labelQtdItens;
    private javax.swing.JLabel labelResumo;
    private javax.swing.JLabel labelSemItens;
    private javax.swing.JPanel painelCarrinho2;
    private javax.swing.JPanel panelCarrinho;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JLabel precoTotal;
    // End of variables declaration//GEN-END:variables
}