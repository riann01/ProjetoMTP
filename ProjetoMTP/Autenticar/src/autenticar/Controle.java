package autenticar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.InputStream;

public class Controle {
    String mensagem;
    Conexao conexao;
    boolean teste = false;
    boolean loginTeste = false;
    boolean administradorTeste = false;
    int idUsuario;
    private String nome;
    File foto;
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
                } else {
                    T = false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return T;
    }

    public void controleCadastro(String email, String senha, String local, String endereco, String nome , File foto) {
        PreparedStatement st;
        if (ConsultarExistenteEmail(email)) {
            mensagem = new String("Email já cadastrado!");
            teste = false;
        } 
        else {
            conexao.inserir(nome, senha, email, local, endereco, foto);
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
    
    /*public File mostraFoto (int idUsuario) {
        InputStream is;
        File foto;
        Conexao conn = new Conexao ();
        PreparedStatement st;
        
        try {
            st = conn.getConnection().prepareStatement("SELECT foto, id_pessoa FROM pessoa");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(2)==idUsuario) {
                    is = rs.getBinaryStream(1);
                    is.
                }
            }
        }
        catch (SQLException e) {  
        }
    }*/
    
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
    
    public void setFoto (File foto) {
        this.foto = foto;
    }
    
    public File getFoto () {
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
    
}