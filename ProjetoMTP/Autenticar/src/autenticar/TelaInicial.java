package autenticar;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;

public class TelaInicial extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public TelaInicial(int id) {
        super ("Super Loja Fictícia");
        this.idUsuario = id;
        initComponents();
        Controle controle = new Controle();
        String nome = controle.mostraNome(id);
        String[] nome1 = nome.split(" ");
        LabelNomeUsuario.setText("Olá, " + nome1[0] + "!");
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        controle.pegaFoto(idUsuario);
        labelFotoUsuario.setIcon(controle.getFoto());
        setVisible(true);
        labelFotoUsuarioMouseEvento.setVisible(false);
        new Propaganda ();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNomeUsuario = new javax.swing.JLabel();
        LabelMinhaConta = new javax.swing.JLabel();
        LabelSair = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        textFieldPesquisa = new javax.swing.JTextField();
        botaoIr = new javax.swing.JButton();
        LabelCarrinho = new javax.swing.JLabel();
        labelFotoUsuarioMouseEvento = new javax.swing.JLabel();
        labelCarrinho = new javax.swing.JLabel();
        labelAcessar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        painelConteudo = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        labelDepartamentos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelFotoUsuario = new javax.swing.JLabel();
        cover = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        LabelNomeUsuario.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        LabelNomeUsuario.setText("Olá, usuário!");

        LabelMinhaConta.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        LabelMinhaConta.setText("Minha conta >");
        LabelMinhaConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelMinhaConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelMinhaContaMouseClicked(evt);
            }
        });

        LabelSair.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        LabelSair.setText("Sair");
        LabelSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelSairMouseClicked(evt);
            }
        });

        textFieldPesquisa.setText("Pesquisar...");

        botaoIr.setText("Ir");

        LabelCarrinho.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        LabelCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/shoppingcart_compras_3767.png"))); // NOI18N
        LabelCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelCarrinhoMouseClicked(evt);
            }
        });

        labelFotoUsuarioMouseEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user_mudarfoto.png"))); // NOI18N
        labelFotoUsuarioMouseEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFotoUsuarioMouseEventoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelFotoUsuarioMouseEventoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelFotoUsuarioMouseEventoMouseExited(evt);
            }
        });

        labelCarrinho.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        labelCarrinho.setText("Carrinho de Compras (0)");

        labelAcessar.setText("Acessar >");
        labelAcessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAcessarMouseClicked(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Informática", "Eletrodomésticos", "Artigos Esportivos", "Games", "..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout painelConteudoLayout = new javax.swing.GroupLayout(painelConteudo);
        painelConteudo.setLayout(painelConteudoLayout);
        painelConteudoLayout.setHorizontalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addContainerGap(806, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelConteudoLayout.setVerticalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        jLabel1.setText("<  1  >");

        labelDepartamentos.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelDepartamentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDepartamentos.setText("Departamentos");

        jLabel2.setText("Excluir Tudo");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Favoritos");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/favorito_normal.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/banner1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user.png"))); // NOI18N
        labelFotoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelFotoUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelFotoUsuarioMouseExited(evt);
            }
        });

        cover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user_branco.png"))); // NOI18N
        cover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                coverMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(labelFotoUsuarioMouseEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(painelConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(434, 434, 434)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelMinhaConta)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelNomeUsuario)
                                            .addComponent(LabelSair))))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoIr, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel5))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(labelCarrinho))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(LabelCarrinho))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(labelAcessar))
                                        .addGap(53, 53, 53)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(cover)
                    .addContainerGap(845, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(840, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelCarrinho)
                                .addGap(15, 15, 15)
                                .addComponent(labelCarrinho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelAcessar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldPesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoIr)
                                        .addComponent(LabelNomeUsuario)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(LabelMinhaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(LabelSair))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(labelFotoUsuarioMouseEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDepartamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(cover, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 489, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 493, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void LabelMinhaContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelMinhaContaMouseClicked

        this.dispose();
        new AlterarDados(idUsuario);

    }//GEN-LAST:event_LabelMinhaContaMouseClicked

    private void LabelSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSairMouseClicked
        this.dispose();
        new Logar();
    }//GEN-LAST:event_LabelSairMouseClicked

    private void LabelCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCarrinhoMouseClicked
        new Carrinho(idUsuario);
    }//GEN-LAST:event_LabelCarrinhoMouseClicked

    private void labelAcessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAcessarMouseClicked
        new Carrinho(idUsuario);
    }//GEN-LAST:event_labelAcessarMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new CadastrarProdutos ();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void labelFotoUsuarioMouseEventoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFotoUsuarioMouseEventoMouseEntered
        labelFotoUsuarioMouseEvento.setVisible(true);
    }//GEN-LAST:event_labelFotoUsuarioMouseEventoMouseEntered

    private void labelFotoUsuarioMouseEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFotoUsuarioMouseEventoMouseExited
        labelFotoUsuarioMouseEvento.setVisible(false);
    }//GEN-LAST:event_labelFotoUsuarioMouseEventoMouseExited

    private void labelFotoUsuarioMouseEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFotoUsuarioMouseEventoMouseClicked
        File arquivo;
        JFileChooser fc = new JFileChooser();
        ImageIcon foto = new ImageIcon(this.getClass().getResource("Foto/user.png"));
        int retorno = fc.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();
            try {
                BufferedImage imag = ImageIO.read(arquivo);            
                if (imag == null) {                    
                    labelFotoUsuario.setIcon(foto);
                } 
                else {
                    Image image = imag;                    
                    image = image.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(image);
                    labelFotoUsuario.setIcon(icon);
                    new Controle().mudarFoto(idUsuario , arquivo);
                }
                pack();
		setLocationRelativeTo(null);
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if (retorno == JFileChooser.ERROR_OPTION) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo." , "Erro" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_labelFotoUsuarioMouseEventoMouseClicked

    private void coverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coverMouseExited
        labelFotoUsuarioMouseEvento.setVisible(false);
    }//GEN-LAST:event_coverMouseExited

    private void coverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coverMouseEntered
        labelFotoUsuarioMouseEvento.setVisible(true);
    }//GEN-LAST:event_coverMouseEntered

    private void labelFotoUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFotoUsuarioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_labelFotoUsuarioMouseExited

    private void labelFotoUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFotoUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_labelFotoUsuarioMouseEntered

    public static void main(String args[]) throws IllegalAccessException {
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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    public javax.swing.JPanel getPainel () {
        return this.painelConteudo;
    }
    int idUsuario;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCarrinho;
    private javax.swing.JLabel LabelMinhaConta;
    private javax.swing.JLabel LabelNomeUsuario;
    private javax.swing.JLabel LabelSair;
    private javax.swing.JButton botaoIr;
    private javax.swing.JLabel cover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAcessar;
    private javax.swing.JLabel labelCarrinho;
    private javax.swing.JLabel labelDepartamentos;
    private javax.swing.JLabel labelFotoUsuario;
    private javax.swing.JLabel labelFotoUsuarioMouseEvento;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JTextField textFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
