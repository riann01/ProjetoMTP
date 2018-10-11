package autenticar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controle {

    String mensagem;
    Conexao conexao;
    boolean teste = false;
    boolean loginTeste = false;
    boolean administradorTeste = false;
    int idUsuario;
    public String nome;

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

    public void controleCadastro(String email, String senha, String local, String endereco, String nome) {

        PreparedStatement st;

        if (ConsultarExistenteEmail(email)) {

            mensagem = new String("Email já cadastrado!");
            teste = false;

        } else {

            conexao.inserir(nome, senha, email, local, endereco);
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
    
    public void mostraNome () {
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT nome FROM pessoa WHERE id_pessoa = ?");
            st.setInt(1 , idUsuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                this.nome = rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
