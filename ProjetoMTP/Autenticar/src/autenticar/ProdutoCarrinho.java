package autenticar;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
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
import javax.swing.UIManager;

public class ProdutoCarrinho extends javax.swing.JPanel {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    
    public ProdutoCarrinho(int idProduto, int idPessoa) {
        initComponents();
        mudarFonte();
        setBackground(Color.WHITE);
        setVisible(true);
        this.setFocusable(false);
        idDaPessoa = idPessoa;
        idDoProduto = idProduto;
        float precoTotal = 0;
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
                labelPreco.setText(new Controle().retornaValorFormatado(Float.toString(rs.getFloat(3))));
                precoTotal = precoTotal+rs.getFloat(3);
            }
            rs.close();
            st.close();
            st = conexao.getConnection().prepareStatement("SELECT quantidade FROM carrinho WHERE id_produto = ?");
            st.setInt(1, idProduto);
            rs = st.executeQuery();
            if (rs.next()) {
                tfQuantidade.setText(String.valueOf(rs.getInt(1)));
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public void deletarDoCarrinho (int idProduto) {
        try {
            PreparedStatement st;
            Conexao conn = new Conexao();
            st = conn.getConnection().prepareStatement("DELETE FROM carrinho WHERE id_produto = ?");
            st.setInt(1, idProduto);
            st.executeUpdate();
            st.close();
            this.finalize();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    public void mudarFonte () {
        Controle ctr = new Controle ();
        labelNome.setFont(ctr.mudaFonte(19));
        labelDescricao.setFont(ctr.mudaFonte(12));
        labelPreco.setFont(ctr.mudaFonte(20));
        labelQtd.setFont(ctr.mudaFonte(20));
        tfQuantidade.setFont(ctr.mudaFonte(14));
    }
    
    public void atualizaQuantidade(int idPessoa, int idProduto, int quantidade) {
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("UPDATE carrinho SET quantidade = ? WHERE id_pessoa = ? AND id_produto = ?");
            st.setInt(1, quantidade);
            st.setInt(2, idPessoa);
            st.setInt(3, idProduto);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int pegaQuantidade (int idPessoa, int idProduto) {
        int quantidade = 0;
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT quantidade FROM carrinho WHERE id_produto = ? AND id_pessoa = ?");
            st.setInt(1, idProduto);
            st.setInt(2, idPessoa);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                quantidade = rs.getInt(1);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return quantidade;
    }
    int idDoProduto;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFotoProduto = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        labelQtd = new javax.swing.JLabel();
        labelRemover = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelFotoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/SEM FOTO.png"))); // NOI18N

        tfQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfQuantidade.setText("1");
        tfQuantidade.setToolTipText("");
        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyPressed(evt);
            }
        });

        labelNome.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        labelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNome.setText("[NOME]");

        labelDescricao.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        labelDescricao.setText("<html> <body> <center>[Nesse campo contém a descrição do produto, ela pode conter características e funções]</center> </body> </html>");

        labelPreco.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        labelPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreco.setText("[PREÇO]");

        labelQtd.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        labelQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQtd.setText("Quantidade");

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
                        .addComponent(labelQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(labelRemover)))
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
                            .addComponent(labelQtd)
                            .addGap(18, 18, 18)
                            .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                atualizaQuantidade(idDaPessoa, idDoProduto, Integer.parseInt(tfQuantidade.getText()));
                JOptionPane.showMessageDialog(null, "A quantidade foi alterada", "Carrinho", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira uma quantidade válida", "Erro", JOptionPane.ERROR_MESSAGE);
                tfQuantidade.setText(String.valueOf(pegaQuantidade(idDaPessoa,idDoProduto)));
            }
        }
    }//GEN-LAST:event_tfQuantidadeKeyPressed

    Conexao conexao = new Conexao();
    private int idDaPessoa;
    private int quantidade;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFotoProduto;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelQtd;
    private javax.swing.JLabel labelRemover;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables
}
