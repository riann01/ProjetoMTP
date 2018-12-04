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
import java.text.NumberFormat;
import java.util.Locale;

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
    private String modelo = "";
    
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
        }
        catch (SQLException e) {
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
        }
        catch (SQLException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mudarFoto (int id, File foto) {
        PreparedStatement st;
        try {
            FileInputStream fis = new FileInputStream(foto);
            st = conexao.getConnection().prepareStatement("UPDATE pessoa SET foto = ? WHERE id_pessoa = ?");
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
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT foto, id_pessoa FROM pessoa");
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
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String mostraNome (int idUsuario) {
        String nome1 = new String();
        PreparedStatement st;
        try {
            st = conexao.getConnection().prepareStatement("SELECT nome, id_pessoa FROM pessoa");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(2)==idUsuario) {
                    nome1 = rs.getString(1);
                }  
            }
            rs.close();
            st.close();
        }
        catch (SQLException ex) {
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
        }
        catch (SQLException e) {
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
        }
        catch (SQLException e) {
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
        try {
            st = conexao.getConnection().prepareStatement("SELECT *FROM carrinho");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ++this.cont;
            }
        }
        catch (SQLException e) {
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
        String model = "Todos";
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT nome_categoria FROM categoria");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                model = model+"/"+rs.getString(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String arrayModel [] = model.split("/");
        return arrayModel;
    }
    
    public String [] pegaModeloCatGerenciador() {
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
                conexao.inserirProdutoCarrinho(idUsuario, idProduto, quantidade);
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
        NumberFormat formatoReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String retorno = String.valueOf(formatoReal.format(Float.parseFloat(valor)));
        return retorno;
    }
    
    public void insereCatergoria (String nomeCategoria) {
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("INSERT INTO categoria (nome_categoria) VALUES (?)");
            st.setString(1, nomeCategoria);
            st.executeUpdate();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirCategoria (String nomeCategoria) {
        int quantidade = 0;
        int idCategoria = 0;
        String nomes = "";
        String mensagem = "";
        String quantidadeCasting;
        String quantidade2 = "";
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT id_categoria FROM categoria WHERE nome_categoria = ?");
            st.setString(1, nomeCategoria);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getInt(1);
            }
            rs.close();
            st.close();
            st = this.conexao.getConnection().prepareStatement("SELECT nome_produto FROM produto WHERE id_categoria = ?");
            st.setInt(1, idCategoria);
            rs = st.executeQuery();
            while (rs.next()) {
                nomes = nomes+"\n"+rs.getString(1);
                ++quantidade;
            }
            rs.close();
            st.close();
            if (quantidade>1) {
                quantidadeCasting = " itens";
                quantidade2 = " cadastrados.";
            }
            else {
                quantidadeCasting = " item";
                quantidade2 = " cadastrado.";
            }
            mensagem = "A categoria que você tentou excluir possui "+String.valueOf(quantidade)+quantidadeCasting+quantidade2+nomes;
            if (quantidade>0) {
                JOptionPane.showMessageDialog(null, mensagem, "Não foi possível excluir a categoria", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane jp = new JOptionPane();
                jp.showMessageDialog(null, "A categoria "+nomeCategoria+" será excluída, deseja continuar?", "Confirmar exclusão de categoria", JOptionPane.YES_NO_OPTION);
                if(jp.getOptionType()==-1) {
                    st = this.conexao.getConnection().prepareStatement("DELETE FROM categoria WHERE nome_categoria = ?");
                    st.setString(1, nomeCategoria);
                    st.executeUpdate();
                    st.close();
                    JOptionPane.showMessageDialog(null, "Informação", "Categoria excluída", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizaCategoria (String nomeCategoria, String novoNomeCategoria) {
        int idCategoria = 0;
        if (!(novoNomeCategoria==null)) {
            try {
                PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT id_categoria FROM categoria WHERE nome_categoria = ?");
                st.setString(1, nomeCategoria);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    idCategoria = rs.getInt(1);
                }
                st = this.conexao.getConnection().prepareStatement("UPDATE categoria SET nome_categoria = ? WHERE id_categoria = ?");
                st.setString(1, novoNomeCategoria);
                st.setInt(2, idCategoria);
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "A categoria foi atualizada", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public String [] pegaModeloProduto() {
        String model = "";
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT nome_produto FROM produto");
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
    
    public String [] pegaModeloPedido(int idPessoa) {
        String model = "";
        
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT id_pedido, data FROM pedido WHERE id_pessoa = ?");
            st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                model = tratarNumeroPedido(Integer.parseInt(rs.getString(1)))+" - Data: "+String.valueOf(rs.getDate(2))+"/"+model;
                modelo = rs.getString(1)+"/"+model;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String arrayModel [] = model.split("/");
        return arrayModel;
    }
    
    public String[] retornaPedidos () {
        String modeloPedidosSemTratamento[] = modelo.split("/");
        return modeloPedidosSemTratamento;
    }
    
    public String tratarNumeroPedido(int num) {
        String numeroTratado = "";
        if (num<10) {
            numeroTratado = "#0000"+String.valueOf(num);
        }
        else {
            if (num<100) {
                numeroTratado = "#000"+String.valueOf(num);
            }
            else {
                if (num<1000) {
                    numeroTratado = "#00"+String.valueOf(num);
                }
                if (num<10000) {
                    numeroTratado = "#0"+String.valueOf(num);
                }
                else {
                    if (num<100000) {
                        numeroTratado = "#"+String.valueOf(num);
                    }
                }
            }
        }
        return numeroTratado;
    }
    
    public void excluirProduto (String nomeProduto) {
        int contCarrinho = 0;
        int contPedido = 0;
        int idProduto = 0;
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT id_produto FROM produto WHERE nome_produto = ?");
            st.setString(1, nomeProduto);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                idProduto = rs.getInt(1);
            }
            rs.close();
            st.close();
            st = this.conexao.getConnection().prepareStatement("SELECT * FROM carrinho WHERE id_produto = ?");
            st.setInt(1, idProduto);
            rs = st.executeQuery();
            while (rs.next()) {
                ++contCarrinho;
            }
            rs.close();
            st.close();
            st = this.conexao.getConnection().prepareStatement("SELECT * FROM pedido_produto WHERE id_produto = ?");
            st.setInt(1, idProduto);
            rs = st.executeQuery();
            while (rs.next()) {
                ++contPedido;
            }
            rs.close();
            st.close();
            if (contPedido==0 && contCarrinho==0) {
                st = this.conexao.getConnection().prepareStatement("DELETE FROM produto WHERE id_produto = ?");
                st.setInt(1, idProduto);
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "O produto "+nomeProduto+" não pode ser excluído, há pedido(s) e/ou clientes com esse produto no carrinho", "Erro na exclusão", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int pegaIdProduto(String nomeProduto){
        int idProduto = 0;
        try {
            PreparedStatement st = this.conexao.getConnection().prepareStatement("SELECT id_produto FROM produto WHERE nome_produto = ?");
            st.setString(1, nomeProduto);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                idProduto = rs.getInt(1);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return idProduto;
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
}