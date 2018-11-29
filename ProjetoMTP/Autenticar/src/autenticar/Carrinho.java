package autenticar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
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
        Controle controle = new Controle();
        mostraIcones();
        initComponents();
        mudarFonte();
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        idUsuario = id;
        mudaNomeLabel(idUsuario);
        mostraEndereco(idUsuario);
        labelSemItens.setVisible(false);
        mostrarItens();
        atualizaItens(idUsuario);
        mostraTotal(idUsuario);
    }

    public void mostrarItens() {
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
                painelCarrinho2.setPreferredSize(new Dimension(700, controle1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizaItens(int idPessoa) {
        int cont = 0;
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT * FROM carrinho WHERE id_pessoa = ?");
            st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ++cont;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (cont == 0) {
            panelCarrinho.setVisible(false);
            labelSemItens.setVisible(true);
            panelEndereco.setVisible(false);
            painelCarrinho2.setVisible(false);
            jScrollPane1.setVisible(false);
        }
        else {
            if (cont == 1) {
                labelQtdItens.setText(String.valueOf(cont) + " ITEM");
                panelCarrinho.setVisible(true);
            } else {
                labelQtdItens.setText(String.valueOf(cont) + " ITENS");
            }
        }
    }

    public void mostraEndereco(int idUsuario) {
        Conexao conn = new Conexao();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement("SELECT endereco, cidade_estado FROM pessoa WHERE id_pessoa = ?");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                labelEndereco.setText("<html><body><center>" + rs.getString(1) + "\n" + rs.getString(2) + "</center></body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mudarFonte() {
        Controle ctr = new Controle();
        labelResumo.setFont(ctr.mudaFonte(24));
        labelFinalizarCompra.setFont(ctr.mudaFonte(14));
        labelQtdItens.setFont(ctr.mudaFonte(14));
        labelSubtotal.setFont(ctr.mudaFonte(18));
        precoTotal.setFont(ctr.mudaFonte(24));
        labelEntrega.setFont(ctr.mudaFonte(14));
        labelEndereco.setFont(ctr.mudaFonte(15));
        labelCarrinhoDeCompras.setFont(ctr.mudaFonte(18));
        labelSemItens.setFont(ctr.mudaFonte(24));
    }

    public void mostraIcones() {
        carrinho = new ImageIcon(getClass().getResource("Foto/carrinho.png"));
        //labelIconeCarrinho.setIcon(carrinho);
    }
    
    public void mostraTotal (int id_pessoa) {
        float quantidade, valorProduto, total = 0;
        try {
            String query = "SELECT preco_venda, quantidade, P.id_produto FROM produto AS P JOIN carrinho AS C ON C.id_produto = P.id_produto WHERE C.id_pessoa = ?";
            PreparedStatement st = this.conexao.getConnection().prepareStatement(query);
            st.setInt(1, id_pessoa);
            ResultSet rs = st.executeQuery();
            m = -1;
            while (rs.next()) {
                idsPedidos[m+1] = rs.getInt(3);
                quantidades[m+1] = rs.getInt(2);
                valorProduto = rs.getFloat(1);
                quantidade = rs.getInt(2);
                total = ((quantidade*valorProduto)+total);
                m++;
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        this.valorTotalGlobal = total;
        String valorTotal = "R$"+String.valueOf(this.valorTotalGlobal).replace(".", ",");
        
        precoTotal.setText(valorTotal);
    }

    public void mudaNomeLabel (int idUser) {
        Controle ctr = new Controle();
        String nome1 = ctr.mostraNome(idUser);
        String[] nome2 = nome1.split(" ");
        if (ctr.pegaSexo(idUser).equals("M")) {
            labelCarrinhoDeCompras.setText("Carrinho de Compras do " + nome2[0]);
        } else {
            labelCarrinhoDeCompras.setText("Carrinho de Compras da " + nome2[0]);
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
        labelSubtotal = new javax.swing.JLabel();
        precoTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        painelCarrinho2 = new javax.swing.JPanel();
        labelSemItens = new javax.swing.JLabel();
        panelEndereco = new javax.swing.JPanel();
        labelEntrega = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        labelCarrinhoDeCompras.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelCarrinhoDeCompras.setText("Carrinho de Compras do [USUÁRIO]");
        labelCarrinhoDeCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelIconeCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/carrinho.png"))); // NOI18N
        labelIconeCarrinho.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        labelIconeCarrinho.setMaximumSize(new java.awt.Dimension(52, 52));
        labelIconeCarrinho.setMinimumSize(new java.awt.Dimension(52, 52));
        labelIconeCarrinho.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        panelCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        panelCarrinho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelResumo.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        labelResumo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResumo.setText("RESUMO");

        labelFinalizarCompra.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labelFinalizarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFinalizarCompra.setText("FINALIZAR COMPRA");
        labelFinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelFinalizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFinalizarCompraMouseClicked(evt);
            }
        });

        labelQtdItens.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labelQtdItens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQtdItens.setText("[QTD] ITENS");

        labelSubtotal.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        labelSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtotal.setText("SUBTOTAL");

        precoTotal.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        precoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        precoTotal.setText("R$[TOTAL]");

        javax.swing.GroupLayout panelCarrinhoLayout = new javax.swing.GroupLayout(panelCarrinho);
        panelCarrinho.setLayout(panelCarrinhoLayout);
        panelCarrinhoLayout.setHorizontalGroup(
            panelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFinalizarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
            .addComponent(labelResumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelQtdItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(labelSubtotal)
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

        labelSemItens.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSemItens.setText("Hmm... parece meio vazio por aqui, tente adiciocar alguns itens!");

        panelEndereco.setBackground(new java.awt.Color(254, 254, 254));
        panelEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelEntrega.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        labelEntrega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEntrega.setText("Entregar em:");

        labelEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEndereco.setText("[ENDEREÇO]");

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEntrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIconeCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCarrinhoDeCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(labelSemItens))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelCarrinhoDeCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(labelIconeCarrinho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(190, 190, 190)
                                        .addComponent(labelSemItens))
                                    .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
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
        atualizaItens(idUsuario);
    }//GEN-LAST:event_painelCarrinho2MouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        this.revalidate();
    }//GEN-LAST:event_formMouseMoved

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        atualizaItens(idUsuario);
    }//GEN-LAST:event_formMouseEntered

    private void labelFinalizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFinalizarCompraMouseClicked
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("INSERT INTO pedido(valor_total, data, id_pessoa) VALUES (?,?,?)");            
            st.setFloat(1, valorTotalGlobal);
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date data = new Date(dataUtil.getTime());
            st.setDate(2, data);
            st.setInt(3, idUsuario);
            st.executeUpdate();
            st.close();
            int idPedido11 = 0;
            st = conexao.getConnection().prepareStatement("SELECT id_pedido FROM pedido WHERE id_pessoa = ?");      
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                
                idPedido11 = rs.getInt(1);
                
            }
            rs.close();
            st.close();
            for(int k=0;k<=m;k++){    
                st = conexao.getConnection().prepareStatement("INSERT INTO produto_pedido(id_produto, id_pedido, quantidade) VALUES (?,?,?)");            
                st.setInt(1, idsPedidos[k]);
                st.setInt(2, idPedido11);
                st.setInt(3, quantidades[k]);
                st.executeUpdate();
                st.close();
            }    
            st = conexao.getConnection().prepareStatement("DELETE FROM carrinho WHERE id_pessoa = ?");           
            st.setInt(1, idUsuario);
            st.executeUpdate();
            st.close();
            //st = conexao.getConnection().prepareStatement("INSET INTO pedido_produto (preco, quantidade, id_produto, id_pedido) VALUES (?,?,?,?)");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dispose();
        new FinalizarPedido(idUsuario);
    }//GEN-LAST:event_labelFinalizarCompraMouseClicked

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
    }
    Float valorTotalGlobal = new Float(1.0);
    Conexao conexao = new Conexao();
    private final int idUsuario;
    ImageIcon carrinho;
    
    int m;
    Integer[] idsPedidos = new Integer[50];
    Integer[] quantidades = new Integer[50];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCarrinhoDeCompras;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelEntrega;
    private javax.swing.JLabel labelFinalizarCompra;
    private javax.swing.JLabel labelIconeCarrinho;
    private javax.swing.JLabel labelQtdItens;
    private javax.swing.JLabel labelResumo;
    private javax.swing.JLabel labelSemItens;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JPanel painelCarrinho2;
    private javax.swing.JPanel panelCarrinho;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JLabel precoTotal;
    // End of variables declaration//GEN-END:variables
}