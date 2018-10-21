package autenticar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Produto extends javax.swing.JPanel {

    public Produto( int idUsuario, int idProduto, String nome, String descricao, Float preco, ImageIcon foto) {
        initComponents();
        setBackground(Color.WHITE);
        labelNomeProduto.setText(nome);
        labelDescricao.setText(descricao);
        labelPreco.setText("R$"+Float.toString(preco));
        labelFotoProduto.setIcon(foto);
        setVisible(true);
        
        this.idUsuario1 = idUsuario;
        this.idProduto1 = idProduto;
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNomeProduto = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelFotoProduto = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        carrinhoAdiciona = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelNomeProduto.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        labelNomeProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeProduto.setText("NOME DO PRODUTO");
        labelNomeProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelDescricao.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labelDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescricao.setText("<html>\n<body>\n<center>[Nesse campo contém a descrição do produto, ela pode conter características e funções]</center>\n</body>\n</html>");
        labelDescricao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        labelFotoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/SEM FOTO.png"))); // NOI18N

        labelPreco.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        labelPreco.setText("[PREÇO]");

        carrinhoAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/adicionar.png"))); // NOI18N
        carrinhoAdiciona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carrinhoAdicionaMouseClicked(evt);
            }
        });

        quantidade.setText("1");
        quantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantidadeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFotoProduto)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelNomeProduto)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPreco)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(carrinhoAdiciona)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFotoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNomeProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPreco)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carrinhoAdiciona)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void carrinhoAdicionaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carrinhoAdicionaMouseClicked
        Conexao conexao = new Conexao();
        conexao.inserirProdutoCarrinho(this.idUsuario1, this.idProduto1, Integer.parseInt(quantidade.getText()));
        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        
    }//GEN-LAST:event_carrinhoAdicionaMouseClicked

    private void quantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantidadeMouseClicked
        
    }//GEN-LAST:event_quantidadeMouseClicked

    private int idUsuario1;
    private int idProduto1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carrinhoAdiciona;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFotoProduto;
    private javax.swing.JLabel labelNomeProduto;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JTextField quantidade;
    // End of variables declaration//GEN-END:variables
}
