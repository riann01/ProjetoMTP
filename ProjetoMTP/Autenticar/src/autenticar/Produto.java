package autenticar;
import java.awt.Color;
import javax.swing.ImageIcon;
public class Produto extends javax.swing.JPanel {

    public Produto( int idUsuario, int idProduto, String nome, String descricao, Float preco, ImageIcon foto) {
        initComponents();
        setBackground(Color.WHITE);
        labelNomeProduto.setText(nome);
        labelDescricao.setText(descricao);
        labelPreco.setText("R$"+Float.toString(preco));
        labelFotoProduto.setIcon(foto);
        setVisible(true);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNomeProduto = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelFotoProduto = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/adicionar.png"))); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(labelPreco))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)))
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
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFotoProduto;
    private javax.swing.JLabel labelNomeProduto;
    private javax.swing.JLabel labelPreco;
    // End of variables declaration//GEN-END:variables
}
