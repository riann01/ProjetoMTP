package autenticar;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Cadastrar extends javax.swing.JFrame {
    {        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Não foi possível alterar o LookAndFeel");
            e.printStackTrace();
        }
    }
    public Cadastrar() {
        super("Cadastrar");
        initComponents();
        mudarFonte();
        this.getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Foto/IFSULDEMINAS_vertical.png")));
        setLocationRelativeTo(null);
        setVisible(true);
        mudar_foto.setVisible(false);
        
    }
    
    public void mudarFonte() {
        Controle ctr = new Controle();
        jLabel7.setFont(ctr.mudaFonte(36));
        labelSexo.setFont(ctr.mudaFonte(12));
        cbSexo.setFont(ctr.mudaFonte(12));
        labelNome.setFont(ctr.mudaFonte(12));
        nome.setFont(ctr.mudaFonte(12));
        labelEmail.setFont(ctr.mudaFonte(12));
        email.setFont(ctr.mudaFonte(12));
        labelEndereco.setFont(ctr.mudaFonte(12));
        endereco.setFont(ctr.mudaFonte(12));
        labelCidade.setFont(ctr.mudaFonte(12));
        cidade.setFont(ctr.mudaFonte(12));
        labelSenha.setFont(ctr.mudaFonte(12));
        senha.setFont(ctr.mudaFonte(12));
        labelConfirma.setFont(ctr.mudaFonte(12));
        confirmaSenha.setFont(ctr.mudaFonte(12));
        btnCadastrar.setFont(ctr.mudaFonte(12));
        btnCancelar.setFont(ctr.mudaFonte(12));
    }
    
    public String verificarNome() {
        String msg = new String("");
        if (nome.getText().equals("") || nome.getText().equals(" ")) {
            msg = "O nome não pode ficar vazio";
        }
        else {
            if (nome.getText().length()<10) {
                msg = "Digite seu nome completo";
            }
        }
        return msg;
    }
    
    public String verificarEmail() {
        boolean T = false;
        String msg = new String("");
        if (email.getText().equals("") || email.getText().equals(" ")) {
            msg = "O email não pode ficar vazio";
        }
        else {
            for (int i = 0; i < email.getText().length(); i++) {
                if ((email.getText().charAt(i)=='@')){
                    T = true;
                    break;
                }
            }
            if (email.getText().length()<10) {
                msg = "Esse não parece ser um email válido";
                T = false;
            }
        }
        if (T) {
            return "";
        }
        else {
            return msg;
        }
    }
    
    public String verificarEndereco() {
        String msg = new String("");
        if (endereco.getText().equals("") || endereco.getText().equals(" ")) {
            msg = "O endereço não pode ficar vazio";
        }
        else {
            if (endereco.getText().length() < 8) {
                msg = "Esse não parece um endereço válido";
            }
        }
        return msg;
    }
    
    public String verificarCidade() {
        String msg = new String("");
        if (cidade.getText().equals("") || cidade.getText().equals(" ")) {
            msg = "A cidade não pode ficar vazia";
        }
        else {
            if (cidade.getText().length() < 7) {
                msg = "Esse não parece uma cidade válida";
            }
        }
        return msg;
    }
    
    public String verificarSenha() {
        String msg = new String("");
        if ((new String(senha.getPassword())).equals("") || new String(senha.getPassword()).equals(" ")) {
            msg = "A senha não pode ficar vazia";
        }
        else {
            if ((new String(senha.getPassword())).length() < 7) {
                msg = "A senha deve ter pelo menos 7 caracteres";
            }
            else {
                if (new String(confirmaSenha.getPassword()).equals("") || new String(confirmaSenha.getPassword()).equals(" ")) {
                    msg = "Por favor, confirme a sua senha corretamente";
                }
                if (!(new String(confirmaSenha.getPassword()).equals(new String(senha.getPassword())))) {
                    msg = "As senhas não conhecidem, por favor corrija";
                }
            }
        }
        return msg;
    }
    
    public boolean validar() {
        boolean T = true;
        if (!(verificarNome().equals(""))) {
            JOptionPane.showMessageDialog(null, verificarNome(), "Erro", JOptionPane.ERROR_MESSAGE);
            T = false;
        }
        else {
            if (!(verificarEmail().equals(""))) {
                JOptionPane.showMessageDialog(null, verificarEmail(), "Erro", JOptionPane.ERROR_MESSAGE);
                T = false;
            }
            else {
                if (!(verificarEndereco().equals(""))) {
                    JOptionPane.showMessageDialog(null, verificarEndereco(), "Erro", JOptionPane.ERROR_MESSAGE);
                    T = false;
                }
                else {
                    if (!(verificarCidade().equals(""))) {
                        JOptionPane.showMessageDialog(null, verificarCidade(), "Erro", JOptionPane.ERROR_MESSAGE);
                        T = false;
                    }
                    else {
                        if (!(verificarSenha().equals(""))) {
                            JOptionPane.showMessageDialog(null, verificarSenha(), "Erro", JOptionPane.ERROR_MESSAGE);
                            T = false;
                        }
                    }
                }
            }
        }
        return T;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        quadro_branco = new javax.swing.JLabel();
        mudar_foto = new javax.swing.JLabel();
        foto_usuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        confirmaSenha = new javax.swing.JPasswordField();
        labelNome = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelCidade = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        labelEndereco = new javax.swing.JLabel();
        labelConfirma = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        labelSexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setResizable(false);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CADASTRAR");

        quadro_branco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user_branco.png"))); // NOI18N
        quadro_branco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quadro_brancoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quadro_brancoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quadro_brancoMouseExited(evt);
            }
        });

        mudar_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user_mudarfoto.png"))); // NOI18N

        foto_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autenticar/Foto/user.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelNome.setText("Nome");

        labelEmail.setText("E-mail");

        labelCidade.setText("Cidade/Estado");

        labelSenha.setText("Senha");

        labelEndereco.setText("Endereço");

        labelConfirma.setText("Confirmar Senha");

        labelSexo.setText("Sexo");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSexo, 0, 304, Short.MAX_VALUE)
                    .addComponent(nome)
                    .addComponent(email)
                    .addComponent(endereco)
                    .addComponent(cidade)
                    .addComponent(senha)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSexo)
                            .addComponent(labelNome)
                            .addComponent(labelEmail)
                            .addComponent(labelEndereco)
                            .addComponent(labelCidade)
                            .addComponent(labelSenha)
                            .addComponent(labelConfirma))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(confirmaSenha))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelConfirma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(quadro_branco)
                .addContainerGap(103, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(77, 77, 77))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(mudar_foto)
                    .addContainerGap(103, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(foto_usuario)
                    .addContainerGap(106, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quadro_branco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnCancelar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(mudar_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(437, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(foto_usuario)
                    .addContainerGap(443, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        new FazerLogin();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validar()) {
            if (String.valueOf(cbSexo.getSelectedItem()).equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um sexo.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                Controle controle = new Controle();
                String senha1 = new String(senha.getPassword());
                controle.controleCadastro(email.getText(), senha1, cidade.getText(), endereco.getText(), nome.getText(), getFoto(), String.valueOf(cbSexo.getSelectedItem()));
                if(controle.validoCadastro() == true){
                    JOptionPane.showMessageDialog(null, controle.retornaMensagem());
                    this.dispose();
                    new FazerLogin();
                }
                else{
                    JOptionPane.showMessageDialog(null, controle.retornaMensagem(), "Erro" , JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void quadro_brancoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadro_brancoMouseEntered
        mudar_foto.setVisible(true);
    }//GEN-LAST:event_quadro_brancoMouseEntered

    private void quadro_brancoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadro_brancoMouseExited
        mudar_foto.setVisible(false);
    }//GEN-LAST:event_quadro_brancoMouseExited

    private void quadro_brancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadro_brancoMouseClicked
        JFileChooser fc;
        fc = new JFileChooser();
        ImageIcon foto = new ImageIcon(this.getClass().getResource("Foto/user.png"));
        int retorno = fc.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();
            try {
                BufferedImage imag = ImageIO.read(arquivo);
                if (imag == null) {
                    foto_usuario.setIcon(foto);
                } 
                else {
                    Image image = imag;                    
                    image = image.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(image);
                    foto_usuario.setIcon(icon);
                    setFoto(arquivo);
                }
                pack();
		setLocationRelativeTo(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if (retorno == JFileChooser.CANCEL_OPTION) {
                foto_usuario.setIcon(foto);
                fc.setSelectedFile(arquivo);
            }
        }
    }//GEN-LAST:event_quadro_brancoMouseClicked
    
    public void setFoto (File foto) {
        this.arquivo = foto;
    }
    
    public File getFoto () {
        return this.arquivo;
    }
    
    private File arquivo = new File ("Foto/user.png");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JTextField cidade;
    private javax.swing.JPasswordField confirmaSenha;
    private javax.swing.JTextField email;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel foto_usuario;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelConfirma;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel mudar_foto;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel quadro_branco;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}