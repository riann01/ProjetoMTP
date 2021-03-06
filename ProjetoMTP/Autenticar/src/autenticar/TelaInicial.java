package autenticar;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class TelaInicial extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public TelaInicial(int id, boolean administrador) {
        super ("Super Loja Fictícia");
        this.idUsuario = id;
        mostraIcones();
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
        mostrarTodosOsItens();
        insereCategorias();
        alterarFonte();
        verificaAdministrador(administrador);
        botaoIr.requestFocus();
        inserirModelo();
        listaCategorias.setSelectedIndex(0);
        jScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
    }
    
    public void deletarDoCarrinho () {
        try {
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement("DELETE FROM carrinho");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void atualizaItens (int idPessoa) {
        cont = 0;
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement("SELECT * FROM carrinho WHERE id_pessoa = ?;");
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
        labelCarrinho.setText("Carrinho de compras ("+String.valueOf(cont)+")");  
    }
    
    public void insereCategorias () {
        boolean T = false;
        try {
            PreparedStatement ps = Conexao.getConnection().prepareStatement("SELECT criar_categorias FROM verificador");
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
                PreparedStatement ps = Conexao.getConnection().prepareStatement(insert);
                ps.executeUpdate();
                ps.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void mostrarCategoria (int id_categoria) {
        int controle1 = 440;
        int contador1 = 0;
        PreparedStatement st;
        try {
            st = Conexao.getConnection().prepareStatement("SELECT id_produto, nome_produto, descricao, preco_venda, foto FROM produto WHERE id_categoria = ?");
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
                    controle1 += 440;
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
        int controle1 = 455;
        int contador1 = 0;
        PreparedStatement st;
        try {
            st = Conexao.getConnection().prepareStatement("SELECT id_produto, nome_produto, descricao, preco_venda, foto FROM produto");
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
                    controle1 += 455;
                }
                painelConteudo.setPreferredSize(new Dimension(800,controle1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostraIcones () {
        carrinho = new ImageIcon(getClass().getResource("Foto/carrinho.png"));
    }
    
    public void alterarFonte () {
        Controle ctr = new Controle();
        labelCarrinho.setFont(ctr.mudaFonte(14));
        LabelMinhaConta.setFont(ctr.mudaFonte(14));
        LabelNomeUsuario.setFont(ctr.mudaFonte(18));
        LabelSair.setFont(ctr.mudaFonte(14));
        botaoIr.setFont(ctr.mudaFonte(14));
        admPainel.setFont(ctr.mudaFonte(18));
        jLabel2.setFont(ctr.mudaFonte(12));
        textFieldPesquisa.setFont(ctr.mudaFonte(14));
        listaCategorias.setFont(ctr.mudaFonte(15));
        labelDepartamentos.setFont(ctr.mudaFonte(15));
        labelAcessar.setFont(ctr.mudaFonte(12));
        labelMostrandoAgora.setFont(ctr.mudaFonte(18));
    }
    
    public void verificaAdministrador (boolean administrador1) {
        if (administrador1==true) {
            admPainel.setVisible(true);
        }
        else {
            admPainel.setVisible(false);
        }
    }
    
    public void inserirModelo () {
        listaCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = controle.pegaModeloCat();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    
    public void pesquisar() {
        listaCategorias.clearSelection();
        jScrollPane2.revalidate();
        painelConteudo.removeAll();
        int contador = 0;
        int controle1 = 500;
        int contador1 = 0;
        if (textFieldPesquisa.getText().equals("Pesquisar...")) {
            JOptionPane.showMessageDialog(null, "Insira algum termo para pesquisar", "Barra de Pesquisa", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (textFieldPesquisa.getText().length()<2) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um termo com pelo menos dois caracteres para pesquisar", "Barra de Pesquisa", JOptionPane.INFORMATION_MESSAGE);
                textFieldPesquisa.setText("Pesquisar...");
            }
            else {
                String pesquisa = "%"+textFieldPesquisa.getText()+"%";
                labelMostrandoAgora.setText("Mostrando Resultados da Pesquisa para \""+textFieldPesquisa.getText()+"\"");
                PreparedStatement st;
                try {
                    st = Conexao.getConnection().prepareStatement("SELECT id_produto, nome_produto, descricao, preco_venda, foto FROM produto WHERE nome_produto ilike ? OR descricao ilike ?");
                    st.setString(1, pesquisa);
                    st.setString(2, pesquisa);
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        ++contador;
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
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                painelConteudo.revalidate();
                if (contador==0) {
                    labelMostrandoAgora.setText("Nenhum resultado de pesquisa para o termo \""+textFieldPesquisa.getText()+"\"");
                }
                painelConteudo.revalidate();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNomeUsuario = new javax.swing.JLabel();
        LabelMinhaConta = new javax.swing.JLabel();
        LabelSair = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelCarrinho = new javax.swing.JLabel();
        labelFotoUsuarioMouseEvento = new javax.swing.JLabel();
        labelCarrinho = new javax.swing.JLabel();
        labelAcessar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList<>();
        labelDepartamentos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelFotoUsuario = new javax.swing.JLabel();
        cover = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelConteudo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textFieldPesquisa = new javax.swing.JTextField();
        botaoIr = new javax.swing.JButton();
        admPainel = new javax.swing.JLabel();
        labelMostrandoAgora = new javax.swing.JLabel();

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

        LabelCarrinho.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        LabelCarrinho.setIcon(carrinho);
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

        labelAcessar.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        labelAcessar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAcessar.setText("Acessar >");
        labelAcessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAcessarMouseClicked(evt);
            }
        });

        jScrollPane1.setBorder(null);

        listaCategorias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listaCategorias.setFont(new java.awt.Font("Google Sans", 0, 15)); // NOI18N
        listaCategorias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todos", "Informática", "Eletrodomésticos", "Artigos Esportivos", "Games", "Lazer", "Smartphones", "TV e vídeo" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaCategorias.setSelectionBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.disabledForeground"));
        listaCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaCategorias);

        labelDepartamentos.setFont(new java.awt.Font("Google Sans", 0, 18)); // NOI18N
        labelDepartamentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDepartamentos.setText("Departamentos");

        jLabel2.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Excluir Tudo");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        labelFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user.png"))); // NOI18N

        cover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user_branco.png"))); // NOI18N
        cover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                coverMouseExited(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        painelConteudo.setBackground(new java.awt.Color(255, 255, 255));
        painelConteudo.setMaximumSize(new java.awt.Dimension(800, 440));
        painelConteudo.setMinimumSize(new java.awt.Dimension(800, 440));
        painelConteudo.setPreferredSize(new java.awt.Dimension(800, 440));
        painelConteudo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                painelConteudoMouseMoved(evt);
            }
        });
        painelConteudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                painelConteudoMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(painelConteudo);
        painelConteudo.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textFieldPesquisa.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        textFieldPesquisa.setText("Pesquisar...");
        textFieldPesquisa.setVerifyInputWhenFocusTarget(false);
        textFieldPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldPesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldPesquisaFocusLost(evt);
            }
        });
        textFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldPesquisaKeyPressed(evt);
            }
        });

        botaoIr.setFont(new java.awt.Font("Google Sans", 0, 14)); // NOI18N
        botaoIr.setText("Ir");
        botaoIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoIr, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textFieldPesquisa)
                .addComponent(botaoIr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        admPainel.setFont(new java.awt.Font("Google Sans", 0, 18)); // NOI18N
        admPainel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admPainel.setText("Painel do Administrador >");
        admPainel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admPainel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admPainelMouseClicked(evt);
            }
        });

        labelMostrandoAgora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMostrandoAgora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMostrandoAgora.setText("Mostrando agora:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labelFotoUsuarioMouseEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDepartamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(LabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelMinhaConta)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(LabelSair)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(admPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(143, 143, 143))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(labelMostrandoAgora, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(LabelCarrinho)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(labelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(labelAcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(61, 61, 61))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(cover)
                    .addContainerGap(848, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(843, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNomeUsuario)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelMinhaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LabelSair))
                                    .addComponent(admPainel))
                                .addGap(35, 35, 35))
                            .addComponent(labelFotoUsuarioMouseEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelMostrandoAgora, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelCarrinho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCarrinho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelAcessar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDepartamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
        new MinhaConta(idUsuario);
    }//GEN-LAST:event_LabelMinhaContaMouseClicked

    private void LabelSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSairMouseClicked
        this.dispose();
        new Logar();
    }//GEN-LAST:event_LabelSairMouseClicked

    private void LabelCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCarrinhoMouseClicked
        new Carrinho(idUsuario).setVisible(true);
    }//GEN-LAST:event_LabelCarrinhoMouseClicked

    private void labelAcessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAcessarMouseClicked
        new Carrinho(idUsuario).setVisible(true);
    }//GEN-LAST:event_labelAcessarMouseClicked

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        deletarDoCarrinho();
        atualizaItens(idUsuario);
        JOptionPane.showMessageDialog(null , "Agora o carrinho está vazio." , "Informação" , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void botaoIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIrActionPerformed
        pesquisar();
    }//GEN-LAST:event_botaoIrActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        atualizaItens(idUsuario);
    }//GEN-LAST:event_formFocusGained

    private void painelConteudoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelConteudoMouseMoved
        atualizaItens(idUsuario);
    }//GEN-LAST:event_painelConteudoMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        atualizaItens(idUsuario);
    }//GEN-LAST:event_formMouseMoved

    private void listaCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCategoriasValueChanged
        jScrollPane2.revalidate();
        painelConteudo.removeAll();
        if (listaCategorias.getSelectedValue()!=null) {
            if (listaCategorias.getSelectedValue().equals("Todos")) {
                mostrarTodosOsItens();
                labelMostrandoAgora.setText("Mostrando Todos os Itens");
            }
            else {
                mostrarCategoria(new Controle().pegaIdCategorias(listaCategorias.getSelectedValue()));
                labelMostrandoAgora.setText("Mostrando "+listaCategorias.getSelectedValue());
            }
        }
        painelConteudo.validate();
    }//GEN-LAST:event_listaCategoriasValueChanged

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_formMouseExited

    private void painelConteudoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelConteudoMouseEntered
        atualizaItens(idUsuario);
        painelConteudo.revalidate();
    }//GEN-LAST:event_painelConteudoMouseEntered

    private void admPainelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admPainelMouseClicked
        this.dispose();
        new PainelAdmin(idUsuario);
    }//GEN-LAST:event_admPainelMouseClicked

    private void textFieldPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPesquisaFocusGained
        if (textFieldPesquisa.getText().equals("Pesquisar...")) {
            textFieldPesquisa.setText("");
        }
    }//GEN-LAST:event_textFieldPesquisaFocusGained

    private void textFieldPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldPesquisaFocusLost
        if(textFieldPesquisa.getText().equals("")) {
            textFieldPesquisa.setText("Pesquisar...");
        }
    }//GEN-LAST:event_textFieldPesquisaFocusLost

    private void textFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisar();
        }
    }//GEN-LAST:event_textFieldPesquisaKeyPressed

    public static void main(String args[]) throws IllegalAccessException {
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
    }
    
    public javax.swing.JPanel getPainel () {
        return this.painelConteudo;
    }
    
    Controle controle = new Controle();
    private ImageIcon carrinho;
    int idUsuario;
    int cont = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCarrinho;
    private javax.swing.JLabel LabelMinhaConta;
    private javax.swing.JLabel LabelNomeUsuario;
    private javax.swing.JLabel LabelSair;
    private javax.swing.JLabel admPainel;
    private javax.swing.JButton botaoIr;
    private javax.swing.JLabel cover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAcessar;
    private javax.swing.JLabel labelCarrinho;
    private javax.swing.JLabel labelDepartamentos;
    private javax.swing.JLabel labelFotoUsuario;
    private javax.swing.JLabel labelFotoUsuarioMouseEvento;
    private javax.swing.JLabel labelMostrandoAgora;
    private javax.swing.JList<String> listaCategorias;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JTextField textFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}