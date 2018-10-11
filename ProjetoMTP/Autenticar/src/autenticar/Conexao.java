package autenticar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    
        private String url = "jdbc:postgresql://localhost/mtp";
	
	private String usuario = "postgres";
	
	private String senha = "postgres";
	
	private Connection conn;
	
	public Conexao() {
		conectar();
	}
	
	
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Properties props = new Properties();
		props.setProperty("user", this.usuario);
		props.setProperty("password", this.senha);
		
		try {
			this.conn = DriverManager.getConnection(this.url, props);
		} catch (SQLException e) {
			e.getMessage();
		}

	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void criarTabela() {
		try {
			PreparedStatement st = this.conn.prepareStatement("CREATE TABLE pessoa (id serial primary key, nome text)");
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserir(String nome, String senha, String email, String cidade, String endereco) {
		try {
			PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa (nome, administrador, senha, email, cidade_estado, endereco) VALUES (?, ?, ?, ?, ?, ?)");
			st.setString(1, nome);
                        st.setBoolean(2, false);
                        st.setString(3, senha);
                        st.setString(4, email);
                        st.setString(5, cidade);
                        st.setString(6, endereco);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	public void atualizar() {
		try {
			PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?");
			st.setString(1, "Thiago 2");
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			PreparedStatement st = this.conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
			st.setInt(1, 1);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
    
}