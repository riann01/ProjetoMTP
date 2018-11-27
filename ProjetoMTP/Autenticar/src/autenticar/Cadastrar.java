package autenticar;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        quadro_branco = new javax.swing.JLabel();
        mudar_foto = new javax.swing.JLabel();
        foto_usuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        confirmaSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        endereco1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
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

        jLabel2.setText("Nome");

        jLabel3.setText("E-mail");

        jLabel4.setText("Cidade/Estado");

        jLabel5.setText("Senha");

        endereco1.setText("Endereço");

        jLabel6.setText("Confirmar Senha");

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
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(endereco1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
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
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endereco1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
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
                .addGap(61, 61, 61)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(quadro_branco))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(mudar_foto)
                    .addContainerGap(99, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(foto_usuario)
                    .addContainerGap(102, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(mudar_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(415, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(foto_usuario)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new FazerLogin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (String.valueOf(cbSexo.getSelectedItem()).equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um sexo.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Controle controle = new Controle();
            String senha1 = new String(senha.getPassword());
            controle.controleCadastro(email.getText(), senha1, cidade.getText(), endereco.getText(), nome.getText() , getFoto(), String.valueOf(cbSexo.getSelectedItem()));
            if(controle.validoCadastro() == true){
                JOptionPane.showMessageDialog(null, controle.retornaMensagem());
                this.dispose();
                new FazerLogin();
            }
            else{
                JOptionPane.showMessageDialog(null, controle.retornaMensagem(), "Erro" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JTextField cidade;
    private javax.swing.JPasswordField confirmaSenha;
    private javax.swing.JTextField email;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel endereco1;
    private javax.swing.JLabel foto_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel mudar_foto;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel quadro_branco;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}