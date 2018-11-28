package autenticar;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.FileNotFoundException;

public class Controle {
    String mensagem;
    Conexao conexao;
    boolean teste = false;
    boolean loginTeste = false;
    boolean administradorTeste = false;
    int idUsuario;
    private String nome;
    private ImageIcon foto;
    private int cont;
    private double total;
    private Font fonte;
    
    public Controle() {
        conexao = new Conexao();
    }
    
    public boolean ConsultarExistenteEmail(String email) {
        boolean T = false;
        try {
            PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM pessoa WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String emaildois = rs.getString("email");
                if ((email.equals(emaildois))) {
                    T = true;
                }
                else {
                    T = false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return T;
    }

    public void controleCadastro(String email, String senha, String local, String endereco, String nome , File foto, String sexo) {
        String sexoSelecao;
        if (sexo.equals("Masculino")) {
            sexoSelecao = "M";
        }
        else {
            sexoSelecao = "F";
        }
        if (ConsultarExistenteEmail(email)) {
            mensagem = new String("Email já cadastrado!");
            teste = false;
        } 
        else {
            conexao.inserir(nome, senha, email, local, endereco, foto, sexoSelecao);
            mensagem = new String("Cadastrado com sucesso");
            teste = true;
        }
    }

    public void controleLogin(String login, String senha) {
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT email, senha, administrador, id_pessoa FROM pessoa");
            ResultSet rs = st.executeQuery();
            mensagem = new String("Email ou senha incorretos!");
            while (rs.next()) {
                if (login.equalsIgnoreCase(rs.getString(1)) && senha.equals(rs.getString(2))) {
                    mensagem = new String("Login efetuado com sucesso!");
                    loginTeste = true;
                    idUsuario = rs.getInt(4);
                    if(rs.getBoolean(3) == true){
                        administradorTeste = true;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mudarFoto (int id, File foto) {
        Conexao conn = new Conexao();
        PreparedStatement st;
        try {
            FileInputStream fis = new FileInputStream(foto);
            st = conn.getConnection().prepareStatement("UPDATE pessoa SET foto = ? WHERE id_pessoa = ?");
            st.setBinaryStream(1, fis, (int) foto.length());
            st.setInt(2, id);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e , "Erro" , JOptionPane.ERROR_MESSAGE);
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e , "Erro" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void pegaFoto (int id) {
        Conexao conn = new Conexao();
        PreparedStatement st;
        try {
            st = conn.getConnection().prepareStatement("SELECT foto, id_pessoa FROM pessoa");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (id==rs.getInt(2)) {
                    byte[] binario = rs.getBytes(1);
                    InputStream is = new ByteArrayInputStream(binario);
                    BufferedImage imag = ImageIO.read(is);
                    Image image = imag;                    
                    image = image.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(image);
                    setFoto(icon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String mostraNome (int idUsuario) {
        
        String nome1 = new String();
        Conexao conexao = new Conexao();
        PreparedStatement st;
        
        try {
            st = conexao.getConnection().prepareStatement("SELECT nome, id_pessoa FROM pessoa");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(2)==idUsuario) {
                    
                    nome1 = rs.getString(1);
                    
                    }  
                }
        } catch (SQLException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nome1;
    }
    
    public void getId (String email) {
        String nome;
        PreparedStatement stmt;
        try {
            stmt = conexao.getConnection().prepareStatement("SELECT id_pessoa FROM pessoa WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                this.idUsuario = rs.getInt("id_pessoa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void getNome (int id) {
        PreparedStatement stmt;
        try {
            stmt = conexao.getConnection().prepareStatement("SELECT nome FROM pessoa WHERE id_pessoa = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String pegaSexo (int idUsuario) {
        PreparedStatement st;
        String sexo = "";
        try {
            st = this.conexao.getConnection().prepareStatement("SELECT sexo FROM pessoa WHERE id_pessoa = ?");
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sexo = rs.getString(1);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return sexo;
    }
    
    public void mostrarItens () {
        PreparedStatement st;
        Conexao conexao = new Conexao();
        try {
            st = conexao.getConnection().prepareStatement("SELECT *FROM carrinho");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ++this.cont;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int pegaIdCategorias (Object cat) {
        String catCasting = String.valueOf(cat);
        int id_categoria = 0;
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT id_categoria FROM categoria WHERE nome_categoria = ?");
            st.setString(1, catCasting);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                id_categoria = rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id_categoria;
    }
    
    public String [] pegaModeloCat() {
        String model = "";
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT nome_categoria FROM categoria");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                model = rs.getString(1)+"/"+model;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String arrayModel [] = model.split("/");
        return arrayModel;
    }

    public void corrigirDualidades (int idProduto, int idUsuario, int quantidade) {
        int quantidadeum = 0;
        float precoTotal = 0;
        try {
            PreparedStatement ps = this.conexao.getConnection().prepareStatement("SELECT quantidade FROM carrinho WHERE id_produto = ? AND id_pessoa = ?");
            ps.setInt(1, idProduto);
            ps.setInt(2, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ++quantidadeum;
            }
            rs.close();
            ps.close();
            ps = this.conexao.getConnection().prepareStatement("SELECT preco_venda FROM produto WHERE id_produto = ?");
            ps.setInt(1, idProduto);
            rs = ps.executeQuery();
            if (rs.next()) {
                precoTotal = rs.getFloat(1);
            }
            rs.close();
            ps.close();
            if (quantidadeum==0) {
                conexao.inserirProdutoCarrinho(idUsuario, idProduto, quantidade, precoTotal);
            }
            else {
                ps = this.conexao.getConnection().prepareStatement("UPDATE carrinho SET quantidade = quantidade+? WHERE id_produto = ? AND id_pessoa = ?");
                ps.setInt(1, quantidade);
                ps.setInt(2, idProduto);
                ps.setInt(3, idUsuario);
                ps.executeUpdate();
                ps.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Font mudaFonte (int tamanho) {
        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("Fonte/GoogleSans-Regular.ttf"))).deriveFont(0, tamanho);
        }
        catch (FontFormatException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.fonte;
    }
        
    public String retornaValorFormatado (String valor) {
        valor = valor.replace("."," ");
        String separador [] = valor.split(" ");
        if (Integer.parseInt(separador[0])<10) {
            separador[0] = "0"+separador[0];
        }
        if (separador[1].length()==1) {
            separador[1] = separador[1]+"0";
        }
        String retorno = "R$"+separador[0]+","+separador[1];
        return retorno;
    }
    public int getCont() {
        return this.cont;
    }
    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
    public ImageIcon getFoto () {
        return this.foto;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getNome () {
        return this.nome;
    }

    public String retornaMensagem() {
        return mensagem;
    }

    public boolean validoCadastro() {
        return teste;
    }

    public boolean validoLogin() {
        return loginTeste;
    }
    
    public boolean administrador() {
        return administradorTeste;
    }
    
    public int retornaId(){
        return idUsuario;
    }
    
    public void setTotal (double total) {
        this.total = total;
    }
    
    public double getTotal () {
        return this.total;
    }
}