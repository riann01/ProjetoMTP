package autenticar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        
        public void inserirProduto(Double id, String nome, String descricao, Float preco_custo, Float preco_venda, File arquivo) {
		try {
                        FileInputStream fis = new FileInputStream(arquivo);
			PreparedStatement st = this.conn.prepareStatement("INSERT INTO produto (id_produto, nome_produto, descricao, preco_custo, preco_venda, foto) VALUES (?, ?, ?, ?, ?, ?)");
			st.setDouble(1, id);
                        st.setString(2, nome);
                        st.setString(3, descricao);
                        st.setFloat(4, preco_custo);
                        st.setFloat(5, preco_venda);
                        st.setBinaryStream(6, fis, (int) arquivo.length());
                        //st.setBinaryStream();
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(int id, String nome, String cidade, String endereco, String senha) {
		try {
			PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?, cidade_estado = ?, endereco = ?, senha = ? WHERE id_pessoa=?");
			st.setString(1, nome);
                        st.setString(2, cidade);
                        st.setString(3, endereco);
                        st.setString(4, senha);
                        st.setInt(5, id);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
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