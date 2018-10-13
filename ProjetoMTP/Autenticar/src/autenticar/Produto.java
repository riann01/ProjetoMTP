package autenticar;
import java.awt.Color;
import javax.swing.ImageIcon;
public class Produto extends javax.swing.JPanel {

    public Produto(/*ImageIcon foto,*/ String nome, String descricao, int categoria) {
        initComponents();
        setBackground(Color.WHITE);
        labelNomeProduto.setText(nome);
        labelDescricao.setText(descricao);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNomeProduto = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelFotoProduto = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        labelNomeProduto.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        labelNomeProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeProduto.setText("NOME DO PRODUTO");
        labelNomeProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelDescricao.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        labelDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescricao.setText("<html>\n<body>\n<center>[Nesse campo contém a descrição do produto, ela pode conter características e funções]</center>\n</body>\n</html>");
        labelDescricao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        labelFotoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/SEM FOTO.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelFotoProduto)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(labelNomeProduto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFotoProduto)
                .addGap(18, 18, 18)
                .addComponent(labelNomeProduto)
                .addGap(18, 18, 18)
                .addComponent(labelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFotoProduto;
    private javax.swing.JLabel labelNomeProduto;
    // End of variables declaration//GEN-END:variables
}
