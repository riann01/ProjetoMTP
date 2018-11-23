package autenticar;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontFormatException;

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
        setLayout(null);
        setVisible(true);
        labelFotoUsuarioMouseEvento.setVisible(false);
        atualizaItens(idUsuario);
        mudaFonte();
        insereCategorias();
        
        //new Propaganda ();
        mostrarTodosOsItens();
        //LabelCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("Foto/carrinho.png")));
    }
    public void deletarDoCarrinho () {
        try {
            PreparedStatement st;
            Conexao conn = new Conexao();
            st = conn.getConnection().prepareStatement("DELETE FROM carrinho");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void atualizaItens (int idPessoa) {
        cont = 0;
        //PreparedStatement st;
        try {
            PreparedStatement st = conexao.getConnection().prepareStatement("SELECT * FROM carrinho WHERE id_pessoa = ?;");
            st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ++cont;
            }
            st.clearBatch();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        labelCarrinho.setFont(new Font("Dialog",mudaFonte().TRUETYPE_FONT, 14));
        labelCarrinho.setText("Carrinho de compras ("+String.valueOf(cont)+")");  
    }
    
    public Font mudaFonte () {
        try {
        font = Font.createFont(Font.TRUETYPE_FONT, new File("Fonte/GoogleSans-Medium.ttf"));
        }
        catch (FontFormatException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.font;
    }
    
    public void insereCategorias () {
        boolean T = false;
        try {
            PreparedStatement ps = this.conexao.getConnection().prepareStatement("SELECT criar_categorias FROM verificador");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                T = rs.getBoolean(1);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (T == false) {
            String insert = "INSERT INTO categoria (nome_categoria) VALUES ('Games');";
            insert = insert+"INSERT INTO categoria (nome_categoria) VALUES ('Eletrodomésticos');";
            insert = insert+"INSERT INTO categoria (nome_categoria) VALUES ('Informática');";
            insert = insert+"INSERT INTO categoria (nome_categoria) VALUES ('Artigos Esportivos');";
            insert = insert+"INSERT INTO categoria (nome_categoria) VALUES ('Lazer');";
            insert = insert+"INSERT INTO categoria (nome_categoria) VALUES ('Smartphones');";
            insert = insert+"INSERT INTO categoria (nome_categoria) VALUES ('TV e vídeo');";
            insert = insert+"INSERT INTO verificador (criar_categorias) VALUES ('true')";
            try {
                PreparedStatement ps = this.conexao.getConnection().prepareStatement(insert);
                ps.executeUpdate();
                ps.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void mostrarCategoria (int id_categoria) {
        int controle1 = 415;
        int contador1 = 0;
        PreparedStatement st;
        
        try {
            st = conexao.getConnection().prepareStatement("SELECT id_produto, nome_produto, descricao, preco_venda, foto FROM produto WHERE id_categoria = ?");
            st.setInt(1,id_categoria);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                contador1++;
                byte[] binario = rs.getBytes(5);
                InputStream is = new ByteArrayInputStream(binario);
                BufferedImage imag = ImageIO.read(is);
                Image image = imag;                    
                image = image.getScaledInstance(236, 135, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                Produto p = new Produto(idUsuario, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), icon);
                painelConteudo.add(p);
                if(contador1%3==0){
                    controle1 += 415;
                }
                painelConteudo.setPreferredSize(new Dimension(800,controle1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listaCategorias.getSelectedValue();
    }
    
    public void mostrarTodosOsItens() {
        int controle1 = 440;
        int contador1 = 0;
        Conexao conexao = new Conexao();
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT id_produto, nome_produto, descricao, preco_venda, foto FROM produto");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                contador1++;
                byte[] binario = rs.getBytes(5);
                InputStream is = new ByteArrayInputStream(binario);
                BufferedImage imag = ImageIO.read(is);
                Image image = imag;                    
                image = image.getScaledInstance(236, 135, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                Produto p = new Produto(idUsuario, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), icon);
                painelConteudo.add(p);
                if(contador1%3==0){
                    controle1 += 440;
                }
                painelConteudo.setPreferredSize(new Dimension(800,controle1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        listaCategorias = new javax.swing.JList<>();
        labelDepartamentos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelFotoUsuario = new javax.swing.JLabel();
        cover = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelConteudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        LabelNomeUsuario.setFont(new java.awt.Font("Google Sans", 0, 18)); // NOI18N
        LabelNomeUsuario.setText("Olá, usuário!");

        LabelMinhaConta.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        LabelMinhaConta.setText("Minha conta >");
        LabelMinhaConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelMinhaConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelMinhaContaMouseClicked(evt);
            }
        });

        LabelSair.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        LabelSair.setText("Sair");
        LabelSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelSairMouseClicked(evt);
            }
        });

        textFieldPesquisa.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        textFieldPesquisa.setText("Pesquisar...");

        botaoIr.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        botaoIr.setText("Ir");
        botaoIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIrActionPerformed(evt);
            }
        });

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

        labelCarrinho.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        labelCarrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCarrinho.setText("Carrinho de Compras (0)");

        labelAcessar.setFont(new java.awt.Font("Google Sans", 0, 11)); // NOI18N
        labelAcessar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAcessar.setText("Acessar >");
        labelAcessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAcessarMouseClicked(evt);
            }
        });

        listaCategorias.setFont(new java.awt.Font("Google Sans", 0, 15)); // NOI18N
        listaCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todos", "Informática", "Eletrodomésticos", "Artigos Esportivos", "Games", "Lazer", "Smartphones", "TV e vídeo", "..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaCategorias);

        labelDepartamentos.setFont(new java.awt.Font("Google Sans", 0, 18)); // NOI18N
        labelDepartamentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDepartamentos.setText("Departamentos");

        jLabel2.setFont(new java.awt.Font("Google Sans", 0, 11)); // NOI18N
        jLabel2.setText("Excluir Tudo");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelConteudo.setMaximumSize(new java.awt.Dimension(800, 800));
        painelConteudo.setMinimumSize(new java.awt.Dimension(800, 800));
        painelConteudo.setPreferredSize(new java.awt.Dimension(800, 800));
        painelConteudo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                painelConteudoMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(painelConteudo);
        painelConteudo.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labelFotoUsuarioMouseEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDepartamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelMinhaConta)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(LabelSair)))
                                .addGap(64, 64, 64))
                            .addComponent(LabelNomeUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoIr, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCarrinho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelAcessar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(66, 66, 66)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(LabelCarrinho)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(cover)
                    .addContainerGap(835, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(830, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldPesquisa)
                                        .addComponent(LabelNomeUsuario))
                                    .addComponent(botaoIr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelMinhaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LabelSair))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelFotoUsuarioMouseEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelCarrinho)
                        .addGap(15, 15, 15)
                        .addComponent(labelCarrinho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAcessar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDepartamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(cover, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 490, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 494, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void LabelMinhaContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelMinhaContaMouseClicked
        this.dispose();
        new AlterarDados(idUsuario);
    }//GEN-LAST:event_LabelMinhaContaMouseClicked

    private void LabelSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSairMouseClicked
        this.dispose();
        new Logar(true);
    }//GEN-LAST:event_LabelSairMouseClicked

    private void LabelCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCarrinhoMouseClicked
        new Carrinho(idUsuario).setVisible(true);
    }//GEN-LAST:event_LabelCarrinhoMouseClicked

    private void labelAcessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAcessarMouseClicked
        new Carrinho(idUsuario).setVisible(true);
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        deletarDoCarrinho();
        atualizaItens(idUsuario);
        JOptionPane.showMessageDialog(null , "Agora o carrinho está vazio." , "Informação" , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void botaoIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIrActionPerformed
        int controle1 = 500;
        int contador1 = 0;
        String pesquisa = "%"+textFieldPesquisa.getText()+"%";
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT id_produto, nome_produto, descricao, preco_venda, foto FROM produto WHERE nome_produto like ? OR descricao like ?");
            st.setString(1, pesquisa);
            st.setString(2, pesquisa);
            ResultSet rs = st.executeQuery();
            painelConteudo.removeAll();
            while (rs.next()) {                
                contador1++;
                byte[] binario = rs.getBytes(5);
                InputStream is = new ByteArrayInputStream(binario);
                BufferedImage imag = ImageIO.read(is);
                Image image = imag;                    
                image = image.getScaledInstance(236, 135, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                Produto p = new Produto(idUsuario, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), icon);
                painelConteudo.add(p);
                if(contador1%3==0){ 
                    controle1 += 500;
                }
                painelConteudo.setPreferredSize(new Dimension(800,controle1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_botaoIrActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_formFocusGained

    private void painelConteudoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelConteudoMouseMoved
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_painelConteudoMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        painelConteudo.revalidate();
        atualizaItens(idUsuario);
    }//GEN-LAST:event_formMouseMoved

    private void listaCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCategoriasValueChanged
        painelConteudo.removeAll();
        painelConteudo.revalidate();
        if (listaCategorias.getSelectedValue().equals("Todos")) {
            mostrarTodosOsItens();
        }
        else {
            mostrarCategoria(new Controle().pegaIdCategorias(listaCategorias.getSelectedValue()));
            painelConteudo.revalidate();
        }
    }//GEN-LAST:event_listaCategoriasValueChanged

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_formMouseExited

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
    private Font font;
    Conexao conexao = new Conexao();
    int idUsuario;
    int cont = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCarrinho;
    private javax.swing.JLabel LabelMinhaConta;
    private javax.swing.JLabel LabelNomeUsuario;
    private javax.swing.JLabel LabelSair;
    private javax.swing.JButton botaoIr;
    private javax.swing.JLabel cover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAcessar;
    private javax.swing.JLabel labelCarrinho;
    private javax.swing.JLabel labelDepartamentos;
    private javax.swing.JLabel labelFotoUsuario;
    private javax.swing.JLabel labelFotoUsuarioMouseEvento;
    private javax.swing.JList<String> listaCategorias;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JTextField textFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
