package autenticar;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Comprovante extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    
    public Comprovante(int idUsuario, int idPedido, int operacao) {
        initComponents();
        labelAtencao.setFont(new Controle().mudaFonte(11));
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        preencherTabela(idUsuario, idPedido, operacao);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cabecalho = new javax.swing.JLabel();
        cabecalho1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaComprovante = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelSexo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelInfo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelNo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelAtencao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/logo_comprovante.png"))); // NOI18N

        cabecalho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabecalho.setText("SUPER LOJA FICTÍCIA LTDA");

        cabecalho1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cabecalho1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabecalho1.setText("COMPROVANTE DE TRANSAÇÃO");

        tabelaComprovante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME DO PRODUTO", "PREÇO", "QUANTIDADE", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaComprovante);

        jLabel4.setText("Cliente:");

        labelCliente.setText("[NOME]");

        jLabel3.setText("Sexo:");

        labelSexo.setText("[SEXO]");

        jLabel6.setText("Data Saída:");

        labelData.setText("[DATA]");

        jLabel7.setText("Valor do Documento:");

        labelValor.setText("[VALOR]");

        jLabel9.setText("Endereço de Entrega:");

        labelEndereco.setText("[ENDEREÇO]");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("-FIM DO DOCUMENTO-");

        labelInfo.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        labelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfo.setText("Você poderá rever este documento a qualquer momento em Minha Conta > Meus pedidos.");

        jLabel13.setText("Doc. No:");

        labelNo.setText("[NUMERO]");

        jLabel8.setText("email:");

        labelEmail.setText("[EMAIL]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cabecalho1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(labelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(labelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelSexo)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelNo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelData))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelEmail))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNo)
                            .addComponent(jLabel6)
                            .addComponent(labelData)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelCliente)
                    .addComponent(jLabel8)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelSexo)
                    .addComponent(jLabel7)
                    .addComponent(labelValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEndereco)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelAtencao.setText("<html><body><center>ATENÇÃO, ESTE DOCUMENTO SERVE APENAS PARA CONFERÊNCIA, NÃO PODENDO SER UTILIZADO COMO DOCUMENTO FISCAL.</center></body></html>");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/atencao.png"))); // NOI18N

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAtencao, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAtencao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    
    public void preencherTabela (int idUsuario, int idPedido, int operacao) {
        if (operacao==1) {
            pegaDadosPedido(idUsuario, idPedido);
            pegaDadosPessoais(idUsuario);
            preencheDemaisDados(idUsuario, idPedido);
        }
        else {
            labelInfo.setVisible(false);
            pegaDadosPessoais(idUsuario);
            pegaDadosPedido(idUsuario, idPedido);
            preencheDemaisDados(idUsuario, idPedido);
        }        
    }
    
    public void pegaDadosPessoais(int idUsuario) {
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement("SELECT nome, email, endereco, cidade_estado, sexo FROM pessoa WHERE id_pessoa = ?");
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                labelCliente.setText(rs.getString(1));
                labelEmail.setText(rs.getString(2));
                labelEndereco.setText(rs.getString(3)+", "+rs.getString(4));
                if (rs.getString(5).equals("M")) {
                    labelSexo.setText("Masculino");
                }
                else {
                    labelSexo.setText("Feminino");
                }
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void pegaDadosPedido (int idUsuario, int idPedido) {
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement("SELECT data, valor_total FROM pedido WHERE id_pessoa = ? AND id_pedido = ?");
            st.setInt(1, idUsuario);
            st.setInt(2, idPedido);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                labelNo.setText(new Controle().tratarNumeroPedido(idPedido));
                labelData.setText(String.valueOf(rs.getDate(1)).replace("-", "/"));
                labelValor.setText(new Controle().retornaValorFormatado(String.valueOf(rs.getFloat(2))));
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void preencheDemaisDados (int idUsuario, int idPedido) {
        try {
            String query = "SELECT P.id_pedido, P.id_pessoa, PP.quantidade, V.nome_produto, V.preco_venda FROM pedido AS P INNER ";
            query = query+"JOIN pedido_produto AS PP ON P.id_pedido = PP.id_pedido INNER JOIN produto AS V ON V.id_produto = PP.id_produto";
            PreparedStatement st = Conexao.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1)==idPedido) {
                    if(rs.getInt(2)==idUsuario) {
                        DefaultTableModel tabelaComprovanteModel = (DefaultTableModel) tabelaComprovante.getModel();
                        tabelaComprovanteModel.addRow(new String[] {rs.getString(4),new Controle().retornaValorFormatado(String.valueOf(rs.getFloat(5))), String.valueOf(rs.getInt(3)), new Controle().retornaValorFormatado(String.valueOf(((float)rs.getInt(3))*rs.getFloat(5)))});
                    }
                }
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel cabecalho;
    private javax.swing.JLabel cabecalho1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAtencao;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelNo;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JTable tabelaComprovante;
    // End of variables declaration//GEN-END:variables
}