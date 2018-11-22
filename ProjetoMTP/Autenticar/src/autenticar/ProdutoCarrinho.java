package autenticar;
import java.awt.Color;
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
import javax.swing.JOptionPane;
public class ProdutoCarrinho extends javax.swing.JPanel {

    public ProdutoCarrinho(int idProduto) {
        initComponents();
        setBackground(Color.WHITE);
        setVisible(true);
        idDoProduto = idProduto;
        float precoTotal = 0;
        Conexao conexao = new Conexao();
        PreparedStatement st;
        
        try {
            st = conexao.getConnection().prepareStatement("SELECT nome_produto, descricao, preco_venda, foto FROM produto WHERE id_produto = ?");
            st.setInt(1, idProduto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {                
                byte[] binario = rs.getBytes(4);
                InputStream is = new ByteArrayInputStream(binario);
                BufferedImage imag = ImageIO.read(is);
                Image image = imag;                    
                image = image.getScaledInstance(236, 135, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                labelFotoProduto.setIcon(icon);
                labelNome.setText("<html><body><center>"+rs.getString(1)+"</center></body></html>");
                labelDescricao.setText("<html><body><center>"+rs.getString(2)+"</center></body></html>");
                float transf = rs.getFloat(3);
                String convertido = String.valueOf(transf);
                String replace = convertido.replace('.', ',');
                labelPreco.setText("R$"+replace);
                precoTotal = precoTotal+rs.getFloat(3);
            }
            rs.close();
            st.close();
            st = conexao.getConnection().prepareStatement("SELECT quantidade FROM carrinho WHERE id_produto = ?");
            st.setInt(1, idProduto);
            rs = st.executeQuery();
            if (rs.next()) {
                labelQuantidade.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    //System.out.println(precoTotal);
    public void deletarDoCarrinho (int idProduto) {
        try {
            PreparedStatement st;
            Conexao conn = new Conexao();
            st = conn.getConnection().prepareStatement("DELETE FROM carrinho WHERE id_produto = ?");
            st.setInt(1, idProduto);
            st.executeUpdate();
            st.close();
            this.finalize();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    int idDoProduto;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFotoProduto = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelRemover = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelFotoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/SEM FOTO.png"))); // NOI18N

        labelQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelQuantidade.setText("1");
        labelQuantidade.setToolTipText("");

        labelNome.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("[NOME]");

        labelDescricao.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        labelDescricao.setText("<html> <body> <center>[Nesse campo contém a descrição do produto, ela pode conter características e funções]</center> </body> </html>");

        labelPreco.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        labelPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreco.setText("[PREÇO]");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantidade");

        labelRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/botaox.png"))); // NOI18N
        labelRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRemoverMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 181));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFotoProduto)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRemover)
                            .addComponent(labelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(labelNome)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPreco))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(29, 29, 29)
                            .addComponent(labelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(labelRemover))
                        .addComponent(labelFotoProduto))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRemoverMouseClicked
        deletarDoCarrinho(idDoProduto);
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "Produto excluído." , "Informação" , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelRemoverMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFotoProduto;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JTextField labelQuantidade;
    private javax.swing.JLabel labelRemover;
    // End of variables declaration//GEN-END:variables
}
