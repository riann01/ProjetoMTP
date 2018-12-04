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
    private String senha = "ifg";
    private Connection conn;
    
    public Conexao() {
        conectar();
    }
    
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }		
        Properties props = new Properties();
        props.setProperty("user", this.usuario);
        props.setProperty("password", this.senha);
        try {
            this.conn = DriverManager.getConnection(this.url, props);
        }
        catch (SQLException e) {
            e.getMessage();
        }
    }
	
    public Connection getConnection() {
        return this.conn;
    }
	
    public void inserir(String nome, String senha, String email, String cidade, String endereco, File foto, String sexo) {
        try {
            FileInputStream fis = new FileInputStream(foto);
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa (nome, email, cidade_estado, endereco, senha, administrador, foto, sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, nome);
            st.setString(2, email);
            st.setString(3, cidade);
            st.setString(4, endereco);
            st.setString(5, senha);
            st.setBoolean(6, false);
            st.setBinaryStream(7, fis, (int) foto.length());
            st.setString(8, sexo);
            st.executeUpdate();
            st.close();
            fis.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public void inserirProduto(String nome, String descricao, Float preco_custo, Float preco_venda, File arquivo, int id_categoria) {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO produto (nome_produto, descricao, preco_custo, preco_venda, foto, id_categoria) VALUES (?, ?, ?, ?, ?, ?)");
            st.setString(1, nome);
            st.setString(2, descricao);
            st.setFloat(3, preco_custo);
            st.setFloat(4, preco_venda);
            st.setBinaryStream(5, fis, (int) arquivo.length());
            st.setInt(6, id_categoria);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
     public void atualizarProduto(String nome, String descricao, Float preco_custo, Float preco_venda, File arquivo, int id_categoria, int id_produto) {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            PreparedStatement st = this.conn.prepareStatement("UPDATE produto SET nome_produto = ?, descricao = ?, preco_custo = ?, preco_venda = ?, foto = ?, id_categoria = ? WHERE id_produto = ?");
            st.setString(1, nome);
            st.setString(2, descricao);
            st.setFloat(3, preco_custo);
            st.setFloat(4, preco_venda);
            st.setBinaryStream(5, fis, (int) arquivo.length());
            st.setInt(6, id_categoria);
            st.setInt(7, id_categoria);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        
    public void inserirProdutoCarrinho(int idUsuario, int idProduto, int quantidade) {
        try {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO carrinho (id_pessoa, id_produto, quantidade) VALUES (?, ?, ?)");
            st.setInt(1, idUsuario);
            st.setInt(2, idProduto);   
            st.setInt(3, quantidade);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void atualizar(int id, String nome, String cidade, String endereco, String senha) {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?, cidade_estado = ?, endereco = ?, senha = ? WHERE id_pessoa = ?");
            st.setString(1, nome);
            st.setString(2, cidade);
            st.setString(3, endereco);
            st.setString(4, senha);
            st.setInt(5, id);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
