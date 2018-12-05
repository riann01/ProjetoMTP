package autenticar;

public class Autenticar {

    public static void main(String[] args) {
        System.setProperty("swing.aatext", "true" );
        System.setProperty("awt.useSystemAAFontSettings","on");
        new Conexao();
        new FazerLogin();
    }
    
}
