package modelDominio;

import java.io.Serializable;

public class Comprador extends Usuario implements Serializable {
    
    private static final long serialVersionUID = 123456789L;

    public Comprador(int codusuario, String nomecompleto, String email, String senha) {
        super(codusuario, nomecompleto, senha, email);
    }
    // Cadastro do Comprador //
    public Comprador(String nomecompleto, String email, String senha) {
        super(nomecompleto,email, senha);
    }
    
    public Comprador(int codusuario, String nomecompleto){
        super(codusuario, nomecompleto);
    }
    
    @Override
    public String toString() {
        return super.toString()+"Comprador: ";
    }
}
    