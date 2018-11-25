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
        labelPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreco.setText("[PREÇO]");

        carrinhoAdiciona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carrinhoAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/adicionar.png"))); // NOI18N
        carrinhoAdiciona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(labelDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(labelNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelPreco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelFotoProduto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(carrinhoAdiciona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)))
                .addContainerGap())
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
                .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carrinhoAdiciona, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void carrinhoAdicionaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carrinhoAdicionaMouseClicked
        new Controle().corrigirDualidades(idProduto1, idUsuario1, Integer.parseInt(quantidade.getText()));
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
