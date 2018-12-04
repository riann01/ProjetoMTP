package autenticar;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;

public class CadastrarProdutos extends javax.swing.JFrame {
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    
    public CadastrarProdutos(int idUsuario) {
        idDoUsuario = idUsuario;
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        mudaFonte();
        setLocationRelativeTo(null);
        setVisible(true);
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new Controle().pegaModeloCatGerenciador()));
        fc = new JFileChooser();
    }
    
    public void mudaFonte() {
        Controle ctr = new Controle();
        labelAtualizarProduto.setFont(ctr.mudaFonte(24));
        labelNome.setFont(ctr.mudaFonte(12));
        nome.setFont(ctr.mudaFonte(12));
        labelCusto.setFont(ctr.mudaFonte(12));
        valor_compra.setFont(ctr.mudaFonte(12));
        labelValor.setFont(ctr.mudaFonte(12));
        valor_venda.setFont(ctr.mudaFonte(12));
        labelDescricao.setFont(ctr.mudaFonte(12));
        descricao.setFont(ctr.mudaFonte(13));
        labelCategoria.setFont(ctr.mudaFonte(12));
        cbCategoria.setFont(ctr.mudaFonte(12));
        labelFoto.setFont(ctr.mudaFonte(12));
        adicionaImagem.setFont(ctr.mudaFonte(13));
        caminho.setFont(ctr.mudaFonte(12));
        botaoCadastrar.setFont(ctr.mudaFonte(13));
        btnCancelar.setFont(ctr.mudaFonte(13));
    }
    
    public boolean verificador () {
        if (verificaNome() || verificaDesc() || verificaValorCompra() || verificaValorVenda()) {
            return true;
        }
        return false;
    }
    
    public boolean verificaNome() {
        if (nome.getText().equals("") || nome.getText().equals(" ")) {
            return true;
        }
        return false;
    }
    
    public boolean verificaDesc() {
        if (descricao.getText().equals("") || descricao.getText().equals(" ")) {
            return true;
        }
        return false;
    }
    
    public boolean verificaValorCompra() {
        if (valor_compra.getText().equals("") || valor_compra.getText().equals(" ")) {
            return true;
        }
        return false;
    }
    
    public boolean verificaValorVenda() {
        if (valor_venda.getText().equals("") || valor_venda.getText().equals(" ")) {
            return true;
        }
        return false;
    }
    
    public boolean verificaQuantidade() {
        if (nome.getText().length()>20) {
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAtualizarProduto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botaoCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        labelCusto = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        valor_venda = new javax.swing.JTextField();
        labelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        labelCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        labelFoto = new javax.swing.JLabel();
        adicionaImagem = new javax.swing.JButton();
        valor_compra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        caminho = new javax.swing.JLabel();
        labelImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelAtualizarProduto.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        labelAtualizarProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtualizarProduto.setText("CADASTRAR PRODUTOS");

        botaoCadastrar.setText("Atualizar");
        botaoCadastrar.setActionCommand("");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelNome.setText("Nome");

        labelCusto.setText("Custo");

        labelValor.setText("Valor");

        labelDescricao.setText("Descrição");

        descricao.setColumns(20);
        descricao.setRows(5);
        jScrollPane1.setViewportView(descricao);

        labelCategoria.setText("Categoria");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cbBox", " " }));

        labelFoto.setText("Foto");

        adicionaImagem.setText("Procurar");
        adicionaImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nome)
                    .addComponent(valor_venda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelValor)
                            .addComponent(labelNome)
                            .addComponent(labelCusto)
                            .addComponent(labelDescricao)
                            .addComponent(labelCategoria)
                            .addComponent(adicionaImagem)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelFoto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(valor_compra))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCusto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valor_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(labelValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valor_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(labelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adicionaImagem)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        caminho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caminho.setText("Nome do Arquivo");
        caminho.setAutoscrolls(true);
        caminho.setFocusable(false);
        caminho.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/SEM FOTO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(labelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(caminho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelImagem)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(botaoCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAtualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelAtualizarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        new GerenciarProdutos(idDoUsuario);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (verificaQuantidade()) {
            JOptionPane.showMessageDialog(null, "O nome do produto não pode exceder vinte caracteres", "Erro ao inserir produto", JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (verificador()) {
                JOptionPane.showMessageDialog(null, "Não é possível adicionar o produto, um ou mais campos estão vazios", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (fc.getSelectedFile()==null) {
                    JOptionPane jp = new JOptionPane ();
                    jp.showConfirmDialog(null , "O produto será adicionado sem foto, deseja continuar?" , "Atenção" , JOptionPane.YES_NO_OPTION);
                    if (jp.getOptionType()==-1) {
                        Conexao conexao = new Conexao();
                        conexao.inserirProduto(nome.getText(), descricao.getText(), Float.parseFloat(valor_compra.getText()), Float.parseFloat(valor_venda.getText()), arquivo, new Controle().pegaIdCategorias(cbCategoria.getSelectedItem()));
                        this.dispose();
                        new GerenciarProdutos(idDoUsuario);
                    }
                }
                else {
                    Conexao conexao = new Conexao();
                    conexao.inserirProduto(nome.getText(), descricao.getText(), Float.parseFloat(valor_compra.getText()), Float.parseFloat(valor_venda.getText()), arquivo, new Controle().pegaIdCategorias(cbCategoria.getSelectedItem()));
                    this.dispose();
                    new GerenciarProdutos(idDoUsuario);
                }
            }
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void adicionaImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaImagemActionPerformed
        int retorno = fc.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();
            try {
                BufferedImage imag = ImageIO.read(arquivo);              
                if (imag == null) {                    
                    labelImagem.setIcon(null);  
                }
                else {
                    Image image = imag;                    
                    image = image.getScaledInstance(236, 135, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(image);
                    labelImagem.setIcon(icon);
                    String path = "<html><body><center>"+fc.getSelectedFile().getName()+"</center></body></html>";
                    caminho.setText(path);
                    caminho.setVisible(true);
                }
                pack();
		setLocationRelativeTo(null);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_adicionaImagemActionPerformed

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
            java.util.logging.Logger.getLogger(AtualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }
    private Conexao connection = new Conexao();
    private int idDoProduto;
    private int idDoUsuario;
    private JFileChooser fc;
    private File arquivo = new File ("Foto/SEM FOTO.png");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionaImagem;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel caminho;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JTextArea descricao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAtualizarProduto;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelCusto;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelValor;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField valor_compra;
    private javax.swing.JTextField valor_venda;
    // End of variables declaration//GEN-END:variables
}